import logo from './logo.svg';
import './App.css';
import { Greetings, Hello } from './components/Simple';
import { Profile, ProfileTable } from './components/Profile';
import { MyForm } from './components/Users';
// <App /> is used in index.js
function App() {
  let title = 'React App';
  let profile = {
    name : 'Kishor', 
    email : 'kishor@gmail.com',
    imageUrl : 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSK2cPRTIAXWQO6sl7II4Wzmvh52osVkFH2a7qEEpcJLbqoHFuMyRha9YXmoGMJLGzqR5M&usqp=CAU',
    address : {state: 'Karnataka', city : 'Bangalore'},
    occupation: 'Self Employed'
  };
  let items = ['Laptop', 'Mobile', 'TV', 'Fridge'];
  return (
    <div className = 'container-fluid'>
      <h1 className='txt-center'>Welcome to {title}</h1>
      <MyForm />
      <ProfileTable />
      <Profile prof = {profile}/>
      <ol>
        {items.map((value, index) =><li key = {index}>{value}</li>)}
      </ol>
      
      <Greetings />
      <Greetings />
      <Hello />
      <Hello username = 'Alex' age = '30' />
      <Hello username = {title} age = '40' />

    </div>
  );
}

export default App;
