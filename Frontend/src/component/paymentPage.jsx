import React, { useEffect, Component } from "react";
import {
 
  Container,

  Card,
  InputLabel,
  Button,
 
} from "@material-ui/core";


import { NavLink } from "react-router-dom";

import PaymentService from "../service/paymentService";
import BookingService from "../service/bookingService";


class PaymentPage extends Component {
  
  constructor(props) {
    super(props)
  
    this.state = {

      payments: {
      paymentId: 6,
      paymentDate: new Date().toISOString().split('T')[0],
      paymentMode: "ONLINE",
      paymentStatus: "SUCCESS", 
      bookingId:this.props.location.state1.bookingId
    
    },

    payment: {
      paymentId:0 ,
      paymentDate:"",
      paymentMode: "",
      paymentStatus: "", 
      bookingId:0
    
    },

    bookingData : {
        bookingId: 0,
        customerIdFk:0,
        bookedTillDate: "",
        bookingDate: "",
        bookingDescription: "",
        distance: 0,
        totalCost:0,
        deliveryMode:""
    },
    
    
    
  
  
    errors: {},
    errMsg: "",

  };
  }



  
  componentDidMount()
  {
     this.setState({bookingData:this.props.location.state1});
     this.setState({payment:this.state.payments});
  }
  // schema to validate
  //schema = {
    
   // paymentId: Joi.number().required(),
   // paymentDate: Joi.date().iso().min("01-08-2021").required(),   
    //paymentMode: Joi.string().required(),
    //paymentStatus: Joi.string().required(), 
       
 // };

  // form validation method
//   validate = () => {
//     const errors = {};
//     // Validate account details with schema
//     const result = Joi.validate(this.state.payments, this.schema, {
//       abortEarly: false,
//     });
//     console.log(result);

//     // Initialize error object with errors, if validate method returns errors
//     if (result.error !== null) {
//       for (let err of result.error.details) {
//         errors[err.path[0]] = err.message;
//       }
//     }

//     // return null if no errors otherwise return errors
//     return Object.keys(errors).length === 0 ? null : errors;
//   };

  handleChange = (event) => {
    // const payments = { ...this.state.payments };
    // payments[event.target.name] = event.target.value;
    // //employee[empId]=1;
    // console.log(event.target.name);
    // console.log(event.target.value);
    // this.setState({ payments: payments });

  };

  handleSubmit = (event) => {
    event.preventDefault();
    // Prevents default behaviour of submit button
  //  const errors = this.validate(); // null / errors
    // Set state error object with errors or empty object based on
    // errors return by the validate() method
  //  this.setState({ errors: errors || {} });
    // if errors exists in the form , return to the login page
 //   console.log(errors);

  //  if (errors) return;
   
   console.log(this.state.payment,this.state.bookingData);
    
  
      BookingService.createBooking(this.state.bookingData).then((res) => {
        //  this.props.history.push(`/bookingDetails/${this.state.bookings.bookingId}`);
        PaymentService.addPayment(this.state.payment).then((res)=>{
          this.props.history.push("/home");
        })
        })
       
        // .catch((err)=>{
        //   this.props.history.push("/home");
        // })
       
       
    //    .catch((error) => this.setState({ errMsg: error.response.data.message }));
        
    
  };

  render() {
    
    return (
      <Container>
        <Container>
          <br />
          <br />
          <div className="row" mt={-5}>
            <div className="col-lg-12">
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
                      Home/Booking
                    </a>
                  </li>
                  <li
                    aria-current="page"
                    className="breadcrumb-item active"
                    style={{ color: "#000000", fontSize: "20px" }}
                  >
                    Payment
                  </li>
                </ol>
              </nav>
            </div>
          </div>

          <div className="container">
            <div className="row">
              <div className="col-lg-9">
                <Card>
                  <Card style={{ border: "none" }}>
                    <h3
                      className="mt-4 mb-4"
                      style={{ textAlign: "left", paddingLeft: "10px" }}
                    >
                      Payment
                    </h3>
                    <p
                      className="text-muted"
                      style={{
                        textAlign: "left",
                        paddingLeft: "10px",
                        marginTop: "-10px",
                      }}
                    >
                      Make Payment by entering the following details.
                    </p>
                    <hr />
                    <div className="box">
                      <Card
                        style={{ paddingLeft: "10px", paddingRight: "10px" }}
                      >
                        <div className="content py-3">
                          <form onSubmit={this.handleSubmit}>
                            <div className="row">
                              <div className="col-md-6">
                                <div className="form-group">
                                  <label
                                    for="firstName"
                                    style={{
                                      fontWeight: "bolder",
                                      float: "left",
                                    }}
                                  >
                                    First Name
                                  </label>
                                  <input
                                    type="text"
                                    className="form-control"
                                    id="firstName"
                                    name="firstName"
                                    onChange={this.handleChange}
                                    
                                  />
                                  
                                </div>
                              </div>
                           
                              <div className="col-md-6">
                                <label
                                  htmlFor="lastName"
                                  style={{
                                    fontWeight: "bolder",
                                    float: "left",
                                  }}
                                >
                                  Last Name
                                </label>
                                <input
                                  type="text"
                                  className="form-control"
                                  id="firstName"
                                  name="firstName"
                                  onChange={this.handleChange}
                                  
                                  //placeholder="Enter employee firstName"
                                />
                              
                              </div>
                             
                            </div>
                            <div className="row">
                              <div className="col-md-3">
                                <label
                                  for="paymentMode"
                                  style={{
                                    fontWeight: "bolder",
                                    float: "left",
                                  }}
                                >
                                Payment Mode
                                </label>
                                <input
                                  type="text"
                                  disabled
                                  className="form-control"
                                  id="paymentMode"
                                  name="paymentMode"
                                  aria-describedby="emailHelp"
                                  onChange={this.handleChange}
                                  value="ONLINE"
                                  placeholder="Enter payment Mode"
                                />
                               
                              </div>
                           
                              <div className="col-md-9">
                                <label
                                  htmlFor="CardNumber"
                                  style={{
                                    fontWeight: "bolder",
                                    float: "left",
                                  }}
                                >
                                  CARD NUMBER
                                </label>
                                <input
                                  type="number"
                                  className="form-control"
                                  id="CardNumber"
                                  name="CardNumber"
                                  onChange={this.handleChange}
                                  
                                  placeholder="Enter CARD ID"
                                />
                               
                              </div>
                              
                            </div>
                            <hr />
                                
                            <hr />
                            <br />

                            <div className="box-footer d-flex justify-content-between">
                              <Button component={NavLink} to={`/booking/bookingCart`} className="btn btn-outline-secondary">
                                Back to Booking
                              </Button>
                              <div className="box-footer d-flex justify-content-between">
                                <button
                                  type="submit"
                                  value="ADD"
                                  className="btn btn-outline-primary"
                                  style={{
                                    border: "none",
                                    backgroundColor: "#FFBE00",
                                    color: "white",
                                  }}
                                >
                                  Make Payment
                                </button>
                              </div>
                            </div>
                          </form>
                        </div>
                      </Card>
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
                                            <InputLabel style={{fontSize: "larger", fontWeight: "bold"}} Text=""></InputLabel></th>
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
                                            <InputLabel style={{ fontWeight:"bolder",fontSize: "25px"}} Text=""></InputLabel></th>
                                    </tr>
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
  }
}

export default PaymentPage;