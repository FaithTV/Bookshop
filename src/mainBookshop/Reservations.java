package mainBookshop;

public class Reservations {
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
	public Reservations(Book book, Customer customer, String resDate, String availDate) {
		super();
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
	
	
	@Override
	public String toString() {
		return "Reservations [book=" + book + ", customer=" + customer + ", resDate=" + resDate + ", availDate="
				+ availDate + "]";
	}
	
	
}
