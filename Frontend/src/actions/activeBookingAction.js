import activeBoookingService from "../service/activeBoookingService";
import BookingService from "../service/bookingService";

export const viewAllActiveBookingAction = () => async (dispatch) => {
    const response = await activeBoookingService.viewAllActiveBooking();
    console.log(response.data);
    dispatch({
        type: "VIEW_ALL_ACTIVEBOOKING",
        payload: response.data,
    });
};


export const getActiveBookingByIdAction = (id) => async(dispatch) => {
    const response =  await activeBoookingService.getActiveBookingById(id);
    console.log(response.data);
    dispatch({
        type: "GET_ACTIVEBOOKING_BY_ID",
        payload: response.data,
    });
};



export const getActiveBookingByBookingIdAction = (id) => async(dispatch) => {
    const response =  await BookingService.getActiveBookingByBookingId(id);
    console.log(response.data);
    dispatch({
        type: "GET_ACTIVEBOOKING_BY_ID",
        payload: response.data,
    });
};