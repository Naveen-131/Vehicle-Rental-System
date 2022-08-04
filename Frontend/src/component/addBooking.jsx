import React, { Component } from "react";
import BookingService from "../service/bookingService";
import Joi from "joi-browser";
import { Select, MenuItem } from "@material-ui/core";

class AddBooking extends Component {
  state = {
    bookings: {
      bookingId: 0,
      customerId: 0,
      bookedTillDate: "",
      bookingDate: "",
      bookingDescription: "",
      distance: 0,
      totalCost: 0,
      deliveryMode: "",
    },
    errors: {},
    errMsg: "",
  };

  // schema to validate
  schema = {
    bookingId: Joi.number().min(2000).max(9000).required(),
    customerId: Joi.number().min(1001).max(9999).required(),
    bookingDate: Joi.date().iso().min("01-08-2021").required(),
    bookedTillDate: Joi.date().iso().required(),
    bookingDescription: Joi.string().min(2).alphanum().required(),
    distance: Joi.number().min(2).max(500).required(),
    totalCost: Joi.number().min(100).max(1000).required(),
    deliveryMode: Joi.string().min(2).required(),
  };

  // form validation method
  validate = () => {
    const errors = {};
    // Validate account details with schema
    const result = Joi.validate(this.state.bookings, this.schema, {
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
    const bookings = { ...this.state.bookings };
    bookings[event.target.name] = event.target.value;
    //employee[empId]=1;
    console.log(event.target.name);
    console.log(event.target.value);
    this.setState({ bookings: bookings });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    // Prevents default behaviour of submit button
    const errors = this.validate(); // null / errors
    // Set state error object with errors or empty object based on
    // errors return by the validate() method
    this.setState({ errors: errors || {} });
    // if errors exists in the form , return to the login page
    console.log(errors);

    if (errors) return;

    BookingService.createBooking(this.state.bookings)
      .then((res) => {
        this.props.history.push("/bookings");
      })
      .catch((error) => this.setState({ errMsg: error.response.data.message }));
  };
  render() {
    return (
      <div
        className="w-50 mx-auto p-4 mt-5 "
        style={{
          borderColor: "#FFBE00",
          borderStyle: "solid",
          borderRadius: "8px",
        }}
      >
        {this.state.errMsg && (
          <div className="alert alert-danger" role="alert">
            {this.state.errMsg}
          </div>
        )}
        Add Booking
        <form onSubmit={this.handleSubmit}>
          <div className="mb-3 text-start">
            <label for="bookingId">Booking Id</label>
            <input
              type="text"
              className="form-control"
              id="bookingId"
              name="bookingId"
              onChange={this.handleChange}
              value={this.state.bookings.bookingId}
            />
            {this.state.errors && (
              <p className="text-danger font-monospace text-start">
                {this.state.errors.bookingId}
              </p>
            )}
          </div>

          <div className="mb-3 text-start">
            <label htmlFor="customerId">customer Id</label>
            <input
              type="text"
              className="form-control"
              id="customerId"
              name="customerId"
              onChange={this.handleChange}
              value={this.state.bookings.customerId}
            />
            {this.state.errors && (
              <p className="text-danger font-monospace text-start">
                {this.state.errors.customerId}
              </p>
            )}
          </div>

          <div className="mb-3 text-start">
            <label htmlFor="bookingDate">Booking Date</label>
            <input
              type="Date"
              className="form-control"
              id="bookingDate"
              name="bookingDate"
              onChange={this.handleChange}
              value={this.state.bookings.bookingDate}
              //placeholder="Enter employee firstName"
            />
            {this.state.errors && (
              <p className="text-danger font-monospace text-start">
                {this.state.errors.bookingDate}
              </p>
            )}
          </div>

          <div className="mb-3 text-start">
            <label htmlFor="bookingTillDate">bookingTillDate</label>
            <input
              type="Date"
              className="form-control"
              id="bookedTillDate"
              name="bookedTillDate"
              onChange={this.handleChange}
              value={this.state.bookings.bookedTillDate}
              // placeholder="Enter booking till date"
            />
            {this.state.errors && (
              <p className="text-danger font-monospace text-start">
                {this.state.errors.bookingTillDate}
              </p>
            )}
          </div>
          <div className="mb-3 text-start">
            <label for="bookingDescription">Booking Description</label>
            <input
              type="text"
              className="form-control"
              id="bookingDescription"
              name="bookingDescription"
              aria-describedby="emailHelp"
              onChange={this.handleChange}
              value={this.state.bookings.bookingDescription}
              placeholder="Enter bookingDescription"
            />
            {this.state.errors && (
              <p className="text-danger font-monospace text-start">
                {this.state.errors.bookingDescription}
              </p>
            )}
          </div>
          <div className="mb-3 text-start">
            <label htmlFor="distance">Distance</label>
            <input
              type="text"
              className="form-control"
              id="distance"
              name="distance"
              onChange={this.handleChange}
              value={this.state.bookings.distance}
              placeholder="Enter distance"
            />
            {this.state.errors && (
              <p className="text-danger font-monospace text-start">
                {this.state.errors.distance}
              </p>
            )}
          </div>

          <div className="mb-3 text-start">
            <label htmlFor="totalCost">Cost</label>
            <input
              type="text"
              className="form-control"
              id="totalCost"
              name="totalCost"
              onChange={this.handleChange}
              value={this.state.bookings.totalCost}
              placeholder="Enter total cost"
            />
            {this.state.errors && (
              <p className="text-danger font-monospace text-start">
                {this.state.errors.totalCost}
              </p>
            )}
          </div>

          <div className="mb-3 text-start">
            <label
              For="deliveryMode"
              style={{ fontWeight: "bolder", float: "left" }}
            >
              Delivery Mode
            </label>

            <Select
              onChange={this.handleChange}
              name="deliveryMode"
              value={this.state.bookings.deliveryMode}
              label="deliveryMode"
              className="form-control"
              style={{ float: "left", height: "40px", fontWeight: "bold" }}
            >
              <MenuItem value="HOME-DELIVERY">HOME-DELIVER</MenuItem>
              <MenuItem value="PICK-UP">PICK-UP</MenuItem>
            </Select>
          </div>
          <button type="submit" className="rounded button" value="ADD">
            ADD
          </button>
        </form>
      </div>
    );
  }
}

export default AddBooking;
