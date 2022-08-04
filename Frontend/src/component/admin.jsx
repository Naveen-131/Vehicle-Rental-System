import React, { Component } from 'react';
 import AdminTable from "./adminTable";
import { NavLink } from 'react-router-dom';
import AdminService from '../service/adminService';
import {ReactComponent as Search} from "../assets/search.svg";
class Admin extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            admins:[],
            tempAdmins:[],
            search:"",
    }}
    

    componentDidMount=async ()=>{
        const response = await AdminService.viewAllAdmins();
        this.setState({admins:response.data})
        this.setState({tempAdmins:this.state.admins})
    }

    handleDelete = (id) =>{
        AdminService.deleteAdmin(id).then(res=>{
        const admins = this.state.tempAdmins.filter(admin=>admin.adminId!==id);
        this.setState({tempAdmins:admins});
      }
      )
    }

    handleSearch = (event) =>{
      this.setState({ search: event.target.value });
      const filteredAdmins = this.state.admins.filter(
      (admin) =>
        admin.adminName.toLowerCase().includes(event.target.value.toLowerCase())
    );
    this.setState({ tempAdmins: filteredAdmins });
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
          <NavLink className="navbar-brand" to="/admin/add">
          <div>
          <input
            type="button"
            className="btn btn-light float-end m-2 mb-4 border border-dark rounded"
            value="Add"
          />
        </div>
        </NavLink>
            <AdminTable 
            admins={this.state.tempAdmins} 
            handleDelete={this.handleDelete}
            handleUpdate={this.handleUpdate}/>
            </div>
        );
    }
}
 
export default Admin   ;



