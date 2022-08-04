import BookingService from "../service/bookingService";


export const getAllBookingsAction = () => async (dispatch) => {
    const response = await BookingService.getAllBookings();
    console.log(response.data);
    dispatch({
        type: "GET_ALL_BOOKINGS",
        payload: response.data,
    });
};


export const getBookingByIdAction = (id) => async(dispatch) => {
    const response =  await BookingService.getBookingById(id);
    console.log(response.data);
    dispatch({
        type: "GET_BOOKING_BY_ID",
        payload: response.data,
    });
};







