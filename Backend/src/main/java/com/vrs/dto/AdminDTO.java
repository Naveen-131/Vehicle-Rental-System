package com.vrs.dto;


public class AdminDTO {
	
		// Fields
		private int adminId;
		private String adminName;
		private String adminContact;


		// Constructor
		public AdminDTO() {}
		
		public AdminDTO(int adminId,String adminName,String adminContact) {
			this.adminId = adminId;
			this.adminName = adminName;
			this.adminContact = adminContact;
		}


		// Getter and Setter
		public int getAdminId() {
			return adminId;
		}

		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getAdminContact() {
			return adminContact;
		}

		public void setAdminContact(String adminContact) {
			this.adminContact = adminContact;
		}

		// ToString
		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact="
					+ adminContact + "]";
		}
}
