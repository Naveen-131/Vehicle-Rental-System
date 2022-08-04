import React, { Component } from 'react';
import DriverTable from './driverTable.jsx';
import { NavLink } from 'react-router-dom';
import DriverService from '../service/driverService.jsx';
import {ReactComponent as Search} from "../assets/search.svg";

class Driver extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            drivers:[],
            tempDrivers:[],
            search:"",
    }}

    componentDidMount=async ()=>{
        const response = await DriverService.getAllDriver();
        this.setState({drivers:response.data})
        this.setState({tempDrivers:this.state.drivers})
    }

    handleDelete = (id) =>{
        DriverService.deleteDriver(id).then(res=>{
        const drivers = this.state.tempDrivers.filter(driver=>driver.driverId!==id);
        this.setState({tempDrivers:drivers});
      }
      )
    }

    handleSearch = (event) =>{
      this.setState({ search: event.target.value });
      const filteredDrivers = this.state.drivers.filter(
      (driver) =>
        driver.firstName.toLowerCase().includes(event.target.value.toLowerCase())
    );
    this.setState({ tempDrivers: filteredDrivers });
    }

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
          </div>
          <NavLink className="navbar-brand" to="/addDriver">
          <div>
          <input
            type="button"
            className="btn btn-light float-end m-2 border border-dark rounded"
            value="Add"
          />
        </div>
        </NavLink>
            <DriverTable 
            drivers={this.state.tempDrivers} 
            handleDelete={this.handleDelete}
            handleUpdate={this.handleUpdate}/>
            </div>
        );
    }
}
 
export default Driver   ;