import axios from "axios";

const BASE_URL = "http://localhost:8081/admin";

class AdminService { 
  async viewAllAdmins() {
    return await axios.get(BASE_URL + "/all");
  }

  async addNewAdmin(admin) {
    return await axios.post(BASE_URL+ "/add", admin);
  }

  async viewAdminById(adminId) {
    return await axios.get(BASE_URL + "/" + adminId);
  }

 
  async updateAdmin(admin) {
    return await axios.put(BASE_URL+"/update", admin);
  }

  async deleteAdmin(adminId) {
    return await axios.delete(BASE_URL + "/" + adminId);

  }
}

export default new AdminService();