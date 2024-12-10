package mainBookshop;

public class Reservations {
	private int id;
	private Book book;
	private Customer customer;
	private String resDate;
	private String availDate;
	
	/**
	 * @param book
	 * @param customer
	 * @param resDate
	 * @param availDate
	 */
	public Reservations(int id, Book book, Customer customer, String resDate, String availDate) {
		super();
		this.id = id;
		this.book = book;
		this.customer = customer;
		this.resDate = resDate;
		this.availDate = availDate;
	}
	
	
	public Book getBook() {
		return book;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public String getResDate() {
		return resDate;
	}
	
	public String getAvailDate() {
		return availDate;
	}
	
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Reservations [book=" + book + ", customer=" + customer + ", resDate=" + resDate + ", availDate="
				+ availDate + "]";
	}
	
	
}
