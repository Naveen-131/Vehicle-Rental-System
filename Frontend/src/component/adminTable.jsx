
import React, { Component } from 'react';
import { withRouter } from "react-router-dom";

class AdminTable extends Component{
  render(){
    return ( 
        <div className="table-responsive-md d-flex justify-content-center">
        <table className="table w-75 table-hover table-bordered" style={{backgroundColor:"#FFBE00"}}>
  <thead>
    <tr>
    <th scope="col">Admin Id</th>
    <th scope="col">Admin Name</th>
      <th scope="col">Admin Contact Number</th>
      <th rowSpan="3">ACTION</th>  
      </tr>
  </thead>
  <tbody>
      {this.props.admins.map(admin=>( 
      <tr key={admin.adminId}>
      <td>{admin.adminId}</td>
      <td>{admin.adminName}</td>
      <td>{admin.adminContact}</td>

      <td>
                   <input
                    type="button"
                    className="btn btn-light"
                    value="Update"
                    onClick={()=>{
                      this.props.history.push(`/admin/update/${admin.adminId}`);
                    }}
                  />           

                  <input
                    type="button"
                    className="btn btn-dark ms-3"
                    value="Delete"
                    onClick={()=>{this.props.handleDelete(admin.adminId)}}
                  />
                </td>
    </tr>))}
  </tbody>
</table>
</div>
     );
    }
}
 
export default withRouter(AdminTable);




