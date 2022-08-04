import React from 'react';
import { useSelector } from 'react-redux';
import { Redirect, Route } from 'react-router-dom';

const AdminRoute = ({component:Component,...rest})=>{
    const user = useSelector((state)=>state.login);

    return(
        <Route
        {...rest}
        render={props => 
         user.loggedIn && user.role==="admin" ? (
             <Component {...props}/>
         ) : (
             <Redirect to={{
                 pathname:"/",
                 state:{from:props.location}
             }}
             />
         )
         
        }
        />
    )
}

export default AdminRoute;