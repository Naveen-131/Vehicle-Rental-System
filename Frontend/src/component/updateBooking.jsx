import React, { Component } from "react";
import BookingService from "../service/bookingService";
import {

  Select,
  MenuItem,

} from "@material-ui/core";


class  UpdateBooking extends  Component  {
 
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
    
  };

  componentDidMount() {
    BookingService.getBookingById(this.props.match.params.id).then((res) =>
      this.setState({ bookings: res.data },()=>{console.log(this.state)})
    );
  }


  handleChange = (event) => {
    const bookings= { ...this.state.bookings };
    bookings[event.target.name] = event.target.value;
    //employee[empId]=1;
    console.log(event.target.name);
    console.log(event.target.value);
    this.setState({ bookings: bookings });
  };

  handleSubmit = (event) => {
    // Prevents default behaviour of submit button
    event.preventDefault();
    BookingService.updateBooking(this.state.bookings).then((res) => {
      this.props.history.push("/bookings");
    });
  };



  render() {
    return (
      <div className="w-50 mx-auto p-4 mt-5 " style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
        Update Booking Details
        <form onSubmit={this.handleSubmit}>
          <div className="mb-3 text-start">
            <label for="bookingId">Booking Id</label>
            <input
              type="text"
              className="form-control"
              id="bookingId"
              name="bookingId"
              onChange={this.handleChange}
              value={this.state.bookings.bookingId}
              
              disabled
            />
          </div>
          
        
          <div className="mb-3 text-start">
            <label for="customerId">Customer Id</label>
            <input
              type="text"
              className="form-control"
              id="customerId"
              name="customerId"
              onChange={this.handleChange}
              value={this.state.bookings.customerId}
             disabled
            />
          </div>

          
          <div className="mb-3 text-start">
            <label for="bookingDate">Booking Date</label>
            <input
              type="Date"
              className="form-control"
              id="bookingDate"
              name="bookingDate"
              onChange={this.handleChange}
              value={this.state.bookings.bookingDate}
              //placeholder="Enter employee firstName"
            
            />
          </div>
          <div className="mb-3 text-start">
            <label for="bookingTillDate">bookingTillDate</label>
            <input
              type="Date"
              className="form-control"
              id="bookedTillDate"
              name="bookedTillDate"
              onChange={this.handleChange}
              value={this.state.bookings.bookedTillDate}
             // placeholder="Enter booking till date"
            
            />
          </div>
          <div className="mb-3 text-start">
            <label for="bookingDescription">Booking Description</label>
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
          </div>
          <div className="mb-3 text-start">
            <label for="distance">Distance</label>
            <input
              type="text"
              className="form-control"
              id="distance"
              name="distance"
              onChange={this.handleChange}
              value={this.state.bookings.distance}
              placeholder="Enter distance"
            
            />
          </div>

          <div className="mb-3 text-start">
            <label for="totalCost">Cost</label>
            <input
              type="text"
              className="form-control"
              id="totalCost"
              name="totalCost"
              value={this.state.bookings.totalCost}
              onChange={this.handleChange}
             
              placeholder="Enter total cost"
              
            />
          </div>

          <div className="mb-3 text-start">
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
          <button type="submit" className="rounded button" value="UPDATE" style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
            Submit
          </button>
        </form>
      </div>
    );
  }
}

export default UpdateBooking;
