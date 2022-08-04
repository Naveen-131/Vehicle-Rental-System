import React, { Component } from "react";
import CustomerService from "../service/customerService";
import CustomerTable from "./customerTable";
import { Link } from "react-router-dom";
import {ReactComponent as Search} from "../assets/search.svg";

class Customer extends Component {
  state = {
    
    customers: [],
    search: "",
  };
  componentDidMount() {
    CustomerService.getCustomers().then((res) =>
      this.setState({ customers: res.data })
    );
  }

  handleDelete = (id) => {
    //axios.delete("http://localhost/customer/id").then();
    CustomerService.deleteCustomer(id).then((res) => {
      const customers = this.state.customers.filter((cust) => cust.customerId !== id);
      //this.setState({ customers: customers });
      this.setState({ customers });
    });
  };


  handleSearch = (event) => {
    //const emps = [...this.state.employees];
    console.log("handleSearch");
    this.setState({ search: event.target.value });

    const filteredEmps = this.state.customers.filter(
      (emp) =>
        emp.firstName.toLowerCase().startsWith(event.target.value.toLowerCase())
      //emp.firstName.toLowerCase().includes(event.target.value.toLowerCase())
    );
    this.setState({ customers: filteredEmps });
  };

  render() {
    return (
      <div className="d-flex flex-column">
        <div>
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
          </div>
         
        </div>
        <div>
            <Link to="/customer/add">
              <input
                type="button"
                className="btn btn-light float-end m-2 mb-4 border border-dark rounded"
                value="Add"
              />
            </Link>
          </div>
        <CustomerTable
          customers={this.state.customers}
          handleDelete={this.handleDelete}
        />
      </div>
    );
  }
}

export default Customer;