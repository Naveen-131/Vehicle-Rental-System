import React, { Component } from "react";
import CustomerService from "../service/customerService";
import Joi from "joi-browser";
import './css/AddCustomer.css';

class AddCustomer extends Component {
  state = {
    customer: {
      customerId: 0,
      firstName: "",
      lastName: "",
      emailId: "",
      mobileNumber: "",
      state: "",
      city: "",
      address: ""

    },
    errors: {},
    errMsg: "",
  };


  // schema to validate
  schema = {
    customerId: Joi.number().min(1000).required(),
    firstName: Joi.string().min(3).max(30).alphanum().required(),
    lastName: Joi.string().min(1).alphanum().required(),
    emailId: Joi.string()
      .email({ minDomainSegments: 2, tlds: { allow: ["com"] } })
      .required(),
    mobileNumber: Joi.number().min(7000000000).max(9999999999).required(),
    address: Joi.string().min(3).max(50).alphanum().required(),
    state: Joi.string().min(3).max(30).alphanum().required(),
    city: Joi.string().min(3).max(30).alphanum().required()
  };

  // form validation method
  validate = () => {
    const errors = {};
    // Validate account details with schema
    const result = Joi.validate(this.state.customer, this.schema, {
      abortEarly: false,
    });
    console.log(result);

    // Initialize error object with errors, if validate method returns errors
    if (result.error !== null) {
      for (let err of result.error.details) {
        errors[err.path[0]] = err.message;
      }
    }

    // return null if no errors otherwise return errors
    return Object.keys(errors).length === 0 ? null : errors;
  };



  handleChange = (event) => {
    const customer = { ...this.state.customer };
    customer[event.target.name] = event.target.value;
    //employee[empId]=1;
    console.log(event.target.name);
    console.log(event.target.value);
    this.setState({ customer: customer });
  };

  handleSubmit = (event) => {
    // Prevents default behaviour of submit button
    event.preventDefault();
    const errors = this.validate(); // null / errors
    // Set state error object with errors or empty object based on
    // errors return by the validate() method
    this.setState({ errors: errors || {} });
    // if errors exists in the form , return to the login page
    console.log(errors);
    if (errors) return;
    CustomerService.createCustomer(this.state.customer)
      .then((res) => {
        this.props.history.push("/customers");
      })
      .catch((error) => this.setState({ errMsg: error.response.data.message }));
  };

  

  render() {
    return (
      <div className="w-50 mx-auto p-4 mt-5 " style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
      {this.state.errMsg && (
       <div className="alert alert-danger" role="alert">
         {this.state.errMsg}
         </div>
      )}
      ADD CUSTOMER
          <form onSubmit={this.handleSubmit}>
            <div className="mb-3 text-start">
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
            </div>
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
              <label htmlFor="emailId">Email Address</label>
              <input
                type="emailId"
                className="form-control"
                id="emailId"
                name="emailId"
                aria-describedby="emailHelp"
                onChange={this.handleChange}
                value={this.state.customer.emailId}
                placeholder="Enter employee email"
               
              />
              {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.emailId}
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
            <div>
              <button type="submit" className="rounded button" value="ADD">
                ADD
              </button>
            </div>
          </form>
        </div>
    
    );
  }
}


export default AddCustomer;