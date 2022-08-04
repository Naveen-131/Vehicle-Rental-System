import React, { Component } from 'react';
import ActiveBoookingService from '../service/activeBoookingService';
import Joi from "joi-browser";

class AddActiveBooking extends Component {
    state = { 
        activeBooking:{
            activeBookingId:0,
            status:"",
        },
        errors:{},
        errMsg:"",
     };

      
  schema = {
    activeBookingId: Joi.number().required(),
    status: Joi.string().min(3).max(30).alphanum().required(),
    
  };

  validate = () => {
    const errors = {};
    const result = Joi.validate(this.state.activeBooking, this.schema, {
      abortEarly: false,
    });
    console.log(result);

     
     if (result.error !== null) {
        for (let err of result.error.details) {
          errors[err.path[0]] = err.message;
        }
      }
      return Object.keys(errors).length === 0 ? null : errors;
    };

     handleChange=(event) =>{
        const activeBooking = { ...this.state.activeBooking };
        activeBooking[event.target.name] = event.target.value;
         console.log(event.target.name);
         console.log(event.target.value);
         this.setState({ activeBooking: activeBooking });
     }

     handleSubmit = (event) => {
        event.preventDefault();
    
        const errors = this.validate(); 
        this.setState({ errors: errors || {} });
        console.log(errors);
    
        if (errors) return;
       ActiveBoookingService.addActiveBooking(this.state.activeBooking)
          .then((res) => {
            this.props.history.push("/activebooking");
          })
          .catch((error) => this.setState({ errMsg: error.response.data.message }));
      };


    
    render() { 
        return ( 
            <div className="w-50 mx-auto p-3 mt-3" style={{borderStyle:"solid", borderColor:"#FFBE00",borderRadius:"8px"}}>
            {this.state.errMsg && (
                <div 
                    className="alert alert-danger"
                    role="alert">
                    {this.state.errMsg}
                </div>
              )}
              <div className="border shadow-lg p-5">
              <h3 className="bg-primary text-white p-1">Add ActiveBooking</h3>
            <form onSubmit={this.handleSubmit}>
  <div className="mb-3 text-start">
    <label for="activeBookingId" >ActiveBooking Id</label>
    <input 
          type="text" 
          className="form-control" 
          id="activeBookingId"
          name="activeBookingId" 
          value={this.state.activeBooking.activeBookingId} 
          onChange={this.handleChange}/>
    {this.state.errors && (
        <p className="text-danger font-monospace text-start">
          {this.state.errors.activeBookingId}
        </p>
      )}
  </div>

  <div className="mb-3 text-start">
   <label for="status" >Status</label><br/>
      <select style={{ width: "520px", height: "40px" }} 
           name="status" 
           id="staus" 
           value={this.state.activeBooking.status} 
           onChange={(e) => {
                    this.setState((prev) => ({
                    activeBooking: { ...prev.activeBooking, status: e.target.value },
                    }));
          }}>
     <option  value="Pending">Pending</option>
     <option value="Inprogress">Inprogress</option>
     <option value="Cancelled">Cancelled</option>
     <option value="Completed">Completed</option>
   </select>
{this.state.errors && (
  <p className="text-danger font-monospace text-start">
    {this.state.errors.status}
  </p>
)}
  
</div>

 
  
      <button 
        type="submit" 
        className="rounded button">
        ADD
     </button>
 
</form>
</div>
</div>
         );
    }
}
 
export default AddActiveBooking;
