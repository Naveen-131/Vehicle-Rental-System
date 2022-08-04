import React, { Component } from 'react';
import { Link } from "react-router-dom";
class ActiveBookingTable extends Component {
    
    render() { 
        return ( 
            <table className="table table-hover table-bordered" style={{backgroundColor:"#FFBE00"}}  >
            <thead >
            <tr>
            <th>ActiveBooking Id</th>
            <th>Status</th>
            <th>Actions</th>
            </tr>
            </thead>
          <tbody>
               {this.props.activeBooking.map((ab) => (
                <tr>
                <td>{ab.activeBookingId}</td>
                <td>{ab.status}</td>
                
                
                <td>
                <Link to={`/activebookings/update/${ab.activeBookingId}`}>
                <input 
                   type="button" 
                   className="btn btn-primary"
                   value="Update" />
                </Link>

                    <input 
                       type="button" 
                       className="btn btn-secondary ms-3" 
                       value="Delete" 
                       onClick={()=>this.props.handleDelete(ab.activeBookingId)}
                     />
                    </td>
                </tr>
            )
                )}
            </tbody>
            </table>
         );
    }
}
 
export default ActiveBookingTable;