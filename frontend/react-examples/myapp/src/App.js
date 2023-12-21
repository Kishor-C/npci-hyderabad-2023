import logo from './logo.svg';
import './App.css';
import { UserProfileList, UserProfileLogin, UserProfileRegistration, UserProfileSuccess } from './components/RealProfile';
import { Link, Routes, Route } from 'react-router-dom';
// <App /> is used in index.js
function App() {
  
  return (
    <div className = 'container-fluid'>
      <h2 className = 'alert alert-primary text-center'>Profile Management App</h2>
      
      <div className='row'>
        <div className = 'col'>
          <Routes>
            <Route path = '' element = {<UserProfileLogin />}/>
            <Route path = '/register' element = {<UserProfileRegistration />} ></Route>
            <Route path = '/login' element = {<UserProfileLogin />} />
            <Route path = '/list' element = {<UserProfileList />} />
            <Route path = '/success/:id/*' element = {<UserProfileSuccess />} />
          </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
