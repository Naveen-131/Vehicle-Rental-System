import React, { Component } from 'react';
import { withRouter } from "react-router-dom";

class DriverTable extends Component{

  render(){
    return ( 
        <div className="table-responsive-md d-flex justify-content-center">
        <table className="table w-75 table-hover table-bordered" style={{backgroundColor:"#FFBE00"}}>
  <thead>
    <tr>
    <th scope="col">FIRST NAME</th>
    <th scope="col">LAST NAME</th>
      <th scope="col">EMAIL</th>
      <th scope="col">ADDRESS</th>
      <th rowSpan="3">ACTION</th>  
      </tr>
  </thead>
  <tbody>
      {this.props.drivers.map(driver=>(       
      <tr key={driver.driverId}>
      <td>{driver.firstName}</td>
      <td>{driver.lastName}</td>
      <td>{driver.email}</td>
      <td>{driver.address}</td>
      <td>
                  <input
                    type="button"
                    className="btn btn-light"
                    value="Update"
                    onClick={()=>{
                      console.log(driver)
                      this.props.history.push(`/updateDriver/${driver.driverId}`);
                    }}
                  />

                  <input
                    type="button"
                    className="btn btn-dark ms-3"
                    value="Delete"
                    onClick={()=>{this.props.handleDelete(driver.driverId)}}
                  />
                </td>
    </tr>))}
  </tbody>
</table>
</div>
     );
    }
}
 
export default withRouter(DriverTable);