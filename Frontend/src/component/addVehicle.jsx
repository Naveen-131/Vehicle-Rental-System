import React, { Component } from "react";
import VehicleService from "../service/vehicleService";
import Joi from "joi-browser";
import "./css/vehicle.css";
import DriverService from "../service/driverService";
import BookingService from "../service/bookingService";

class AddVehicle extends Component {
  state = {
    vehicle: {
      vehicleId: 0,
      bookingId: 0,
      capacity: 0,
      category: "",
      chargesPerKM: 0,
      description: "",
      driverId: 0,
      fixedCharges: 0,
      location: "",
      type: "",
      vehicleNumber: "",
    },
    errors: {},
    errMsg: "",
    drivers: [],
    bookings: [],
  };

  schema = {
    vehicleId: Joi.number().required(),
    bookingId: Joi.number().required(),
    capacity: Joi.number().min(2).required(),
    category: Joi.string().min(2).required(),
    chargesPerKM: Joi.number().min(15).required(),
    description: Joi.string().min(3).required(),
    driverId: Joi.number().required(),
    fixedCharges: Joi.number().min(100).required(),
    location: Joi.string().min(3).required(),
    type: Joi.string().min(2).required(),
    //vehicleNumber: Joi.string().pattern(new RegExp('^[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{2}\\s[0-9]{4}$'))
    vehicleNumber: Joi.string().min(12).required(),
  };

  componentDidMount = async () => {
    const response = await DriverService.getAllDriver();
    this.setState({ drivers: response.data });
    console.log(response.data);
    const res = await BookingService.getBookings();
    this.setState({ bookings: res.data });
    console.log(res.data);
  };

  validate = () => {
    const errors = {};

    const result = Joi.validate(this.state.vehicle, this.schema, {
      abortEarly: false,
    });
    console.log(result);

    if (result.error !== null) {
      for (let err of result.error.details) {
        errors[err.path[0]] = err.message;
      }
    }
    return Object.keys(errors).length === 0 ? null : errors;
  };

