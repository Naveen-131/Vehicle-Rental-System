

import React, { useState } from "react";
import {
  Typography,
  TextField,
  InputLabel,
  FormControl,
  Select,
  Grid,
 
} from "@material-ui/core";

import axios from "axios";

const RegisterAdmin = (props) => {
  const [user, setUser] = useState({
   userId:0,
    email: "",
    password: "",
    role: "admin",
  },

  );
  const handleFormSubmit = (event) => {
    event.preventDefault();
    console.log("handleFormSubmit called");

    const usr = {
      userId: user.userId,      
      email: user.email,
       password: user.password,
       role: user.role,
      
    };

    axios.post("http://localhost:8081/user/add", usr).then((res) => {
      console.log(res);
      props.history.push("/user");
    });
  };
  const handleChange = (event) => {
    const usr = { ...user };
    usr[event.target.name] = event.target.value;
    setUser(usr);
  };

  return (
    
      <Grid
        item
        md={6}
        style={{
          marginTop: "10px",
          marginLeft: "auto",
          marginRight: "auto",
        }}
      >
          <div className="w-50 mx-auto p-5 mt-5 " style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
        <Typography variant="h6" className="pb-2">
        
          ADMIN REGISTRATION
        </Typography>
       
          <form onSubmit={handleFormSubmit} >

          <TextField className="pb-2"
              id="outlined-basic"
              label="User Id"
              placeholder="Enter userId"
              variant="outlined"
              name="userId"
              value={user.userId}
              onChange={handleChange}
              fullWidth
              style={{ marginBottom: 10 }}
            />

            <TextField className="pb-2"
              id="outlined-email"
              label="Email"
              placeholder="Enter email"
              variant="outlined"
              type="email"
              name="email"
              value={user.email}
              onChange={handleChange}
              fullWidth
              style={{ marginBottom: 10 }}
            />
           
            <TextField className="pb-2"
              id="outlined-password"
              label="Password"
              placeholder="Enter password"
              variant="outlined"
              type="password"
              name="password"
              value={user.password}
              onChange={handleChange}
              fullWidth
              style={{ marginBottom: 10 }}
            />
           

           
            <input type="submit" className="rounded button" value="Register"></input>
            
            
          </form>
       
        </div>
      </Grid>
    
  );
};

export default RegisterAdmin;

