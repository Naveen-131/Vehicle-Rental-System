const activeBookingIntialState = {
  activeBookings: [],
  activeBooking: {},
};

const ActiveBookingReducer = (state = activeBookingIntialState, action) => {
  switch (action.type) {
    case "VIEW_ALL_ACTIVEBOOKING":
      return { ...state, activeBookings: action.payload };
    case "GET_ACTIVEBOOKING_BY_ID":
      return { ...state, activeBooking: action.payload };
    
   case "GET_ACTIVEBOOKING_ID":
      return { ...state, activeBooking: action.payload };
    
    default:
      return state;
  }
};

export default ActiveBookingReducer;