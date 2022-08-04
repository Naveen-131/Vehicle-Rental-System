const customerIntialState = {
    customers: [],
    customer: {},
  };
  
  const CustomerReducer = (state = customerIntialState, action) => {
    switch (action.type) {
      case "GET_ALL_CUSTOMERS":
        return { ...state, customers: action.payload };
      case "GET_CUSTOMER_BY_ID":
        return { ...state, customer: action.payload };
      case "GET_CUSTOMER_BY_LOCATION":
        return { ...state, customers: [...action.payload] };
     case "GET_BOOKINGS_BY_CUSTOMER_ID":
        return { ...state, customers: [...action.payload] };  
      default:
        return state;
    }
  };
  
  
  
  
  export default CustomerReducer;
  