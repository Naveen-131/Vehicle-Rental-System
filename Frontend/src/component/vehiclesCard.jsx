import React, { useEffect } from "react";
import {
  Grid,
  Paper,
  Box,
  Container,
  Card,
  CardActionArea,
  CardMedia,
  CardContent,
  Typography,
} from "@material-ui/core";
import "./css/vehicle.css";
import { makeStyles } from "@material-ui/core/styles";
import { Link } from "react-router-dom";

import { useSelector, useDispatch } from "react-redux";

import { getAllVehiclesAction } from "../actions/vehicleAction";

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
  },

  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
  content: {
    flexGrow: 3,
    backgroundColor: theme.palette.background.default,
    padding: theme.spacing(3),
  },
  media: {
    height: 140,
  },
}));

const VehiclesCard = (props) => {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getAllVehiclesAction());
  }, []);

  const vehicles = useSelector((state) => state.vehicle.vehicles);

  console.log(vehicles);

  const classes = useStyles();

  return (
    <Container
      style={{ marginTop: "50px", border: "inset" }}
      className="border rounded border-warning"
    >
      <Grid container spacing={3} m={5} border={1}>
        <Paper elevation={3} square />
        <Grid item sm={12} m={2}>
          <Grid container spacing={3}>
            {vehicles.map((v) => (
              <Grid item xs={12} sm={6} md={4} lg={3} key={v.vehicleId}>
                <Card
                  style={{
                    margin: "10px",
                    height: "280px",
                  }}
                >
                  <CardActionArea>
                    <CardMedia
                      className={classes.media}
                      image="/vehicleSample.jpeg"
                      title="Vehicle image"
                    />
                    <CardContent>
                      <Box textAlign="left">
                        <Typography>Vehicle Model :{v.description} </Typography>
                      </Box>
                      <Box textAlign="left">
                        <Typography>
                          Charges Per Kilometer :{v.chargesPerKM}{" "}
                        </Typography>
                      </Box>
                      <Box textAlign="left">
                        <Typography>Fixed Charges: {v.fixedCharges}</Typography>
                      </Box>
                      <Box alignContent="center" className="mt-2">
                        <Link to={`/user/vehicle-details/${v.vehicleId}`}>
                          <button
                            className="rounded button"
                            style={{ width: "100%" }}
                          >
                            View Details
                          </button>
                        </Link>
                      </Box>
                    </CardContent>
                  </CardActionArea>
                </Card>
              </Grid>
            ))}
          </Grid>
        </Grid>
      </Grid>
    </Container>
  );
};

export default VehiclesCard;
