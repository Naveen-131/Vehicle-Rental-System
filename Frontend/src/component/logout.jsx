import React, { useEffect } from "react";

import { useSelector, useDispatch } from "react-redux";
import { logoutAction } from "../actions/loginAction";

const  Logout  =  ( )  =>  {
  const dispatch = useDispatch();
  const login = useSelector((state) => state.login);
  useEffect(() => {
    dispatch(logoutAction(login.email));
    setTimeout(()=>{window.location.replace("http://localhost:3000/")},3000)
  },[login.email,dispatch]);
  return <h2 onLoad={()=>{window.location.replace("http://localhost:3000/")}} style={{color:"#ffbe00",textAlign:"center"}}>Logout successful Redirecting to homepage</h2>
};

export  default  Logout ;