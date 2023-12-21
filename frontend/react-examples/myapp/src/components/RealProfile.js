// this file talks to the real backend api's, since we already have Profile component
// we will create UserProfile as a prefix to work with all the backend
import axios from 'axios';
import { useState, useEffect } from 'react';
import { Link, Route, Routes, useNavigate, useParams } from 'react-router-dom';
let BASE_URL = 'http://localhost:9091/api/profiles';

// success component
export function UserProfileSuccess() {
    let { id } = useParams(); // import {useParams} from 'react-router-dom';
    let [profile, setProfile] = useState([]);
    //useEffect hook used when you want to call a callback when any change happens in the component
    // useEffect(callback, []);
    useEffect(() => {
        axios.get(BASE_URL + '/' + id)
            .then(r => {
                console.log(r);
                setProfile(r.data)
            });
    }, []);
    return (<div>
        <div className='row'>
            <div className='col-3'>
                <div>
                    <h3>Hello {profile.name}</h3>
                    <h4>Phone: {profile.phone}</h4>
                    <h4>Birthday: {profile.birthday}</h4>
                </div>
            </div>
            <div className='col-7'>
                <div>
                    <Link to='dashboard'>Dashboard</Link> |
                    <Link to='addContact'>Add Contact</Link> |
                    <Link to='listContacts'>Show All Contacts</Link> |
                    <Link to='editProfile'>Edit Profile</Link>
                    <div>
                        <Routes>
                            <Route path=''
                                element={<div>Dashboard component,total: {profile.contacts?.length}</div>}></Route>
                            <Route path='dashboard'
                                element={<div>Dashboard component,total: {profile.contacts?.length}</div>}></Route>
                            <Route path='addContact' element={<div>Add Contact component</div>}></Route>
                            <Route path='listContacts' element={<div>List Contact component</div>}></Route>
                        </Routes>
                    </div>
                </div>
            </div>
        </div>



    </div>)
}

// login to the profile
export function UserProfileLogin() {
    let [id, setId] = useState('');
    let [error, setError] = useState(''); // if profile not found set this error
    // callback to login by only id
    let navigate = useNavigate();  // import {useNavigate} from 'react-router-dom';
    let loginById = (e) => {
        e.preventDefault();
        //send only id to the backend, in then() call useNavigate() to navigate programatically
        axios.get(BASE_URL + '/' + id)
            .then(res => navigate('/success/' + id))
            .catch(e => {
                console.log(e); // e.response.data.error gives us the error message
                setId('');
                setError(e.response.data.error);
            });
    };
    return (<div className='w-25'>
        <h2>Login Form</h2> <hr />
        <form onSubmit={loginById}>
            <input type='number' autoComplete='off' className='form-control'
                value={id} onChange={e => setId(e.target.value)} />
            <input type='submit' value='Login' className='btn btn-secondary'></input>
            <div>
                {error != '' ? <div className='text-danger'>{error}</div> : <div></div>}
            </div>
            <div>
                <Link to='/register'>Create Profile</Link>
            </div>
        </form>
    </div>)
}

// Storing the profile by calling the backend api
export function UserProfileRegistration() {
    // states for name, phone, birthday, password, id and message that is initialized after storing
    let [name, setName] = useState('');
    let [id, setId] = useState(''); // we get after storing
    let [password, setPassword] = useState('');
    let [phone, setPhone] = useState('');
    let [birthday, setBirthday] = useState('');
    let [message, setMessage] = useState('');// to show success message
    // handler to store the form data - will write the code inside it, after creating the forms
    let store = (e) => {
        e.preventDefault();
        // axios calls for HTTP POST - write this after creating the form
        axios.post(BASE_URL, { "name": name, "password": password, "phone": phone, "birthday": birthday })
            .then(r => {
                setId(r.data.id);
                setMessage(`Profile stored with an id: ${r.data.id}`);
                setName(''); setPassword(''); setBirthday(''); setPhone('');
            })
            .catch(err => console.log(err))
    }
    return (<div className='w-25'>
        <h2>Registration Form</h2>
        <form onSubmit={store}>
            <div>
                <input type='text' placeholder='Enter name' autoComplete='off' value={name}
                    className='form-control' onChange={e => setName(e.target.value)} />
            </div>
            <div>
                <input type='password' placeholder='Enter password' value={password}
                    className='form-control' onChange={e => setPassword(e.target.value)} />
            </div>
            <div>
                <input type='number' placeholder='Enter phone no.' value={phone}
                    className='form-control' onChange={e => setPhone(e.target.value)} />
            </div>
            <div>
                Select Birthday <input type='date' value={birthday} className='form-control'
                    onChange={e => setBirthday(e.target.value)}></input>
            </div>
            <div>
                <input type='submit' value='Register' className='btn btn-secondary'></input>
                <input type='reset' value='Reset' className='btn btn-secondary'></input>
            </div>
            <div>
                {id != '' ? <div className='text-success'>{message}</div> : <div></div>}
            </div>
        </form>
    </div>)

}

