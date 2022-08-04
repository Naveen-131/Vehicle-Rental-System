import { combineReducers } from "redux";
import LoginReducer from "./loginReducer";
import VehicleReducer from "./vehicleReducer";
import BookingReducer from "./bookingReducer";
import CustomerReducer from "./customerReducer";
import ActiveBookingReducer from "./activeBookingReducer";



const rootReducer = combineReducers({
  login: LoginReducer,
  vehicle: VehicleReducer,
  booking :BookingReducer,

  activeBooking:ActiveBookingReducer,
  customer: CustomerReducer,

});

export default rootReducer;