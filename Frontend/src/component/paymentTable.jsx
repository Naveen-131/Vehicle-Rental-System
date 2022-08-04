import React, { Component } from 'react';

class PaymentTable extends Component {
    render() { 
        return (  
          <div className="table-responsive-md d-flex justify-content-center">
          <table className="table w-75 table-hover table-bordered" style={{backgroundColor:"#FFBE00"}}>
            <thead>
              <tr>
                <th>Payment ID</th>
                <th>Payment Mode</th>
                <th>Payment Date</th>
                <th>Booking ID</th>
                <th>Payment Status</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.props.payments.map((pmt) => (
                <tr>
                  <td>{pmt.paymentId}</td>
                  <td>{pmt.paymentMode}</td>
                  <td>{pmt.paymentDate}</td>
                  <td>{pmt.booking.bookingId}</td>
                  <td>{pmt.paymentStatus}</td>
                  <td>
  
                    <input
                      type="button"
                      className="btn btn-dark ms-3"
                      value="Delete"
                      onClick={() => this.props.handleDelete(pmt.paymentId)}
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
 
export default PaymentTable;