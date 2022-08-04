
import CustomerService from "../service/customerService.js";



export const getAllCustomersAction = () => async (dispatch) => {
    const response = await CustomerService.getAllCustomers();
    console.log(response.data);
    dispatch({
        type: "GET_ALL_CUSTOMERS",
        payload: response.data,
    });
};


export const getCustomerByIdAction = (id) => async(dispatch) => {
    const response =  await CustomerService.getCustomerById(id);
    console.log(response.data);
    dispatch({
        type: "GET_CUSTOMER_BY_ID",
        payload: response.data,
    });
};



export const getBookingsByCustomerIdAction = (id) => async(dispatch) => {
    const response =  await CustomerService.getBookingsByCustomerId(id);
    console.log(response.data);
    dispatch({
        type: "GET_BOOKINGS_BY_CUSTOMER_ID",
        payload: response.data,
    });
};

export const getCustomersByLocationAction = (location) => async (dispatch) => {
    const response = await CustomerService.getCustomerByLocation(location);
    console.log(response.data);
    dispatch({
        type: "GET_CUSTOMER_BY_LOCATION",
        payload: response.date,
    });
};







