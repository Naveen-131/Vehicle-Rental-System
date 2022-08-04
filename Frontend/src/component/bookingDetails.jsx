import React, { useEffect } from "react";
import {
  Typography,
  Container,
  Card,
  InputLabel,
  CardMedia,
  CardActionArea,
  
  CardContent,
  Button,
  Box,
} from "@material-ui/core";

import { useSelector, useDispatch } from "react-redux";
import { getBookingByIdAction } from "../actions/bookingAction"
import { getActiveBookingByBookingIdAction } from "../actions/activeBookingAction";

import { NavLink } from "react-router-dom";


const BookingDetails = (props) => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getBookingByIdAction(props.match.params.id));
  },[]);

  const booking = useSelector((state) => state.booking.booking);
console.log(booking);

useEffect(() => {
    dispatch(getActiveBookingByBookingIdAction(booking.bookingId));
  }, []);

  const activeBookings = useSelector((state) => state.activeBooking.activeBooking);

  console.log(activeBookings);



  return (
  <Container>
   <Container>
     <br/>
     <br />
         <div className="row" mt={-5}>
                <div className="col-lg-12">
                   
                    <nav aria-label="breadcrumb">
                        <ol className="breadcrumb" style={{backgroundColor: "rgb(246, 247, 247)",height:"45px",borderRadius:"10px",paddingTop:"10px",paddingLeft:"10px"}}>
                            <li className="breadcrumb-item" ><a href="/" style={{color: "#FFBE00",fontSize:"20px"}}>Home</a></li>
                            <li aria-current="page" className="breadcrumb-item active" style={{color: "#000000",fontSize:"20px"}}>Your Cart</li>
                        </ol>
                    </nav>
                </div>
            </div>




            <div className="container">
           
            <div className="row">
                <div className="col-lg-9">
                <Card>
               
               <Card style={{border:"none"}}>
                        <h3 className="mt-4 mb-4" style={{textAlign:"left",paddingLeft:"10px"}}>Book</h3>
                        <p className="text-muted" style={{textAlign:"left",paddingLeft:"10px",marginTop:"-10px"}}>You current booking(s) in your cart.</p>
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
                        <Typography>Booking Id :{booking.bookingId} </Typography>
                      </Box>
                      
                      <Box textAlign="left">
                        <Typography>
                          Status :{activeBookings.status}
                        </Typography>
                      </Box>
                      
                      
                    </CardContent>
                  </CardActionArea>
                </Card>
<hr />
                    <div className="box">

                        
                        
                        <div className="table-responsive">
                            <table className="table">
                                <thead style={{color:"#6c757d"}}>
                                    <tr>
                                      <th scope="col"></th>
                                  
                                      <th scope="col">Booked Till Date</th>
                                      <th scope="col">Booking Date</th>
                                      <th scope="col">Details</th>
                                      <th scope="col">Distance</th>
                                    <th scope="col">Delivery</th>
              
                                   
                                    </tr>

                                </thead>

                              
                                   
                                        <tbody>


                                            <tr style={{borderBottomWidth:"thin",borderTopColor:"#D3D3D3",borderBottomColor:"#D3D3D3"}}>

                                                <td>
                                                   <CardMedia image="/vehiclesample.jpeg" alt="img" style={{width: "80px", height: "60px"}} /></td>
                                                <td style={{textAlign: "center",fontWeight:"bold",fontFamily:"'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', 'Geneva', 'Verdana', 'sans-serif'"}}>{booking.bookedTillDate}</td>

                                                <td style={{textAlign: "center",fontWeight:"bold"}}>{booking.bookingDate}</td>
                                               


                                                <td style={{textAlign: "center",fontWeight:"bold"}}>{booking.bookingDescription}</td>
                                                <td style={{textAlign: "center",fontWeight:"bold"}}>{booking.distance}</td>
                                                <td style={{textAlign: "center",fontWeight:"bold"}}>{booking.deliveryMode}</td>


                                            </tr>


                                        </tbody>

  

                                <tfoot>
                                    <br />
                                    <tr style={{borderTopColor:"#D3D3D3",borderBottomColor:"#D3D3D3" }}>
                                        <th colspan="3">
                                            <InputLabel style={{fontSize: "larger", fontWeight: "bold",textAlign:"left"}}>Total</InputLabel></th>

                                        <th colspan="5">
                                            <InputLabel value="100" style={{float: "right", fontSize:"larger", paddingRight: "125px", fontWeight: "bold"}}>{booking.totalCost}</InputLabel></th>
                                    </tr>
                                </tfoot>
                            </table>
                            <br />
                        </div>
                      
                        <div className="box-footer d-flex justify-content-between flex-column flex-lg-row">
                            <Button className="btn btn-outline-secondary" style={{marginLeft:"10px",backgroundColor: "#000000",color:"#FFFFFF"}} component={NavLink} to={`/vehicle/card`}>Continue Viewing</Button>
                           
                                <Button   className="btn btn-outline-secondary" style={{backgroundColor: "#FFBE00", color: "black",borderRadius: "3px", border:"none"}} component={NavLink} to={`/booking/update/${booking.bookingId}`}>Update Details</Button>
                                <Button  className="btn btn-outline-secondary" Text="Proceed to checkout" style={{backgroundColor: "#FFBE00", color:"black", border: "none", borderRadius: "3px",marginRight:"20px",fontSize: "large"}} component={NavLink} to={`/paymentsPage/${booking.bookingId}`}>Proceed to checkout</Button>
                               
                            

                        </div>
                        
                    <br />
                    </div>
                    </Card>
                    </Card>
                </div>
               
                <div  className="col-lg-3">
                  <Card>
                    <div className="card-header" style={{textAlign:"left"}}>
                        <h3 className="mt-4 mb-4">Order summary</h3>
                         <p className="text-muted">Shipping and additional costs are calculated based on our policies.</p>
                    </div>
                    <div className="box">
                        <div className="table-responsive">
                            <table className="table">
                                <thead>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style={{fontWeight:"bolder",textAlign:"left"}}>Order subtotal</td>
                                        <th>
                                            <InputLabel style={{fontSize: "larger", fontWeight: "bold"}} Text="">{booking.totalCost}</InputLabel></th>
                                    </tr>

                                    <tr>
                                        <td style={{fontWeight:"bolder",textAlign:"left"}}>Shipping and handling</td>
                                        <th>Rs.10.00</th>
                                    </tr>
                                    <tr>
                                        <td style={{fontWeight:"bolder",textAlign:"left"}}>Tax</td>
                                        <th>Rs.0.00</th>
                                    </tr>
                                    <tr>
                                        <td style={{fontWeight:"bolder",fontSize: "25px",textAlign:"left"}}>Total</td>
                                        <th>
                                            <InputLabel style={{ fontWeight:"bolder",fontSize: "25px"}} Text="">{booking.totalCost}</InputLabel></th>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>
                    </Card>

                </div>
            </div>
        </div>
<br />
<br />
</Container>

  </Container>
  );
};

export default BookingDetails;
