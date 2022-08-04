import React, { Component } from "react";
import {
 
  Container,

  Card,
  CardActionArea,
  Select,
  MenuItem,
  CardContent,
  Button,
  
  Box,
} from "@material-ui/core";

import Joi from "joi-browser";

import { NavLink } from "react-router-dom";
import VehicleSingleCard from "./vehicleSingleCard"



class  BookingCart  extends  Component  {
   
    state = {
      bookings: {
        bookingId: 0,
        customerId:0,
        bookedTillDate: "",
        bookingDate: "",
        bookingDescription: "",
        distance: 0,
        totalCost:0,
        deliveryMode:""
      },
      vehicles:{
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
            vehicleNumber: ""
    },
      errors: {},
      errMsg: "",
    };
     
  
      
 // schema to validate
 schema = {
    bookingId: Joi.number().min(2000).max(9000).required(),
    customerId: Joi.number().min(1001).max(9999).required(),
    bookingDate: Joi.date().iso().min ( '01-08-2021' ).required(),
    bookedTillDate: Joi.date().iso().required(),
    bookingDescription: Joi.string().min(2).alphanum().required(),
    distance: Joi.number().min(2).max(500).required(),
    totalCost: Joi.number().required(),
    deliveryMode: Joi.string().min(2).required(),
  };


   // form validation method
   validate = () => {
    const errors = {};
    // Validate account details with schema
    const result = Joi.validate(this.state.bookings, this.schema, {
      abortEarly: false,
    });
    console.log(result);

    // Initialize error object with errors, if validate method returns errors
    if (result.error !== null) {
      for (let err of result.error.details) {
        errors[err.path[0]] = err.message;
      }
    }

    // return null if no errors otherwise return errors
    return Object.keys(errors).length === 0 ? null : errors;
  };

  onTodoChange(value){
    this.setState({
        totalCost: value,
    });
}


  handleChange = (event) => {
    const bookings= { ...this.state.bookings };
    bookings[event.target.name] = event.target.value;
    //employee[empId]=1;
    console.log(event.target.name);
    console.log(event.target.value);
    bookings["totalCost"] = this.state.bookings.distance*15+250;
                                                 
    this.setState({ bookings: bookings });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    // Prevents default behaviour of submit button
    const errors = this.validate(); // null / errors
    // Set state error object with errors or empty object based on
    // errors return by the validate() method
    this.setState({ errors: errors || {} });
    // if errors exists in the form , return to the login page
    console.log(errors);
    console.log(this.state.bookings);

    if (errors) return;
    
   
    //  this.props.history.push(`/bookingDetails/${this.state.bookings.bookingId}`);
    this.props.history.push({
      pathname: `/paymentsPage/${this.state.bookings.bookingId}`,
      state1: this.state.bookings

    })

   
   
    }

    

