import React, { useEffect } from "react";
import {
  Grid,
  Paper,
  Box,
  Container,
  Card,
  Button,
} from "@material-ui/core";
import "./css/vehicle.css";
import { makeStyles } from "@material-ui/core/styles";
import { NavLink } from "react-router-dom";
import { Link } from "react-router-dom";

import { useSelector, useDispatch } from "react-redux";

import { getBookingsByCustomerIdAction } from "../actions/customerAction";

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

const AllBookingsByCustomer = (props) => {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getBookingsByCustomerIdAction(props.match.params.id));
  }, []);

  const customers = useSelector((state) => state.customer.customers);

  console.log(customers);

  const classes = useStyles();

  return (
    <Container>
      <Container>
        <br />
        <br />
        <div class="row" mt={-5}>
          <div class="col-lg-12">
            <nav aria-label="breadcrumb">
              <ol
                className="breadcrumb"
                style={{
                  backgroundColor: "rgb(246, 247, 247)",
                  height: "45px",
                  borderRadius: "10px",
                  paddingTop: "10px",
                  paddingLeft: "10px",
                }}
              >
                <li className="breadcrumb-item">
                  <a href="/" style={{ color: "#FFBE00", fontSize: "20px" }}>
                    Home/User
                  </a>
                </li>
                <li
                  aria-current="page"
                  className="breadcrumb-item active"
                  style={{ color: "#000000", fontSize: "20px" }}
                >
                  Your Bookings
                </li>
              </ol>
            </nav>
          </div>
        </div>

        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <Card>
                <Card style={{ border: "none" }}>
                  <h3
                    className="mt-4 mb-4"
                    style={{ textAlign: "left", paddingLeft: "10px" }}
                  >
                    Hi User{customers.firstName}
                  </h3>
                  <p
                    className="text-muted"
                    style={{
                      textAlign: "left",
                      paddingLeft: "10px",
                      marginTop: "-10px",
                    }}
                  >
                    You booking(s).
                  </p>
                </Card>
                <hr />
                <div className="box">
                  <div className="table-responsive">
                    <table className="table">
                      <thead style={{ color: "#6c757d" }}>
                        <tr>
                          <th scope="col">Booked Till Date</th>
                          <th scope="col">Booking Date</th>
                          <th scope="col">Details</th>
                          <th scope="col">Distance</th>
                          <th scope="col">Delivery</th>
                          <th scope="col">TotalCost</th>
                        </tr>
                      </thead>
                      <tbody>
                        {customers.map((v) => (
                          <tr
                            style={{
                              borderBottomWidth: "thin",
                              borderTopColor: "#D3D3D3",
                              borderBottomColor: "#D3D3D3",
                            }}
                          >
                            <td
                              style={{
                                textAlign: "center",
                                fontWeight: "bold",
                              }}
                            >
                              {v.bookedTillDate}
                            </td>
                            <td
                              style={{
                                textAlign: "center",
                                fontWeight: "bold",
                              }}
                            >
                              {v.bookingDate}
                            </td>

                            <td
                              style={{
                                textAlign: "center",
                                fontWeight: "bold",
                              }}
                            >
                              {v.bookingDescription}
                            </td>
                            <td
                              style={{
                                textAlign: "center",
                                fontWeight: "bold",
                              }}
                            >
                              {v.distance}
                            </td>
                            <td
                              style={{
                                textAlign: "center",
                                fontWeight: "bold",
                              }}
                            >
                              {v.deliveryMode}
                            </td>
                            <td
                              style={{
                                textAlign: "center",
                                fontWeight: "bold",
                              }}
                            >
                              {v.totalCost}
                            </td>
                            <td>
                              <Button
                                className="rounded button"
                                style={{
                                  fontSize: "15px",
                                  color: "#000000",
                                  backgroundColor: "#FFBE00",
                                }}
                                component={NavLink}
                                to={`/bookingDetails/${v.bookingId}`}
                              >
                                More
                              </Button>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                </div>
              </Card>
            </div>
          </div>
        </div>
      </Container>
    </Container>
  );
};

export default AllBookingsByCustomer;