  handleChange = (event) => {
    const vehicle = { ...this.state.vehicle };
    vehicle[event.target.name] = event.target.value;
    console.log(event.target.name);
    console.log(event.target.value);
    this.setState({ vehicle: vehicle });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const errors = this.validate();

    this.setState({ errors: errors || {} });
    console.log(errors);

    if (errors) return;
    VehicleService.addVehicle(this.state.vehicle)
      .then((response) => {
        this.props.history.push("/vehicles");
      })
      .catch((err) => this.setState({ errMsg: err.response.data.message }));
  };
  render() {
    return (
      <div
        className="w-50 mx-auto p-4 mt-5"
        style={{
          borderStyle: "solid",
          borderColor: "#FFBE00",
          borderRadius: "8px",
        }}
      >
        {this.state.errMsg && (
          <div className="alert alert-danger" role="alert">
            {this.state.errMsg}
          </div>
        )}
        <div className=" p-3">
          <h3 className="p-1">Add Vehicle</h3>
          <form onSubmit={this.handleSubmit}>
            <div className="row">
              <div className="col-md-6 ">
                <div className="mb-3 text-start">
                  <label for="vehicleId">Vehicle Id</label>
                  <input
                    type="text"
                    className="form-control"
                    id="vehicleId"
                    name="vehicleId"
                    size="20"
                    value={this.state.vehicle.vehicleId}
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.vehicleId}
                    </p>
                  )}
                </div>
              </div>
              <div className="col-md-6 ">
                <div className="mb-3 text-start">
                  <label for="vehicleNumber">Vehicle Number</label>
                  <input
                    type="text"
                    className="form-control"
                    id="vehicleNumber"
                    name="vehicleNumber"
                    value={this.state.vehicle.vehicleNumber}
                    placeholder="Enter vehicle number"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.vehicleNumber}
                    </p>
                  )}
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6 ">
                <div className="mb-3 text-start">
                  <label for="category">Category</label>
                  <input
                    type="text"
                    className="form-control"
                    id="category"
                    name="category"
                    value={this.state.vehicle.category}
                    placeholder="Enter vehicle category"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.category}
                    </p>
                  )}
                </div>
              </div>
              <div className="col-md-6 ">
                <div className="mb-3 text-start">
                  <label for="type">Type</label>
                  <input
                    type="text"
                    className="form-control"
                    id="type"
                    name="type"
                    value={this.state.vehicle.type}
                    placeholder="Enter vehicle type"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.type}
                    </p>
                  )}
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6 ">
                <div className="mb-3 text-start">
                  <label for="chargesPerKM">Charges Per KM</label>
                  <input
                    type="text"
                    className="form-control"
                    id="chargesPerKM"
                    name="chargesPerKM"
                    value={this.state.vehicle.chargesPerKM}
                    placeholder="Enter vehicle chargesPerKM"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.chargesPerKM}
                    </p>
                  )}
                </div>
              </div>
              <div className="col-md-6 ">
                <div className="mb-3 text-start">
                  <label for="fixedCharges">Fixed Charges</label>
                  <input
                    type="text"
                    className="form-control"
                    id="fixedCharges"
                    name="fixedCharges"
                    value={this.state.vehicle.fixedCharges}
                    placeholder="Enter vehicle fixedCharges"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.fixedCharges}
                    </p>
                  )}
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-12 ">
                <div className="mb-3 text-start">
                  <label for="description">Description</label>
                  <input
                    type="text"
                    className="form-control"
                    id="description"
                    name="description"
                    value={this.state.vehicle.description}
                    placeholder="Enter vehicle description"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.description}
                    </p>
                  )}
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6 ">
                <div className="mb-3 text-start">
                  <label for="capacity">Capacity</label>
                  <input
                    type="text"
                    className="form-control"
                    id="capacity"
                    name="capacity"
                    value={this.state.vehicle.capacity}
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.capacity}
                    </p>
                  )}
                </div>
              </div>

              <div className="col-md-6 ">
                <div className="mb-3 text-start">
                  <label for="location">Location</label>
                  <input
                    type="text"
                    className="form-control"
                    id="location"
                    name="location"
                    value={this.state.vehicle.location}
                    placeholder="Enter vehicle location"
                    onChange={this.handleChange}
                  />
                  {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                      {this.state.errors.location}
                    </p>
                  )}
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-3 ">
                <div className="mb-3 text-start-center">
                  <label for="driverId">Select Booking Id</label>
                </div>
              </div>

              <div className="col-md-2 ">
                <div className="mb-3 text-start">
                  <select
                    name="bookingId"
                    id="bookingId"
                    style={{ width: "170px", height: "40px" }}
                    value={this.state.vehicle.bookingId}
                    onChange={(e) => {
                      this.setState((prev) => ({
                        vehicle: { ...prev.vehicle, bookingId: e.target.value },
                      }));
                    }}
                  >
                    {this.state.bookings.map((b) => (
                      <option key={b.bookingId} value={b.bookingId}>
                        {b.bookingId}
                      </option>
                    ))}
                  </select>
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-3 ">
                <div className="mb-3 text-start-center">
                  <label for="driverId">Select Driver Id</label>
                </div>
              </div>

              <div className="col-md-2 ">
                <div className="mb-3 text-start">
                  <select
                    name="driverId"
                    id="driverId"
                    style={{ width: "170px", height: "40px" }}
                    value={this.state.vehicle.driverId}
                    onChange={(e) => {
                      this.setState((prev) => ({
                        vehicle: { ...prev.vehicle, driverId: e.target.value },
                      }));
                    }}
                  >
                    {this.state.drivers.map((d) => (
                      <option key={d.driverId} value={d.driverId}>
                        {d.driverId}
                      </option>
                    ))}
                  </select>
                </div>
              </div>
            </div>

            <button
              type="submit"
              className="rounded button"
              style={{ height: "50px", width: "170px", fontSize: "24px" }}
            >
              ADD
            </button>
          </form>
        </div>
      </div>
    );
  }
}

export default AddVehicle;
