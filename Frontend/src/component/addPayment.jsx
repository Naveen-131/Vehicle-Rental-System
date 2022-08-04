import React, { Component } from 'react';
import Joi from "joi-browser";
import paymentService from '../service/paymentService';
import './css/addPayment.css';

class AddPayment extends Component {
    state = {
    payment: { 
        "bookingId": 0,
        "paymentDate": "2021-08-24",
        "paymentId": 0,
        "paymentMode": "",
        "paymentStatus": ""
     },
     errors: {},
     errMsg: "",
    };
    // schema to validate
  schema = {
    bookingId: Joi.number().required(),
    paymentDate: Joi.string().required(),
    paymentId: Joi.number().required(),
    paymentMode: Joi.string().required(),
    paymentStatus: Joi.string().required(),
  };

  
  // form validation method
  validate = () => {
    const errors = {};
    // Validate account details with schema
    const result = Joi.validate(this.state.payment, this.schema, {
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
        const payment = { ...this.state.payment };
        payment[event.target.name] = event.target.value;
        //employee[empId]=1;
        console.log(event.target.name);
        console.log(event.target.value);
        this.setState({ payment: payment });
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
        paymentService.addPayment(this.state.payment)
          .then((res) => {
            this.props.history.push("/payments");
          })
          .catch((error) => this.setState({ errMsg: error.response.data.message }));
      };

    render()  {
        return (
          <div className="w-50 mx-auto mt-3">
            {this.state.errMsg && (
              <div className="alert alert-danger" role="alert">
                {this.state.errMsg}
              </div>
            )}
            <div className="border shadow-lg p-3">
              <h3 className="bg-secondary text-white p-1">Add Payment</h3>
              <form onSubmit={this.handleSubmit}>
                <div className="mb-3 text-start">
                  <label for="bookingId">Booking Id</label>
                  <input
                    type="text"
                    className="form-control"
                    id="bookingId"
                    name="bookingId"
                    value={this.state.payment.bookingId}
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.bookingId}
                    </p>
                  )}
                </div>
                <div className="mb-3 text-start">
                  <label for="paymentDate">Payment Date</label>
                  <input
                    type="text"
                    className="form-control"
                    id="paymentDate"
                    name="paymentDate"
                    value={this.state.payment.paymentDate}
                    placeholder="Enter Payment-Date"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.paymentDate}
                    </p>
                  )}
                </div>
                <div className="mb-3 text-start">
                  <label for="paymentId">Payment Id</label>
                  <input
                    type="text"
                    className="form-control"
                    id="paymentId"
                    name="paymentId"
                    value={this.state.payment.paymentId}
                    placeholder="Enter payment Id"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.paymentId}
                    </p>
                  )}
                </div>
                <div className="mb-3 text-start">
                  <label for="paymentMode">Payment Mode</label>
                  <input
                    type="text"
                    className="form-control"
                    id="paymentMode"
                    name="paymentMode"
                    value={this.state.payment.paymentMode}
                    placeholder="Enter Payment Mode"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.paymentMode}
                    </p>
                  )}
                </div>
                <div className="mb-3 text-start">
                  <label for="paymentStatus">PaymentStatus</label>
                  <input
                    type="text"
                    className="form-control"
                    id="paymentStatus"
                    name="paymentStatus"
                    value={this.state.payment.paymentStatus}
                    placeholder="Enter Payment Status "
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.paymentStatus}
                    </p>
                  )}
                </div>
                <div className="d-grid">
                  <button type="submit" className="btn  btn-secondary">
                    Submit
                  </button>
                </div>
              </form>
            </div>
          </div>
        );
      }
    }
 
export default AddPayment;