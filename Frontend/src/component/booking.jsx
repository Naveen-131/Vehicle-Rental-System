import React, { Component } from "react";
import BookingService from "../service/bookingService";
import BookingTable from "../component/bookingTable";
import { Link } from "react-router-dom";
import { NavLink } from 'react-router-dom';
import {ReactComponent as Search} from "../assets/search.svg";
import './css/AddBooking.css';
 

class Booking extends Component {
  state = {
    bookings: [],
  };


  componentDidMount() {
    BookingService.getBookings().then((res) =>
      this.setState({ bookings: res.data })
    );
  }

  handleDelete = (id) => {
    BookingService.deleteBooking(id).then
      ((res)=>{
        const bookings = this.state.bookings.filter((emp)=>emp.bookingId !== id);
        this.setState({bookings});
      }
      
      );
  
  };


  handleSearch = (event) => {
    //const emps = [...this.state.employees];
    console.log("handleSearch");
    this.setState({ search: event.target.value });
    const filteredEmps = this.state.bookings.filter(
      (emp) =>
        emp.bookingDescription.toLowerCase().startsWith(event.target.value.toLowerCase())
      //emp.firstName.toLowerCase().includes(event.target.value.toLowerCase())
    );
    this.setState({ bookings: filteredEmps });
  };

  render() {

   
    return (
     <div className="d-flex flex-column">
      
          <div>
            <form>
            <Search className="float-end m-2"/>
              <input
                type="search"
                className="form-control w-50 border float-end m-2"
                placeholder="Search by name"
                onChange={this.handleSearch}
                value={this.state.search}
               
              />
            </form>
            <br />
            <br />
          </div>
        
          <NavLink className="navbar-brand" to="/booking/add" >
          <div>
          <input
            type="button"
            className="btn btn-light float-end m-2 mb-4 border border-dark rounded"
            value="Add"
          />
        </div>
        </NavLink>
         
       
        <BookingTable bookings={this.state.bookings}
        handleDelete = {this.handleDelete}
        />
             </div>
    );
  }
}

export default Booking;
