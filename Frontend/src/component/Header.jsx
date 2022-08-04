import React from 'react';
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import logo from '../assets/icons8-car-64.png';
const Header = () => {
    const login = useSelector((state) => state.login);
    return (
    <div style={{backgroundColor:"black",height:"50px"}} className="d-flex">
    <Link to="/"><img src={logo} alt="logo" className="ms-3 mb-3"/></Link>
    <div className="w-100 d-flex justify-content-end">
        {login.loggedIn?
        <Link to="/logout" className="p-2 pe-4 fs-5" style={{textDecoration:"none",color:"#FFBE00"}}>LOGOUT</Link>:
        <div className="d-flex">
        <Link to="/register/user" className=" p-2 fs-5" style={{textDecoration:"none",color:"#FFBE00"}}>REGISTER</Link>
        <Link to="/login" className="p-2 pe-4 fs-5" style={{textDecoration:"none",color:"#FFBE00"}}>LOGIN</Link>
        </div>
        }
    </div>
    </div>
    );
}
 
export default Header;