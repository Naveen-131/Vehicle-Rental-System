import React, { Component } from "react";
import { Link } from "react-router-dom";
import CustomerService from "../service/customerService";


class CustomerTable extends Component {
    state = {
      
      employees: [],
    };

    componentDidMount() {
      CustomerService.getCustomers().then((res) =>
        this.setState({ customers: res.data })
      );
    }

  render() {
    return (
      <div className="table-responsive-md justify-content-center">
      <table className="table table-hover table-bordered" style={{backgroundColor:"#FFBE00"}}>
      
        <thead>
          <tr>
              <th scope= "col">CUSTOMER ID</th>
              <th scope= "col">FIRST NAME</th>
              <th scope= "col">LAST NAME</th>
              <th scope= "col">EMAIL ID</th>
              <th scope= "col">MOBILE NUMBER</th>
              <th scope= "col">ADDRESS</th>
              <th scope= "col">STATE</th>
              <th scope= "col">CITY</th>

            {/* <th>Department</th> */}
            <th colSpan= "2" >ACTION</th>
          </tr>
        </thead>
        <tbody>
          {this.props.customers.map((cust) => (
            <tr key= {cust.customerId}>
              <td>{cust.customerId}</td>
              <td>{cust.firstName}</td>
              <td>{cust.lastName}</td>
              <td>{cust.emailId}</td>
              <td>{cust.mobileNumber}</td>
              <td>{cust.city}</td>
              <td>{cust.state}</td>
              <td>{cust.address}</td>
              {/* <td>{emp.department.deptName}</td> */}
              <td>
              <Link to={`/customer/update/${cust.customerId}`}>
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
                  //onClick={this.props.handleDelete()}
                  onClick={() => this.props.handleDelete(cust.customerId)}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
    );
  }
}

export default CustomerTable;

