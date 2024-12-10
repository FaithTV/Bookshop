package mainBookshop;

public class Customer {
	private int id;
	private String name;
	private String email;
	private long phoneNo;
	
	/**
	 * @param name
	 * @param email
	 * @param phoneNo
	 */
	public Customer(int id, String name, String email, long phoneNo) {
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

	public long getPhoneNo() {
		return phoneNo;
	}
	

	@Override
	public String toString() {
		return "Customer ID = " + id + ". The customer is named " + name + ", their email is " + email + " and their phone number is " + phoneNo;
	}
}
