package mainBookshop;

public class Book {
	private int id;
	private String title;
	private String author;
	private String isbn;
	private String date;
	private boolean availability;
	
	/**
	 * @param id
	 * @param title
	 * @param author
	 * @param isbn
	 * @param date
	 * @param availability
	 */
	public Book(int id, String title, String author, String isbn, String date, boolean availability) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.date = date;
		this.availability = availability;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDate() {
		return date;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Book ID = " + id + ". The book's title is " + title + ", written by " + author + ", with an isbn of " + isbn + " and written on " + date + ". It's availability is: " + availability;
	}
}
