import logo from './logo.svg';
import './App.css';
import { UserProfileList, UserProfileLogin, UserProfileRegistration } from './components/RealProfile';
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
            <Route path = '/login' element = {<div>Login under construction</div>} />
            <Route path = '/list' element = {<UserProfileList />} />
            <Route path = '/success/:id/*' element = {<div>Success under construction</div>} />
          </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
