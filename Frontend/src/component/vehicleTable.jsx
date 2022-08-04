import React, { Component } from "react";
import { Link } from "react-router-dom";

import "./css/vehicle.css";

class VehicleTable extends Component {
  render() {
    return (
      <div className="table-responsive d-flex justify-content-center">
        <table
          className="table w-75 table-hover table-bordered"
          style={{ backgroundColor: "#FFBE00" }}
        >
          <thead>
            <tr>
              <th>Vehicle Id</th>
              <th>Vehicle Number</th>
              <th>Vehicle Description</th>
              <th>Vehicle Location</th>
              <th>Capacity</th>
              <th>Category</th>
              <th>Type</th>
              <th>Charges Per KiloMeter</th>
              <th>Fixed Charges</th>
              <th colSpan="2">Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.props.vehicle.map((v) => (
              <tr>
                <td>{v.vehicleId}</td>
                <td>{v.vehicleNumber}</td>
                <td>{v.description}</td>
                <td>{v.location}</td>
                <td>{v.capacity}</td>
                <td>{v.category}</td>
                <td>{v.type}</td>
                <td>{v.chargesPerKM}</td>
                <td>{v.fixedCharges}</td>
                <td>
                  <Link to={`/vehicle/update/${v.vehicleId}`}>
                    <input
                      type="button"
                      className="btn btn-light"
                      value="Update"
                    />
                  </Link>
                </td>
                <td>
                  <input
                    type="button"
                    className="btn btn-dark ms-3"
                    value="Delete"
                    onClick={() => {
                      this.props.deleteVehicle(v.vehicleId);
                    }}
                  />
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default VehicleTable;
