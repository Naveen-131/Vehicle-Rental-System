import React, { useEffect, useState } from "react";
import {
  Typography,
  Container,
  Grid,
  CardMedia,
  CardActions,
  Button,
  Box,
} from "@material-ui/core";
import axios from "axios";
import { Link } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { getVehicleByIdAction } from "../actions/vehicleAction";
import "./css/vehicle.css";
import { NavLink } from "react-router-dom";

const theme = {
  spacing: 8,
};

const VehicleDetails = (props) => {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getVehicleByIdAction(props.match.params.id));
  },[]);

  const vehicle = useSelector((state) => state.vehicle.vehicle);

  return (
    <Container>
      <Box m={10}></Box>
      <Grid container spacing={5}>
        <Grid item m={5}>
          <CardMedia
            image="/vehicleSample.jpeg"
            title="Vehicle"
            style={{ height: "300px", width: "450px" }}
          />
          <CardActions>
            <Link to={`/booking/bookingCart/${vehicle.vehicleId}`}>
              <button
                className="rounded button"
                style={{ height: "50px", width: "470px", fontSize: "24px" }}
              >
                Book Now
              </button>
            </Link>
          </CardActions>
        </Grid>
        <Grid item sm={1}></Grid>

        <Grid item sm={5}>
          <Box textAlign="left">
            <table className="table table-borderless table-responsive ">
              <tbody>
                <tr class="table-dark">
                  <td>
                    <Typography variant="h4">Model</Typography>
                  </td>
                  <td>
                    <Typography variant="h4">{vehicle.description}</Typography>
                  </td>
                </tr>
                <tr class="table-light">
                  <td>
                    <Typography variant="h4">Category</Typography>
                  </td>
                  <td>
                    <Typography variant="h4">{vehicle.category}</Typography>
                  </td>
                </tr>

                <tr class="table-dark">
                  <td>
                    <Typography variant="h4">Type</Typography>
                  </td>
                  <td>
                    <Typography variant="h4">{vehicle.type}</Typography>
                  </td>
                </tr>
                <tr class="table-light">
                  <td>
                    <Typography variant="h4">Capacity</Typography>
                  </td>
                  <td>
                    <Typography variant="h4">{vehicle.capacity}</Typography>
                  </td>
                </tr>
                <tr class="table-dark">
                  <td>
                    <Typography variant="h4">Charges Per Kilometer</Typography>
                  </td>
                  <td>
                    <Typography variant="h4">{vehicle.chargesPerKM}</Typography>
                  </td>
                </tr>
                <tr class="table-light">
                  <td>
                    <Typography variant="h4">Fixed Charges</Typography>
                  </td>
                  <td>
                    <Typography variant="h4">{vehicle.fixedCharges}</Typography>
                  </td>
                </tr>
              </tbody>
            </table>
          </Box>
        </Grid>
      </Grid>
    </Container>
  );
};

export default VehicleDetails;