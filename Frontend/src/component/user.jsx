import React, { Component } from 'react';
 import UserTable from "./userTable";
import { NavLink } from 'react-router-dom';
import UserService from '../service/userService';
import {ReactComponent as Search} from "../assets/search.svg";

class User extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            users:[],
            tempUsers:[],
            search:"",
    }}

    componentDidMount=async ()=>{
        const response = await UserService.getAllUsers();
        this.setState({users:response.data})
        this.setState({tempUsers:this.state.users})
    }

    handleDelete = (id) =>{
        UserService.deleteUser(id).then(res=>{
        const users = this.state.tempUsers.filter(user=>user.userId!==id);
        this.setState({tempUsers:users});
      }
      )
    }

    handleSearch = (event) =>{
      this.setState({ search: event.target.value });
      const filteredUsers = this.state.users.filter(
      (user) =>
        user.role.toLowerCase().includes(event.target.value.toLowerCase())
    );
    this.setState({ tempUsers: filteredUsers });
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
                placeholder="Search by role"
                onChange={this.handleSearch}
                value={this.state.search}
              />
            </form>
          </div>


        
          <div>
          <NavLink className="navbar-brand" to="/register/user">
          <input
            type="button"
            className="btn btn-light float-end m-2 mb-4 border border-dark rounded"
            value="Add User"
          />  
          </NavLink>        
        
      


        <NavLink className="navbar-brand" to="/register/admin">
          
          <input
            type="button"
            className="btn btn-light float-end m-2 mb-4 border border-dark rounded"
            value="Add Admin"
          />
            </NavLink>
        </div>
   


            <UserTable 
            users={this.state.tempUsers} 
            handleDelete={this.handleDelete}
            handleUpdate={this.handleUpdate}/>
            </div>
        );
    }
}
 
export default User   ;



