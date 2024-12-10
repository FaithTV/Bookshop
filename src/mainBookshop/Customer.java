package mainBookshop;

public class Customer {
	private int id;
	private String name;
	private String email;
	private int phoneNo;
	
	/**
	 * @param name
	 * @param email
	 * @param phoneNo
	 */
	public Customer(int id, String name, String email, int phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	
	public int getId() {
		return id;
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
		return "Customer [id=" + id + "name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}
}
