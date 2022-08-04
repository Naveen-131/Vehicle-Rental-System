import React, { useEffect, useState } from "react";
import {

  Container,
  
  Card,

  Button,
 
} from "@material-ui/core";
import { NavLink } from "react-router-dom";

import { useSelector, useDispatch } from "react-redux";
import { getCustomerByIdAction } from "../actions/customerAction"



const CustomerDetails = (props) => {
  const dispatch = useDispatch();

  useEffect(() => {
    console.log(props.match.params.id)
    dispatch(getCustomerByIdAction(props.match.params.id));
  }, []);

  const customer = useSelector((state) => state.customer.customer);
  return (
    <Container>
    <Container>
     <br/>
     <br />
         <div className="row" mt={-5}>
                <div className="col-lg-12">
                   
                    <nav aria-label="breadcrumb">
                        <ol className="breadcrumb" style={{backgroundColor: "rgb(246, 247, 247)",height:"45px",borderRadius:"10px",paddingTop:"10px",paddingLeft:"10px"}}>
                            <li className="breadcrumb-item" ><a href="/" style={{color: "#FFBE00",fontSize:"20px"}}>Home</a></li>
                            <li aria-current="page" className="breadcrumb-item active" style={{color: "#000000",fontSize:"20px"}}>My Profile</li>
                        </ol>
                    </nav>
                </div>
            </div>
            <div className="container">
           
           <div className="row">
               <div className="col-lg-12">
               <Card>
                
               <Card style={{border:"none"}}>
                        <h3 className="mt-4 mb-4" style={{textAlign:"left",paddingLeft:"10px"}}>Hi {customer.firstName}!</h3>
                        <p className="text-muted" style={{textAlign:"left",paddingLeft:"10px",marginTop:"-10px"}}>Your profile information.</p>
                    <hr />
                        <div className="box">
                        <Card style={{paddingLeft:"10px",paddingRight:"10px"}}>
                        <div className="content py-3">
                        <form>
                                <div className="row">
                                        <div className="col-md-6">
                                            <div className="form-group">
                                       
                                            <label for="customerId" style={{fontWeight:"bolder",float:"left"}}>Customer Id</label>
                                            <input
                                            type="text"
                                            disabled

                                
                                            className="form-control"
                                            id="customerId"
                                            name="customerId"
                                          
                                            value={customer.customerId}
                                            
                                            />
                                            
                                            </div>
                                          </div>
                                          <div>

                                          </div>


                                          </div>



                                        <div className="row">
                                        <div className="col-md-6">
                                            <div className="form-group">
                                       
                                            <label for="firstName" style={{fontWeight:"bolder",float:"left"}}>First Name</label>
                                            <input
                                            type="text"
                                            disabled

                                
                                            className="form-control"
                                            id="firstName"
                                            name="firstName"
                                          
                                            value={customer.firstName}
                                            
                                            />
                                            
                                            </div>
                                          </div>


                                          <div className="col-md-6">
                                            <div className="form-group">
                                       
                                            <label for="lastName" style={{fontWeight:"bolder",float:"left"}}>Last Name</label>
                                            <input
                                            type="text"
                                            disabled

                                
                                            className="form-control"
                                            id="lastName"
                                            name="lastName"
                                          
                                            value={customer.lastName}
                                            
                                            />
                                            
                                            </div>
                                          </div>
                                          <div>
                                            
                                          </div>


                                          </div>




                                          <div className="row">
                                        <div className="col-md-6">
                                            <div className="form-group">
                                       
                                            <label for="mobileNumber" style={{fontWeight:"bolder",float:"left"}}>Mobile No</label>
                                            <input
                                            type="text"
                                            disabled

                                
                                            className="form-control"
                                            id="mobileNumber"
                                            name="mobileNumber"
                                          
                                            value={customer.mobileNumber}
                                            
                                            />
                                            
                                            </div>
                                          </div>


                                          <div className="col-md-6">
                                            <div className="form-group">
                                       
                                            <label for="Address" style={{fontWeight:"bolder",float:"left"}}>Address</label>
                                            <input
                                            type="text"
                                            disabled

                                
                                            className="form-control"
                                            id="Address"
                                            name="Address"
                                          
                                            value={customer.address}
                                            
                                            />
                                            
                                            </div>
                                          </div>
                                          <div>
                                            
                                          </div>


                                          </div>



                                        <div className="row">
                                        <div className="col-md-6">
                                            <div className="form-group">
                                       
                                            <label for="city" style={{fontWeight:"bolder",float:"left"}}>City</label>
                                            <input
                                            type="text"
                                            disabled

                                
                                            className="form-control"
                                            id="city"
                                            name="city"
                                          
                                            value={customer.city}
                                            
                                            />
                                            
                                            </div>
                                          </div>


                                          <div className="col-md-6">
                                            <div className="form-group">
                                       
                                            <label for="state" style={{fontWeight:"bolder",float:"left"}}>State</label>
                                            <input
                                            type="text"
                                            disabled

                                
                                            className="form-control"
                                            id="state"
                                            name="state"
                                          
                                            value={customer.state}
                                            
                                            />
                                            
                                            </div>
                                          </div>
                                          <div>
                                            
                                          </div>


                                          </div>
                                          <br />
                                   
                                    
                                    <div className="box-footer d-flex justify-content-between">
                                    <Button  className="btn btn-outline-secondary" component={NavLink} to={`/`}>Back to Home</Button>
                                    <div className="box-footer d-flex justify-content-between"><Button type="submit" value="UPDATE" className="btn btn-outline-primary" style={{border: "none", backgroundColor: "#FFBE00", color: "white"}} component={NavLink} to={`/customer/update/${customer.customerId}`}>Update details</Button></div>
                               
                                    </div>



                                          </form>
                                          </div>
                                          </Card>
                                        </div>

                        
                    </Card>
                    </Card>
                </div>
                
            </div>
        </div>
<br />
<br />
</Container>

                            


    
   
  </Container>
   
  );
};

export default CustomerDetails;
