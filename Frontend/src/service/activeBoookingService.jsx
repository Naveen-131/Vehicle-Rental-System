import axios from 'axios';

const BASE_URL = "http://localhost:8081/activebooking";

class ActiveBookingService {
  async viewAllActiveBooking() {
    return await axios.get(BASE_URL + "/all");
  }

  async addActiveBooking(activeBooking) {
    return await axios.post(BASE_URL, activeBooking);
  }

  async getActiveBookingById(activeBookingId) {
    return await axios.get(BASE_URL + "/byId/" + activeBookingId);
  }

  async updateActiveBooking(activeBooking) {
    return await axios.put(BASE_URL+ "/update", activeBooking);
  }

  async deleteActiveBookingbyId(activeBookingId) {
    return await axios.delete(BASE_URL + "/byId/" + activeBookingId);
  }
  async findByPending() {
    return await axios.get(BASE_URL + "/pending" );
  }

  async findByInprogress() {
    return await axios.get(BASE_URL + "/inprogress" );
  }

  async findByCancelled() {
    return await axios.get(BASE_URL + "/cancelled" );
  }

  async findByCompleted() {
    return await axios.get(BASE_URL + "/completed" );
  }

 
}

export default new ActiveBookingService();