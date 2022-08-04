import axios from "axios";

const BASE_URL = "http://localhost:8081/customer";

class CustomerService {
  async getCustomers() {
    return await axios.get(BASE_URL + "/all");
  }

  async createCustomer(customer) {
    return await axios.post(BASE_URL, customer);
  }

  async getCustomerById(customerId) {
    return await axios.get(BASE_URL + "/" + customerId);
  }

  async updateCustomer(customer) {
    return await axios.put(BASE_URL + "/update/" ,customer);
  }

  async deleteCustomer(customerId) {
    return await axios.delete(BASE_URL + "/remove/" + customerId);
    //"http://localhost:8086/customer/100"
  }

  async getBookingsByCustomerId(customerId) {
    return await axios.get(BASE_URL + "/getbookingdetails/" + customerId);
    //"http://localhost:8086/customer/100"
  }



}

export default new CustomerService();