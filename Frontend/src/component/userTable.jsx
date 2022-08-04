
import React, { Component } from 'react';
import { withRouter } from "react-router-dom";

class UserTable extends Component{
  render(){
    return ( 
        <div className="table-responsive-md d-flex justify-content-center">
        <table className="table w-75 table-hover table-bordered" style={{backgroundColor:"#FFBE00"}}>
  <thead>
    <tr>
    <th scope="col">User ID</th>
    <th scope="col">Email</th>
      <th scope="col">Role</th>
      <th rowSpan="3">ACTION</th>  
      </tr>
  </thead>
  <tbody>
      {this.props.users.map(user=>( 
      <tr key={user.userId}>
      <td>{user.userId}</td>
      <td>{user.email}</td>
      <td>{user.role}</td>

   
      <td>

                   <input
                    type="button"
                    className="btn btn-light"
                    value="Update"
                    onClick={()=>{
                      this.props.history.push(`/user/update/${user.userId}`);
                    }}
                  /> 

                  <input
                    type="button"
                    className="btn btn-dark ms-3"
                    value="Delete"
                    onClick={()=>{this.props.handleDelete(user.userId)}}
                  />
                </td>
                
    </tr>))}
  </tbody>
</table>
</div>
     );
    }
}
 
export default withRouter(UserTable);




