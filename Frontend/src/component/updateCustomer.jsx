import React, { Component } from "react";
import CustomerService from "../service/customerService";
import './css/AddCustomer.css';

class UpdateCustomer extends Component {
  constructor(props) {
    super(props);
    this.state = {customer:
    { 
      customerId: 0,
      firstName: "",
      lastName: "",
      emailId: "",
      mobileNumber: "",
      city: "",
      state:""
    }};
}
  

  componentDidMount() {
    CustomerService.getCustomerById(this.props.match.params.id).then((res) =>
      this.setState({ customer : res.data },()=>{console.log(this.state)})
    );
  }
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
    CustomerService.updateCustomer(this.state.customer).then((res) => {
      this.props.history.push("/customers");
    });
  };
  render() {
    return (
      <div className="w-50 mx-auto p-4 mt-5 " style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
        Update Customer
        <form onSubmit={this.handleSubmit}>
          <div className="mb-3 text-start">
            <label htmlFor="empId">Customer Id</label>
            <input
              type="text"
              className="form-control"
              id="customerId"
              name="customerId"
              disabled
              onChange={this.handleChange}
              value={this.state.customer.customerId}
             
            />
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
              placeholder="Enter customer firstName"
             
            />
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
              placeholder="Enter customer lastName"
             
            />
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
              placeholder="Enter customer email"
             
            />
          </div>
          <div className="mb-3 text-start">
            <label htmlFor="mobileNumber">Mobile Number</label>
            <input
              type="tel"
              className="form-control"
              id="mobileNumber"
              name="mobileNumber"
              onChange={this.handleChange}
              value={this.state.customer.mobileNumber}
              placeholder="Enter customer Mobile Number"
              
            />
          </div>
          <div className="mb-3 text-start">
            <label htmlFor="address">Address</label>
            <input
              type="tel"
              className="form-control"
              id="address"
              name="address"
              onChange={this.handleChange}
              value={this.state.customer.address}
              placeholder="Enter customer address"
              
            />
          </div>
          <div className="mb-3 text-start">
            <label htmlFor="city">City</label>
            <input
              type="tel"
              className="form-control"
              id="city"
              name="city"
              onChange={this.handleChange}
              value={this.state.customer.city}
              placeholder="Enter customer city"
              
            />
          </div>
          <div className="mb-3 text-start">
            <label htmlFor="state">State</label>
            <input
              type="tel"
              className="form-control"
              id="state"
              name="state"
              onChange={this.handleChange}
              value={this.state.customer.state}
              placeholder="Enter customer state"
              
            />
          </div>
          <button type="submit" className="rounded button" value="ADD">
            UPDATE
          </button>
        </form>
      </div>
    );
  }
}

export default UpdateCustomer;