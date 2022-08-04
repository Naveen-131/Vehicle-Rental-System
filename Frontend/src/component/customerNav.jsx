import React from 'react';
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

const CustomerNav = () => {

  const customerId = useSelector((state) => state.login.userId);

    return (  
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
  <div className="container-fluid">
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav w-100 me-auto mb-2 mb-lg-0 d-flex justify-content-around">
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/vehicle/card">Vehicles</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/drivers">Drivers</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to={`/customer/allBookingByCustomerId/${customerId}`}>Orders</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to={`/customer/customerdetails/${customerId}`}>User Details</Link>
        </li>
      </ul>
    </div>
  </div>
</nav>
    );
}
 
export default CustomerNav;