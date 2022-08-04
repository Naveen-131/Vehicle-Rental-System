import React, { Component } from "react";

import VehicleService from "../service/vehicleService";
import VehicleTable from "./vehicleTable";

import { Link } from "react-router-dom";

import "./css/vehicle.css";

class Vehicle extends Component {
  state = {
    vehicle: [],
    location: "",
  };

  componentDidMount() {
    VehicleService.getAllVehicles().then((response) =>
      this.setState({ vehicle: response.data })
    );
  }

  searchByLocation = (event) => {
    console.log("search by location");
    this.setState({ location: event.target.value });
    console.log(event.target.value);
    const filteredVehicles = this.state.vehicle.filter((v) =>
      v.location.toLowerCase().includes(event.target.value.toLowerCase())
    );
    this.setState({ vehicle: filteredVehicles });
  };

  searchByCarModel = (event) => {
    console.log("search by ");
    this.setState({ location: event.target.value });
    console.log(event.target.value);

    const filteredVehicles = this.state.vehicle.filter((v) =>
      v.description.toLowerCase().includes(event.target.value.toLowerCase())
    );
    this.setState({ vehicle: filteredVehicles });
  };

  deleteVehicle = (vehicleId) => {
    VehicleService.deleteVehicle(vehicleId).then((response) => {
      const vehicles = this.state.vehicle.filter(
        (v) => v.vehicleId !== vehicleId
      );
      this.setState({ vehicle: vehicles });
    });
  };

  render() {
    return (
      <div>
        <div className="mt-3 w-75 mx-auto">
          <div className="container">
            <div className="row">
              <h3 className="p-1">Vehicle Details</h3>
            </div>
            <div className="row">
              <div className=" col-md-1"></div>
              <div className=" col-md-7">
                <form>
                  <input
                    type="search"
                    className="form-control m-3 "
                    placeholder="Search by Location"
                    value={this.state.location}
                    onChange={this.searchByLocation}
                  />
                </form>
              </div>

              <div className=" col-md-2">
                <Link to="/vehicle/add">
                  <button
                    className="rounded button m-3"
                    style={{ height: "40px", width: "230px", fontSize: "24px" }}
                  >
                    Add Vehicle
                  </button>
                </Link>
              </div>
            </div>
          </div>
          <VehicleTable
            vehicle={this.state.vehicle}
            deleteVehicle={this.deleteVehicle}
          />
        </div>
      </div>
    );
  }
}

export default Vehicle;
