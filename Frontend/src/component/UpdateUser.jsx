
import React, { Component } from "react";
import Joi from "joi-browser";
import UserService from '../service/userService';
// import './css/AddUser.css';

class UpdateUser extends Component {
    constructor(props) {
        super(props);
        this.state = {  
            user:{
                userId:0,
                email:"",
                password:"",
                role:"",
                loggedIn: false,
                
            },
            errors:{},
            errMsg:"",
        };
    }
     
  
 //schema to validate
 schema={
    userId: Joi.number().required(),
    email: Joi.string().min(1).required(),
     password: Joi.string().min(3).alphanum().required(),
     role: Joi.string().min(3),
     loggedIn: Joi.boolean(),
     
  
   }

validate=()=>{
    const errors={};
    const result = Joi.validate(this.state.user,this.schema, {
        abortEarly: false,
      });
    
    if (result.error !== null) {
        for (let err of result.error.details) {
          errors[err.path[0]] = err.message;
        }
      }
    return Object.keys(errors).length===0?null:errors;
}

componentDidMount=async ()=>{
    const user = await UserService.getUserById(this.props.match.params.id);
    this.setState({user:user.data});
}

  handleChange = (event) => {
    const user ={...this.state.user};
    user[event.target.name] = event.target.value;
    this.setState({user});
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const errors = this.validate();
    this.setState({errors:errors||{}});
    console.log(errors);
    if(errors) return;
    UserService.updateDetails(this.state.user,this.state.user.userId)
    .then(res=>this.props.history.push("/user"))
    .catch((error) => this.setState({ errMsg: error.response.data.message }));
  }        

  render() {
    return (
      <div className="w-50 mx-auto p-4 mt-5 " style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
         {this.state.errMsg && (
          <div className="alert alert-danger" role="alert">
            {this.state.errMsg}
            </div>
         )}
        UPDATE USER

        <form onSubmit={this.handleSubmit}>
         
        <div className="mb-3 text-start">
        <label htmlFor="userId">User ID</label>
        <input type="userId" 
                placeholder="user Id"
                id="userId"
                className="form-control"
                onChange={this.handleChange}
                disabled
                value={this.state.user.userId}
                name="userId"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.userId}
                </p>
                )}
        </div>


    
        <div className="mb-3 text-start">
        <label htmlFor="email">Email</label>        
                <input placeholder="Email" className="form-control"
                onChange={this.handleChange}
                value={this.state.user.email}
                name="email"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.email}
                </p>
                )}
        </div>
        <div className="mb-3 text-start">
        <label htmlFor="password">Password</label>        
                <input placeholder="password" className="form-control"
                onChange={this.handleChange}
                value={this.state.user.password}
                name="password"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.password}
                </p>
                )}
        </div>
        <div className="mb-3 text-start">
        <label htmlFor="role">Role</label>        
                <input placeholder="role" className="form-control"
                onChange={this.handleChange}
                value={this.state.user.role}
                name="role"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.role}
                </p>
                )}
        </div>
        
              
                <input type="submit" className="rounded button" value="UPDATE"></input>
            </form>
      </div>
    );
  }
}

export default UpdateUser;