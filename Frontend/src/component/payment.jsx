import React, { Component } from 'react';
import paymentService from '../service/paymentService';
import PaymentTable from "./paymentTable";
import { Link } from "react-router-dom";


 class Payment extends Component {
     state = {
         payments: [],
     };
     componentDidMount(){
         paymentService.viewAllPayments().then((res) =>
          this.setState({payments : res.data})
         );
     }
     handleDelete = (id) => {
          paymentService.cancelPayment(id).then((res) => {
            const payments = this.state.payments.filter((pmt) =>pmt.paymentId !== id);
            this.setState({ payments });
          });
        };

     
     render() { 
         return (
          <div className="mt-3 w-75 mx-auto">
          <div>
          <Link to="/payment/add">
            <input
              type="button"
              className="btn btn-success float-end mb-3"
              value="Add"
            />
            </Link>
          </div>
          <PaymentTable
          payments={this.state.payments}
          handleDelete={this.handleDelete}
        />
          </div>
         );
     }
 }
  
 export default Payment;