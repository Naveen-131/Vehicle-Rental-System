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


import { getActiveBookingByBookingIdAction } from "../actions/activeBookingAction";

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
    height: 200,
  },
}));

const ActiveBookingCard = (props) => {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch( getActiveBookingByBookingIdAction(props.match.params.id));
  }, []);

  const activeBookings = useSelector((state) => state.activeBooking.activeBooking);

  console.log(activeBookings);

  const classes = useStyles();

  return (
    <Container style={{ marginTop: "50px" }} >
      <Grid container spacing={3} m={5}>
        <Paper elevation={3} square />
        <Grid item sm={12}>
          <Grid container spacing={3}>
          
              <Grid item xs={12} sm={6} md={4} lg={3} style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}  >
                <Card
                  style={{
                    margin: "10px",
                    height: "70px",
                  }}
                >
                  <CardActionArea>
                    {/* <CardMedia
                      className={classes.media}
                      image="/vehicleSample.jpeg"
                      title="Vehicle image"
                    /> */}
                    <CardContent>
                      <Box textAlign="left">
                        <Typography>Booking Id :{activeBookings.booking} </Typography>
                      </Box>
                      
                      <Box textAlign="left">
                        <Typography>
                          Status :{activeBookings.status}
                        </Typography>
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

export default ActiveBookingCard;