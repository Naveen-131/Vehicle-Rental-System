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
  Button,
} from "@material-ui/core";
import "./css/vehicle.css";
import { makeStyles } from "@material-ui/core/styles";

import { Link } from "react-router-dom";
import { NavLink } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";

import { getVehicleByIdAction } from "../actions/vehicleAction";

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

const VehicleSingleCard = (props) => {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getVehicleByIdAction(props.params));
  }, []);

  const vehicle = useSelector((state) => state.vehicle.vehicle);
  console.log(vehicle);

  const classes = useStyles();

  return (
    <Container style={{ marginTop: "0px", marginLeft: "-48px" }}>
      <Grid container spacing={3}>
        <Paper elevation={3} square />

        <Grid item sm={12}>
          <Grid container spacing={3}>
            <Grid item xs={12} sm={6} md={4} lg={3} key={vehicle.vehicleId}>
              <Card
                style={{
                  height: "350px",

                  width: "260px",
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
                      <Typography style={{ fontWeight: "bolder" }}>
                        Vehicle Model :{vehicle.description}{" "}
                      </Typography>
                    </Box>
                    <Box textAlign="left">
                      <Typography style={{ fontWeight: "bolder" }}>
                        Charges Per KM :{vehicle.chargesPerKM}{" "}
                      </Typography>
                    </Box>
                    <Box textAlign="left">
                      <Typography style={{ fontWeight: "bolder" }}>
                        Fixed Charges: {vehicle.fixedCharges}
                      </Typography>
                    </Box>
                    <br />
                    <hr />
                    <Box alignContent="center" className="mt-2">
                      <Button
                        variant="contained"
                        fullWidth="100"
                        style={{
                          border: "none",
                          backgroundColor: "#FFBE00",
                          color: "white",
                        }}
                        component={NavLink}
                        to={`/user/vehicle-details/${vehicle.vehicleId}`}
                      >
                        View Details
                      </Button>
                    </Box>
                  </CardContent>
                </CardActionArea>
              </Card>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </Container>
  );
};

export default VehicleSingleCard;
