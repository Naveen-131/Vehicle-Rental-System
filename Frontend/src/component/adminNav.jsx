import React from 'react';
import { Link } from 'react-router-dom';

const AdminNav = () => {
    return ( 
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
  <div className="container-fluid">
    <Link className="navbar-brand" to="#">ADMIN</Link>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav w-100 me-auto mb-2 mb-lg-0 d-flex justify-content-around">
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/bookings">Booking</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/customers">Customer</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/user">User</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/driver">Driver</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/activebooking">Active Booking</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/vehicles">Vehicle</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/payments">Payment</Link>
        </li>
      </ul>
    </div>
  </div>
</nav>
     );
}
 
export default AdminNav;