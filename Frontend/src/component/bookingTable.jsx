import React, { Component } from "react";
import BookingService from "../service/bookingService";
import { Link } from "react-router-dom";

class BookingTable extends Component {
   
       state = {
        bookings:[] 
   };
 
  componentDidMount() {
    BookingService.getBookings().then((res) =>
      this.setState({ bookings: res.data })
    );
   
  }

  handleDelete = () => {
    //EmployeeService.deleteEmployee();
  };

  render() {

 

    return (
      <div className="table-responsive-md justify-content-center">
        <table className="table table-hover table-bordered" style={{backgroundColor:"#FFBE00"}}>

          <thead>
          
            <tr>
              <th scope="col">BOOKING ID</th>
              <th scope="col">BOOKING TILL DATE</th>
              <th scope="col">BOOKING DATE</th>
              <th scope="col">DESCRIPTION</th>
              <th scope="col">DISTANCE</th>
              <th scope="col">TOTAL COST</th>
            
              <th scope="col">DELIVERY MODE</th>
              <th colSpan="2">ACTION</th>  
            </tr>
          </thead>
          <tbody>
        
            {this.props.bookings.map((emp) => (
              <tr  key={emp.bookingId}>
                
                <td>{emp.bookingId}</td>
                <td>{emp.bookedTillDate}</td>
                <td>{emp.bookingDate}</td>
                <td>{emp.bookingDescription}</td>
                <td>{emp.distance}</td>
               
                <td>{emp.totalCost}</td>
               
                <td>{emp.deliveryMode}</td>
                <td>
                <Link to={`/booking/update/${emp.bookingId}`}>
                  <input
                    type="button"
                    className="btn btn-light"
                    value="Update"
                  />
                </Link>

                  <input 
                    type="button"
                    className="btn btn-dark ms-3"
                    value="Delete"
                    onClick={()=>this.props.handleDelete(emp.bookingId)}
                  />
                </td>
              </tr>
           
            ) )}
          </tbody>
        </table>
      </div>
    );
  }
}

export default BookingTable;