    render() {
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
                                                <li aria-current="page" className="breadcrumb-item active" style={{color: "#000000",fontSize:"20px"}}>Booking</li>
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
                       <p className="text-muted" style={{textAlign:"left",paddingLeft:"10px",marginTop:"-10px"}}>Book you vehicle by entering the following details.</p>
                        
             
                      <hr />
                      <Card
                  style={{
                    margin: "10px",
                    height: "70px",
                  }}
                >
                  <CardActionArea>
                  {this.state.errMsg && (
          <div className="alert alert-danger" role="alert">
            {this.state.errMsg}
          </div>
        )}
                    <CardContent>
                      <Box textAlign="left">
                        </Box>
                        </CardContent>
                        </CardActionArea>
                        </Card>
                        <hr />



                        <div className="box">
                        <Card style={{paddingLeft:"10px",paddingRight:"10px"}}>
                        <div className="content py-3">
                                <form onSubmit={this.handleSubmit}>
                                <div className="row">
                                        <div className="col-md-6">
                                            <div className="form-group">
                                       
                                            <label for="bookingId" style={{fontWeight:"bolder",float:"left"}}>Booking Id</label>
                                            <input
                                            type="text"
                                            className="form-control"
                                            id="bookingId"
                                            name="bookingId"
                                            onChange={this.handleChange}
                                            value={this.state.bookings.bookingId}
                                            
                                            />
                                            {this.state.errors && (
                                            <p className="text-danger font-monospace text-start">
                                                {this.state.errors.bookingId}
                                            </p>
                                            )}
                                            </div>

                                        </div>
                                            <div className="col-md-6">
                                            <label htmlFor="customerId" style={{fontWeight:"bolder",float:"left"}}>Customer Id</label>
                                                <input
                                                type="text"
                                                className="form-control"
                                                id="customerId"
                                                name="customerId"
                                                onChange={this.handleChange}
                                                value={this.state.bookings.customerId}
                                                
                                                />
                                                {this.state.errors && (
                                                <p className="text-danger font-monospace text-start">
                                                    {this.state.errors.customerId}
                                                </p>
                                                )}
                                            </div>
                                    </div>

                                    <div className="row">
                                        <div className="col-md-6">
                                        <label htmlFor="bookingDate" style={{fontWeight:"bolder",float:"left"}}>Booking Date</label>
                                                <input
                                                type="Date"
                                                className="form-control"
                                                id="bookingDate"
                                                name="bookingDate"
                                                onChange={this.handleChange}
                                                value={this.state.bookings.bookingDate}
                                                //placeholder="Enter employee firstName"
                                                
                                            
                                                />
                                                {this.state.errors && (
                                                    <p className="text-danger font-monospace text-start">
                                                    {this.state.errors.bookingDate}
                                                    </p>
                                                )}
                                        </div>
                                        <div className="col-md-6">
                                        <label htmlFor="bookingTillDate" style={{fontWeight:"bolder",float:"left"}}>Booked Till Date</label>
                                                <input
                                                type="Date"
                                                className="form-control"
                                                
                                                id="bookedTillDate"
                                                name="bookedTillDate"
                                                onChange={this.handleChange}
                                                value={this.state.bookings.bookedTillDate}
                                                
                                                
                                                />
                                                {this.state.errors && (
                                                    <p className="text-danger font-monospace text-start">
                                                    {this.state.errors.bookingTillDate}
                                                    </p>
                                                )}
                                        </div>
                                        </div>
                                        <div className="row">
                                            <div className="col-md-12">
                                            <label for="bookingDescription" style={{fontWeight:"bolder",float:"left"}}>Booking Description</label>
                                                <input
                                                type="text"
                                                className="form-control"
                                                id="bookingDescription"
                                                name="bookingDescription"
                                                aria-describedby="emailHelp"
                                                onChange={this.handleChange}
                                                value={this.state.bookings.bookingDescription}
                                                placeholder="Enter bookingDescription"
                                                
                                                />
                                                {this.state.errors && (
                                                    <p className="text-danger font-monospace text-start">
                                                    {this.state.errors.bookingDescription}
                                                    </p>
                                                )}
                                            </div>
                                          
                                            </div>
                                        <div className="row">
                                              <div className="col-md-6">
                                            <label htmlFor="distance" style={{fontWeight:"bolder",float:"left"}}>Distance</label>
                                                    <input
                                                    type="text"
                                                    className="form-control"
                                                    id="distance"
                                                    name="distance"
                                                    onChange={this.handleChange}
                                                    value={this.state.bookings.distance}
                                                    placeholder="Enter distance"
                                                    
                                                    />
                                                    {this.state.errors && (
                                                        <p className="text-danger font-monospace text-start">
                                                        {this.state.errors.distance}
                                                        </p>
                                                    )}
                                                </div>
                                                <div className="col-md-6">
                                                <div className="mb-6 text-start">
                                                       <label For="deliveryMode" style={{fontWeight:"bolder",float:"left"}}>Delivery Mode</label> 
               
                                                              
                                                                <Select
                                                                  
                                                                  
                                                                  onChange={this.handleChange}
                                                                  name="deliveryMode"
                                                                  value={this.state.bookings.deliveryMode}
                                                                  label="deliveryMode"
                                                                  className="form-control"
                                                                  style={{float: "left",height:"40px" ,fontWeight: "bold"}}
                                                                >
                                                                  
                                                                  
                                                                  <MenuItem value="HOME-DELIVERY">HOME-DELIVER</MenuItem>
                                                                  <MenuItem value="PICK-UP">PICK-UP</MenuItem>
                                                                  
                                                                </Select>
                                                   </div>
                                                </div>
                                        </div>
                                        <hr />
                                        <div className="row">
                                        <div className="mb-6 text-start">
                                        <label htmlFor="totalCost">Cost</label>
                                        <input
                                        
                                        
                                       
                                        className="form-control"
                                        id="totalCost"
                                        name="totalCost"
                                       
                                       
                                        value={this.state.bookings.distance*15+250}
                                       
                                        style={{float: "right", fontSize:"larger", paddingRight: "125px", fontWeight: "bold"}}
                                            
                                          />
                                            {this.state.errors && (
                                            <p className="text-danger font-monospace text-start">
                                              {this.state.errors.totalCost}
                                            </p>
                                          )}

                                       
                                        </div>
                                       
                                        </div>
                                        <br />
                                   
                                    
                                    <div className="box-footer d-flex justify-content-between">
                                    <Button  className="btn btn-outline-secondary" component={NavLink} to={`/vehicle/card`}>Back to Vehicle</Button>
                                    <div className="box-footer d-flex justify-content-between"><button type="submit" value="ADD" className="btn btn-outline-primary" style={{border: "none", backgroundColor: "#FFBE00", color: "white"}}>Continue to Payment</button></div>
                               
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
                        <h3 className="mt-4 mb-4">Your Vehicle</h3>
                         <p className="text-muted">Shipping and additional costs are calculated based on our policies.</p>
                    </div>
                  
                       
                           <Container>
                               
                              
                                    
                                <VehicleSingleCard id={this.props} style={{marginTop:"-25px"}}/>
                                   
                              </Container>

                       
                  
                    </Card>

                </div>


            </div>
            </div>
                       
                       
            </Container>
        

    </Container>

      )
    }


};



export default BookingCart;



