import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Home from './components/home';
import Login from './components/login';
import RegisterPatient from './components/registerpatient';
import Doctorregister from './components/doctorreg';
import Pharmareg from './components/pharmareg';
import Pathlabreg from './components/pathlabreg';

function App() {
  return (
  <>
    <Routes>
    <Route path='/' element={<Home/>}/>
    <Route path='/registerpatient' element={<RegisterPatient/>}/>
    <Route path='/doctorregister' element={<Doctorregister/>}/>
    <Route path='/pharmacistregister' element={<Pharmareg/>}/>
    <Route path='/pathlabregister' element={<Pathlabreg/>}/>  
    <Route path='/login' element={<Login/>}/>  
    </Routes>
    </>
  );
}

export default App;
