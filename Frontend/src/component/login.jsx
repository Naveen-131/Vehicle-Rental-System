import React,{useState} from "react";
import { useDispatch ,useSelector} from "react-redux";
import { makeStyles } from '@material-ui/styles';
import Alert from "@material-ui/lab/Alert";
import {
  TextField,
  Container,
  Typography,
  Select,
  InputLabel,
  FormControl,
  MenuItem,
  Grid,
  Box,
} from "@material-ui/core";
import { loginAction } from "../actions/loginAction";


const theme = { spacing: 8 };
const useStyles = makeStyles((theme) => ({
  root: {
    "& > *": {},
  },
}));
const Login = (props) => {
  const[user,setUser]=useState({
    email:"",
    password:"",
    role:"",
  });


  const dispatch = useDispatch();
  const login = useSelector((state) => state.login);
  const classes = useStyles();
  const handleChange = (event) => {
    console.log("HandleChange");
    const usr = { ...user };
    usr[event.target.name] = event.target.value;
    //this.setState({ user: user });
    setUser(usr);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(user,login);
    dispatch(loginAction(user));
  };


  return (
    <Container >
      <div className="w-50 mx-auto p-1 pe-1 m-5 " style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
       
      <Box my={2}  >
     
        <Typography variant="h5">Login </Typography>
      </Box>
      <Grid
        item
        xs={12}
        sm={6}
        style={{ marginLeft: "auto", marginRight: "auto" }}
      >
         {login.errMsg && <Alert severity="error">{login.errMsg}</Alert>}
          <form 
          onSubmit={handleSubmit}
          className={classes.root}
          noValidate 
          autoComplete="off"
          >
          <Box mb={3}>
              <TextField
                id="outlined-basic"
                fullWidth
                label="Email"
                type="email"
                variant="outlined"
                name="email"
                value={user.email}
                onChange={handleChange}
              />
            </Box>
            <Box mb={3}>
              <TextField
                id="outlined-password-input"
                label="Password"
                type="password"
                autoComplete="current-password"
                variant="outlined"
                fullWidth
                name="password"
                value={user.password}
                onChange={handleChange}
              />
            </Box>
            <FormControl
              variant="outlined"
              fullWidth
              className={classes.formControl}
            >
              <InputLabel id="demo-simple-select-outlined-label">
                Role
              </InputLabel>
              <Select
                labelId="demo-simple-select-outlined-label"
                id="demo-simple-select-outlined"
                onChange={handleChange}
                name="role"
                value={user.role}
                label="Role"
              >
                <MenuItem value="">
                  <em>None</em>
                </MenuItem>
                <MenuItem value="admin">admin</MenuItem>
                <MenuItem value="customer">customer</MenuItem>
              </Select>
            </FormControl>
            <Box mt={3}>
            <input type="submit" className="rounded button" value="Login"></input>
            </Box>
          </form>
        
      </Grid>
      </div>
    </Container>
  );
};


export  default  Login ;



