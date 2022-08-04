import Header from './component/Header';

import { Route, Switch } from 'react-router-dom';


import Driver from './component/driver';
import './App.css';
import User from './component/user';
import AddDriver from './component/AddDriver';
import UpdateDriver from './component/UpdateDriver';
import UpdateUser from './component/UpdateUser';

import Payment from './component/payment';
import AddPayment from './component/addPayment';
import PaymentPage from './component/paymentPage';


import Login from "./component/login";
import Logout from "./component/logout";

import Customer from "./component/customer";
import AddCustomer from "./component/addCustomer";
import UpdateCustomer from "./component/updateCustomer";
import CustomerDetails from "./component/customerDetails";


import Booking from "./component/booking";
import AddBooking from "./component/addBooking";
import BookingDetails from "./component/bookingDetails";
import UpdateBooking from "./component/updateBooking";

import BookingCart from "./component/bookingCart"


import Admin from './component/admin';
import AddAdmin from './component/addAdmin';


import ActiveBooking from "./component/activeBooking";
import AddActiveBooking from "./component/addActiveBooking";
import UpdateActiveBooking from "./component/updateActiveBooking";
import ActiveBookingStatus from "./component/activeBookingStatus"
import ActiveBookingPending from './component/activeBookingPending';
import ActiveBookingInprogress from './component/activeBookingInprogress';
import ActiveBooingCancelled from './component/activeBookingCancelled';
import ActiveBookingCompleted from './component/activeBookingCompleted';
import ActiveBookingCard from './component/activeBookingCard';

import UpdateAdmin from './component/updateAdmin';
import Home from  "./component/Home";
import AllBookingsByCustomer from './component/allBookingsByCustomer';
import VehiclesAdmin from "./component/vehiclesAdmin";
import AddVehicle from "./component/addVehicle";
import UpdateVehicle from "./component/updateVehicle";
import VehicleCard from "./component/vehiclesCard";
import VehicleDetails from "./component/vehicleDetails";

import RegisterUser from './component/registerUser';
import RegisterAdmin from './component/registerAdmin';

import DriverCustomer from './component/driverCustomer';
import { useSelector } from 'react-redux';
import CustomerNav from './component/customerNav';
import AdminNav from './component/adminNav';
import AdminRoute from './adminRouter';
import CustomerRoute from './customerRouter';





function App() {
  const login = useSelector((state) => state.login);
  return (
    <div className="App">
      <Header/>
      {login.role==="customer"?<CustomerNav/>:login.role==="admin"?<AdminNav/>:null}
      <Switch>

      <AdminRoute exact path ="/admin/update/:id" component={UpdateAdmin}/> 
      <AdminRoute exact path ="/admin" component={Admin}/>
      <AdminRoute exact path ="/admin/add" component={AddAdmin}/> 

      <Route path ="/login" component={Login}/>
      <Route path ="/logout" component={Logout}/>
      
      <AdminRoute path="/driver" component={Driver}/>
      <AdminRoute path="/addDriver" component={AddDriver}/>
      <AdminRoute path="/updateDriver/:id" component={UpdateDriver}/>
      <CustomerRoute path="/drivers" component={DriverCustomer}/>

      <Route exact path="/user" component={User}/>
      <Route exact path="/" component={Home}/>   
      
  
      <Route path="/customer/customerdetails/:id" component={CustomerDetails} /> 
      <AdminRoute path ="/user/update/:id" component={UpdateUser}/>      
      <Route exact path="/home" component={Home}/>        
     
      <CustomerRoute path="/booking/bookingCart" component={BookingCart}/>
      <Route path="/customer/allBookingByCustomerId/:id" component={AllBookingsByCustomer} />
      <AdminRoute path="/customers" component={Customer} />
      <AdminRoute path="/customer/add" component={AddCustomer} />
      <AdminRoute path="/customer/update/:id" component={UpdateCustomer} />
     
     
      <AdminRoute path="/Bookings" component={Booking} />
      <AdminRoute path="/Booking/add" component={AddBooking} />
      <AdminRoute path="/booking/update/:id" component={UpdateBooking} />
      <Route path="/bookingDetails/:id" component={BookingDetails}/> 
     
      <CustomerRoute path="/activebookingcard/:id" component={ActiveBookingCard} />
      <Route exact path="/" component={Home}/>   
      <AdminRoute path="/activebooking" component={ActiveBooking} />
      <AdminRoute path="/activebookings/add" component={AddActiveBooking} />
      <AdminRoute path="/activebookings/update/:id" component={UpdateActiveBooking} />
      <AdminRoute path="/status" component={ActiveBookingStatus} />
      <AdminRoute path="/pending" component={ActiveBookingPending} />
      <AdminRoute path="/inprogress" component={ActiveBookingInprogress} /> 
      <AdminRoute path="/cancelled" component={ActiveBooingCancelled} />
      <AdminRoute path="/completed" component={ActiveBookingCompleted} />
        
      <AdminRoute path="/vehicles" component={VehiclesAdmin} />
      <AdminRoute path="/vehicle/add" component={AddVehicle} />
      <AdminRoute path="/vehicle/update/:id" component={ UpdateVehicle} />
      <Route path="/vehicle/card" component={ VehicleCard} />     
      <Route path="/user/vehicle-details/:id" component={VehicleDetails}/>

      <AdminRoute path="/payments" component={Payment} />
      <AdminRoute path="/payment/add" component={AddPayment} />
      <Route path="/register/user" component={RegisterUser} />
      <Route path="/paymentsPage/:id" component={PaymentPage} />
      <AdminRoute path="/register/admin" component={RegisterAdmin} />
      </Switch>
    </div>
  );
}

export default App;