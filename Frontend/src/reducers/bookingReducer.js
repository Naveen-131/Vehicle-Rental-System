const bookingIntialState = {
    bookings: [],
    booking: {},
  };
  
  const BookingReducer = (state = bookingIntialState, action) => {
    switch (action.type) {
      case "GET_ALL_BOOKINGS":
        return { ...state, bookings: action.payload };
      case "GET_BOOKING_BY_ID":
        return { ...state, booking: action.payload };
      case "GET_BOOKING_STATUS_BY_BOOKING_ID":
        return { ...state, booking: action.payload };

     
      default:
        return state;
    }
  };
  
  
  
  
  export default BookingReducer;
  