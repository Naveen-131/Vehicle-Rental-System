import React, { Component } from "react";
import Joi from "joi-browser";
import UserService from '../service/userService';
import CustomerService from "../service/customerService";

//import './css/AddUser.css';

class AddUser extends Component {
    constructor(props) {
        super(props);
        this.state = {  
            user:{
                userId:0,
                email:"",
                password:"",
                role:"customer",
  
            },
            customer: {
              customerId:0,
              firstName: "",
              lastName: "",
              mobileNumber: "",
              state: "",
              city: "",
              address: ""
        
            },
            errors:{},
            errMsg:"",
        };
    }
  
  
 //schema to validate
 schema = {
    userId:Joi.number().min(1000).required(),
    email:Joi.string().email({ minDomainSegments: 2, tlds: { allow: ['com', 'net'] } }).required(),
    password:Joi.string().min(1).required(),
    role:Joi.string().min(1).required(),
    firstName: Joi.string().min(3).max(30).alphanum().required(),
    lastName: Joi.string().min(1).alphanum().required(),
    mobileNumber: Joi.number().min(7000000000).max(9999999999).required(),
    address: Joi.string().min(3).max(50).alphanum().required(),
    state: Joi.string().min(3).max(30).alphanum().required(),
    city: Joi.string().min(3).max(30).alphanum().required()
    
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


  handleChange = (event) => {
    const user ={...this.state.user};
    user[event.target.name] = event.target.value;
    this.setState({user});

    //customer 

    const customer = { ...this.state.customer };
    customer["customerId"] = this.state.user.userId;
    customer[event.target.name] = event.target.value;
    //employee[empId]=1;
    console.log(event.target.name);
    console.log(event.target.value);
    this.setState({ customer: customer });
    
  };

  handleSubmit = (event) => {
    event.preventDefault();
        const errors = this.validate();
        this.setState({errors:errors||{}});
        console.log(errors)
        if(errors) return;

        console.log(this.state)

        CustomerService.createCustomer(this.state.customer)
      .then((res) => {
        UserService.addUser(this.state.user)
        .then(res=>this.props.history.push("/home"))
        .catch((error) => this.setState({ errMsg: error.response.data.message }));
      })
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
        REGISTER

        <form onSubmit={this.handleSubmit}>
         
        <div className="mb-3 text-start">
        <label htmlFor="userId">User ID</label>
        <input placeholder="User Id" className="form-control"
                onChange={this.handleChange}
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
                <input placeholder="Password" className="form-control"
                type = "password"
                onChange={this.handleChange}
                value={this.state.user.password}
                name="password"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.password}
                </p>
                )}
        </div>


        {/* <div className="mb-3 text-start">
              <label htmlFor="empId">Customer Id</label>
              <input
                type="text"
                className="form-control"
                id="customerId"
                name="customerId"
                onChange={this.handleChange}
                value={this.state.customer.customerId}
              

                
              />
              {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.customerId}
                </p>
              )}
        </div> */}

      

        <div className="mb-3 text-start">
              <label htmlFor="firstName">First Name</label>
              <input
                type="text"
                className="form-control"
                id="firstName"
                name="firstName"
                onChange={this.handleChange}
                value={this.state.customer.firstName}
                placeholder="Enter customer first name"
                
              />
              {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.firstName}
                </p>
              )}
            </div>


            <div className="mb-3 text-start">
              <label htmlFor="lastName">Last Name</label>
              <input
                type="text"
                className="form-control"
                id="lastName"
                name="lastName"
                onChange={this.handleChange}
                value={this.state.customer.lastName}
                placeholder="Enter customer last name"
                
              />
              {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.lastName}
                </p>
              )}
            </div>


      


            <div className="mb-3 text-start">
              <label htmlFor="contactNo">Mobile Number</label>
              <input
                type="tel"
                className="form-control"
                id="mobileNumber"
                name="mobileNumber"
                onChange={this.handleChange}
                value={this.state.customer.mobileNumber}
                placeholder="Enter customer contact number"
                
              />
              {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.mobileNumber}
                </p>
              )}
            </div>


            <div className="mb-3 text-start">
              <label htmlFor="state">State</label>
              <input
                type="text"
                className="form-control"
                id="state"
                name="state"
                onChange={this.handleChange}
                value={this.state.customer.state}
                placeholder="Enter customer state"
               
              />
              {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.state}
                </p>
              )}
            </div>


            <div className="mb-3 text-start">
              <label htmlFor="address">Address</label>
              <input
                type="text"
                className="form-control"
                id="address"
                name="address"
                onChange={this.handleChange}
                value={this.state.customer.address}
                placeholder="Enter customer address"
               
              />
              {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.address}
                </p>
              )}
            </div>

            <div className="mb-3 text-start">
              <label htmlFor="city">City</label>
              <input
                type="text"
                className="form-control"
                id="city"
                name="city"
                onChange={this.handleChange}
                value={this.state.customer.city}
                placeholder="Enter customer city"
               
              />
              {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.city}
                </p>
              )}
            </div>


                
                <input type="submit" className="rounded button" value="Register"></input>
            </form>
      </div>
    );
  }
}

export default AddUser;