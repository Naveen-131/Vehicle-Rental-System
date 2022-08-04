import axios from "axios";


const BASE_URL = "http://localhost:8081/booking";

class BookingService {
  async getBookings() {
    return await axios.get(BASE_URL + "/all");
  }

  async createBooking(booking) {
    return await axios.post(BASE_URL+ "/add/",booking);
  }

  async getBookingById(bookingId) {
    return await axios.get(BASE_URL + "/bookingById/" + bookingId);
  }

  async updateBooking(booking) {
    return await axios.put(BASE_URL+"/update/", booking);
  }

  async deleteBooking(bookingId) {
    return await axios.delete(BASE_URL + "/cancel/" + bookingId);
  }

  async getActiveBookingByBookingId(bookingId) {
    return await axios.get(BASE_URL + "/BookingStatus/" + bookingId);
  }
}

export default new BookingService();
