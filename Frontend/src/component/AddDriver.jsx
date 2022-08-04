import React, { Component } from "react";
import Joi from "joi-browser";
import DriverService from '../service/driverService';
import './css/AddDriver.css';

class AddDriver extends Component {
    constructor(props) {
        super(props);
        this.state = {  
            driver:{
                firstName:"",
                lastName:"",
                contactNumber:"",
                address:"",
                email:"",
                chargesPerDay:0,
                licenseNo:""
            },
            errors:{},
            errMsg:"",
        };
    }
  
  
 //schema to validate
 schema = {
    firstName:Joi.string().min(3).required(),
    lastName:Joi.string().min(1).required(),
    contactNumber:Joi.string().min(10).required(),
    address:Joi.string().required(),
    email:Joi.string().email({ minDomainSegments: 2, tlds: { allow: ['com', 'net'] } }).required(),
    chargesPerDay:Joi.number().required(),
    licenseNo:Joi.string().min(15).required()
}

validate=()=>{
    const errors={};
    const result = Joi.validate(this.state.driver,this.schema, {
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
    const driver ={...this.state.driver};
    driver[event.target.name] = event.target.value;
    this.setState({driver});
  };

  handleSubmit = (event) => {
    event.preventDefault();
        const errors = this.validate();
        this.setState({errors:errors||{}});

        if(errors) return;

        DriverService.createDriver(this.state.driver)
        .then(res=>this.props.history.push("/home"))
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
        ADD DRIVER

        <form onSubmit={this.handleSubmit}>
         
        <div className="mb-3 text-start">
        <label htmlFor="firstName">First Name</label>
        <input placeholder="First Name" className="form-control"
                onChange={this.handleChange}
                value={this.state.driver.firstName}
                name="firstName"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.firstName}
                </p>
                )}
        </div>
        <div className="mb-3 text-start">
        <label htmlFor="lastName">Last Name</label>        
                <input placeholder="Last Name" className="form-control"
                onChange={this.handleChange}
                value={this.state.driver.lastName}
                name="lastName"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.lastName}
                </p>
                )}
        </div>
        <div className="mb-3 text-start">
        <label htmlFor="email">Email</label>        
                <input placeholder="Email" className="form-control"
                onChange={this.handleChange}
                value={this.state.driver.email}
                name="email"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.email}
                </p>
                )}
        </div>
        <div className="mb-3 text-start">
        <label htmlFor="address">Address</label>        
                <input placeholder="Address" className="form-control"
                onChange={this.handleChange}
                value={this.state.driver.address}
                name="address"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.address}
                </p>
                )}
        </div>
        <div className="mb-3 text-start">
        <label htmlFor="contactNumber">Contact Number</label>        
                <input placeholder="Contact Number" className="form-control"
                onChange={this.handleChange}
                value={this.state.driver.contactNumber}
                name="contactNumber"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.contactNumber}
                </p>
                )}
        </div>
        <div className="mb-3 text-start">
        <label htmlFor="chargesPerDay">Charge per day</label>
                <input placeholder="Charge per day" className="form-control" type="number"
                onChange={this.handleChange}
                value={this.state.driver.chargesPerDay}
                name="chargesPerDay"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.chargesPerDay}
                </p>
                )}
        </div>
        <div className="mb-3 text-start">
        <label htmlFor="licenseNo">License Number</label>        
                <input placeholder="License Number" className="form-control"
                onChange={this.handleChange}
                value={this.state.driver.licenseNo}
                name="licenseNo"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.licenseNo}
                </p>
                )}
        </div>        
                <input type="submit" className="rounded button" value="ADD"></input>
            </form>
      </div>
    );
  }
}

export default AddDriver;