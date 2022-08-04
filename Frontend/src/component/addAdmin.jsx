import React, { Component } from "react";
import Joi from "joi-browser";
import AdminService from '../service/adminService';
// import './css/AddAdmin.css';

class AddAdmin extends Component {
    constructor(props) {
        super(props);
        this.state = {  
            admin:{
               // adminId:0,
                adminName:"",
                adminContact:"",
                
            },
            errors:{},
            errMsg:"",
        };
    }
  
  
 //schema to validate
 schema = {
   // adminId:Joi.number().min(3).required(),
    adminName:Joi.string().min(1).required(),
    adminContact:Joi.string().min(10).required(),
    
}

validate=()=>{
    const errors={};
    const result = Joi.validate(this.state.admin,this.schema, {
        abortEarly: false,
      });
    
    if (result.error !== null) {
        for (let err of result.error.details) {
          errors[err.path[0]] = err.message;
        }
      }
    return Object.keys(errors).length===0?null:errors;
}


  handleChange = (event) => {
    const admin ={...this.state.admin};
    admin[event.target.name] = event.target.value;
    this.setState({admin});
  };

  handleSubmit = (event) => {
    event.preventDefault();
        const errors = this.validate();
        this.setState({errors:errors||{}});

        if(errors) return;

        AdminService.addNewAdmin(this.state.admin)
        .then(res=>this.props.history.push("/admin"))
        .catch((error) => this.setState({ errMsg: error.response.data.message }));
    }
    
  render() {
    return (
      <div className="w-50 mx-auto p-4 mt-5 " style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
         {this.state.errMsg && (
          <div className="alert alert-danger" role="alert">
            {this.state.errMsg}
            </div>
         )}
        ADD ADMIN

        <form onSubmit={this.handleSubmit}>
         
        {/* <div className="mb-3 text-start">
        <label htmlFor="adminId">Admin ID</label>
        <input placeholder="Admin ID" className="form-control"
                onChange={this.handleChange}
                value={this.state.admin.adminId}
                name="adminId"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.adminId}
                </p>
                )}
        </div> */}
        <div className="mb-3 text-start">
        <label htmlFor="adminName">Admin Name</label>        
                <input placeholder="Admin Name" className="form-control"
                onChange={this.handleChange}
                value={this.state.admin.adminName}
                name="adminName"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.adminName}
                </p>
                )}
        </div>
     
       
        <div className="mb-3 text-start">
        <label htmlFor="adminContact">Contact Number</label>        
                <input placeholder="Contact Number" className="form-control"
                onChange={this.handleChange}
                value={this.state.admin.adminContact}
                name="adminContact"></input>
                {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                {this.state.errors.adminContact}
                </p>
                )}
        </div>
           
                <input type="submit" className="rounded button" value="ADD"></input>
            </form>
      </div>
    );
  }
}

export default AddAdmin;