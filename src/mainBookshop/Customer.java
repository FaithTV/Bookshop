package mainBookshop;

public class Customer {
	private String name;
	private String email;
	private int phoneNo;
	
	/**
	 * @param name
	 * @param email
	 * @param phoneNo
	 */
	public Customer(String name, String email, int phoneNo) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}
}