// Lists all the profiles in a table format
export function UserProfileList() {
    //state to store the profiles
    let [profiles, setProfiles] = useState([]);
    //handler that sends request to the backend
    let loadProfiles = (e) => {
        axios.get(BASE_URL)
            .then(response => setProfiles(response.data))
            .catch(error => console.log(error));
    };
    return (<div>
        <h2>List of profiles</h2> <hr />
        <button onClick={loadProfiles} className='btn btn-secondary'>Load All Profiles</button>
        <div className='row'>
            {
                profiles.map((item, index) => <p key={index}> Id: {item.id}, Name: {item.name},
                    Birthday: {item.birthday}, No of contacts: {item.contacts.length}
                </p>)
            }
        </div>
        <h3>Displaying the same output using card, with dummy images</h3>
        <div className='row'>
            {
                profiles.map((item, index) => <div key={index} className='col-4'>
                    <div className="card" style={{ width: '18rem' }}>
                        <img src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAKgAAACUCAMAAAAwLZJQAAAAMFBMVEXk5ueutLfp6+y2vL6rsbWor7KyuLu6v8LT1tjY29zb3t/Gysze4eLDx8rP09TJzc8ZZtZUAAAD90lEQVR4nO2c246jMAxAickVCPn/v90And22gtaJwWa0OS8jjebhyIlNLs50XaPRaDQajUaj0Wg0Go1G10E3DWGex5hJPgwdgLTSHtD56Kw2Ri/kH9aNvrudKgSnlFYvaK1snO6lGnrzZvkja1yQlvtLjqbe19zi6u4S1fhBc1VVSVqxW8JpP2sumF48qDC/p9B+UK30TE0Iy011Fo1pNFhRZQRNYcR7LjEVE02Y6fkUUy+jCXOZZzadZExLPZXuRTz7YlGlo4DnWO65TFP21J8qNBe4RcHVBHQZfGbToaSCPmMHVk9wlZ5Kj6yiodYzw1pMY90MXTCJcZZOlhBRzsT3tam0hpQvnWpr0wO+CgWUgOYKxeXZBaIo17YECteh77DtSuqr/UOUbffcE0W5FnsDqYpmuNbPgSpqmb6inujJ9bmHmeqpeb5N5bvPd5g+oieI8lT8/0iUaY7Ss14zlSfKPmSDS5Rc8Hk8iRuRPPKOSRR+y6Lk1yzzyPWJ7UB3Im5F2LahQItoz7cLrTob/YHzImegiBo2za7qWPxvQPlGPkPIe6al04P6jxPbZ2kDqs8d+Tb1D9PaUsp91QSpzlTg/qYq8bXlv2KuWz4L3IaW3YE/ELkJB0QzySvayfQWlBZTiQm6UTZNNdfZ2J5p0TTlvVx8AfAxzfEUbdPBtGetnv0g3aJlMcNveJci+6SvvWTact5/HgLhS1CNEx/2H+ZPbZlWqN1pD4DU704ArRz/cukjS4ezfevK1caO4X5dzpkhOW3WWaC1US4JVvgvAEA3BO99mG7a2/4AXpHW2WGxmsKcYnSuzzjn4jjnwN5GdxX0KS4vBcxrMq2/yVN1nMMwyeYUwOCj65X5VPCXVw7WxSSX/xCiXZ8vYMh/ZR3/RiSPt4/q4DHDMcYsJYsvsAA+Hj25+BbYPAsS08IUumSR473vqhTLS5cwfkwdZFydv9YVJod6yPBdVfcXLlagO0lzVVX2IlWYxroEOsS4cIEqzITj8AO0iqcXq4l4W3ekevb4f9pr0DDuzPOTgkc2xZwXVBiKj+0KVU/aTJPab1GcMvy060QkuidnP7jL47lCPkIj9LEXmpJOU4hd1yWQjiUZPRfqM4ojj56oPTqnt7YVUntpQmxirzGtekpQ+wSMZFqzT2UrTM9UTFPuCbpRMU0lNFX5C+f6DgcqZZ2QBRddZ1OY+byfpBeKGuJIDVhE9IgPKfM3/o2CTjNiNyNVFL0zoT6sooLvP6A2W1PBHqDI1aYN7KthQP9Lj6tEsZtS0ZxfwZXSidi9Tgf57zcGaU9sR+T1JyNfwTV2VPYxngmukoqt8P5hUKKj7aXBLUrhBqBEG41b8QcZDDNkChgRlgAAAABJRU5ErkJggg=='
                            className="card-img-top" style={{ height: '30vh' }} />
                        <div className="card-body">
                            <h5 className="card-title">Name: {item.name}</h5>
                            <p>Id: {item.id}</p>
                            <p>Phone: {item.phone}</p>
                            <p>Birthday: {item.birthday}</p>
                            <p>No. of contacts: {item.contacts.length}</p>
                        </div>
                    </div>
                </div>)
            }
        </div>
    </div>)
}