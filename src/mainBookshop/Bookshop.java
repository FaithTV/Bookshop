package mainBookshop;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Bookshop {
	
    public static void main(String[] args) {
    	// Hashmaps to store all the books and customers
    	HashMap<Integer, Object> allBooks = new HashMap<>();
    	HashMap<Integer, Customer> customers = new HashMap<>();
    	HashMap<Integer, Reservations> allReservations = new HashMap<>();
    	
    	// ArrayLists
    	ArrayList<Book> books = scanBooks("fake_books", Book.class);
    	ArrayList<Comicbook> comicBooks = scanBooks("fake_comic_books", Comicbook.class);
    	ArrayList<Audiobook> audiobooks = scanBooks("fake_audiobooks", Audiobook.class);
    	ArrayList<Customer> customersList = scanCustomers();
    	
    	// Add books to the HashMap
        for (Book book : books) {
            allBooks.put(book.getId(), book);
        }
        for (Comicbook comicBook : comicBooks) {
            allBooks.put(comicBook.getId(), comicBook);
        }
        for (Audiobook audiobook : audiobooks) {
            allBooks.put(audiobook.getId(), audiobook);
        }
        // Add customers to the HashMap
        for (Customer customer : customersList) {
        	customers.put(customer.getId(), customer);
        }
        
        // Display all books
        for (Object book : allBooks.values()) {
            System.out.println(book);
        }
        // Display all customers
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }

        System.out.println("Total books loaded: " + allBooks.size());
        System.out.println("Total customers loaded: " + customers.size());
    	
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Bookshop Menu!");
            System.out.println("1. Books");
            System.out.println("2. Customers");
            System.out.println("3. Reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (or 'q' to quit): ");

            input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "1":
                    BooksDropdown(scanner, allBooks);
                    break;
                case "2":
                	CustomersDropdown(scanner, customers);
                    break;
                case "3":
                	ReservationsDropdown(scanner, allReservations, allBooks, customers);
                    break;
                case "4":
                case "q":
                case "quit":
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }
    
    
    
    
    // Scanners for the data
    
    public static <T> ArrayList<T> scanBooks(String dataName, Class<T> type) {
        ArrayList<T> books = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("data/" + dataName + ".csv")));
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                count++;
                if (count == 1) continue;

                String[] data = line.split(",");

                // Dynamically create objects based on the type parameter
                if (type == Book.class) {
                    int id = Integer.parseInt(data[0]);
                    String title = data[1];
                    String author = data[2];
                    String isbn = data[3];
                    String date = data[4];
                    boolean availability = Boolean.parseBoolean(data[5]);

                    T book = type.cast(new Book(id, title, author, isbn, date, availability));
                    books.add(book);
                } else if (type == Comicbook.class) {
                    int id = Integer.parseInt(data[0]);
                    String title = data[1];
                    String author = data[2];
                    String isbn = data[3];
                    String date = data[4];
                    boolean availability = Boolean.parseBoolean(data[5]);
                    String illustrator = data[6];

                    T comicBook = type.cast(new Comicbook(id, title, author, isbn, date, availability, illustrator));
                    books.add(comicBook);
                } else if (type == Audiobook.class) {
                    int id = Integer.parseInt(data[0]);
                    String title = data[1];
                    String author = data[2];
                    String isbn = data[3];
                    String date = data[4];
                    boolean availability = Boolean.parseBoolean(data[5]);
                    String narrator = data[6];

                    T audiobook = type.cast(new Audiobook(id, title, author, isbn, date, availability, narrator));
                    books.add(audiobook);
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
    
    public static ArrayList<Customer> scanCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("data/fake_customers.csv")));
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                count++;
                if (count == 1) continue; // Skip header row

                String[] data = line.split(",");

                // Parse the customer data
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                long phoneNo = Long.parseLong(data[3]);

                // Create a new Customer object and add to the list
                Customer customer = new Customer(id, name, email, phoneNo);
                customers.add(customer);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }
    
    
    
    
    // Books
    
    private static void BooksDropdown(Scanner scanner, HashMap<Integer, Object> allBooks) {
        while (true) {
            System.out.println("\n--- Books ---");
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Find specific book");
            System.out.println("4. Change a book's availability");
            System.out.print("Press 'b' to go back: ");
            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "1":
                    viewBooks(scanner, allBooks); // View all books in the same HashMap
                    break;
                case "2":
                    addBook(scanner, allBooks); // Add a new book to the same HashMap
                    break;
                case "3":
                    searchBook(scanner, allBooks); // Search in the same HashMap
                    break;
                case "4":
                	bookAvailability(scanner, allBooks);
                case "b": // If 'b' or 'B' is pressed, exit the method
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
   
    private static void viewBooks(Scanner scanner, HashMap<Integer, Object> allBooks) {
       while (true) {
           System.out.println("\n--- View Books ---");
           // Display all books
           for (Object book : allBooks.values()) {
               System.out.println(book);
           }
           System.out.print("Press 'b' to go back: ");
           String input = scanner.nextLine().trim();
           if (input.equalsIgnoreCase("b")) {
               break;
           } else {
               System.out.println("Invalid input. Press 'b' to go back.");
           }
       }
   }
   
   private static void addBook(Scanner scanner, HashMap<Integer, Object> allBooks) {
        while (true) {
            System.out.println("\n--- Add a Book ---");

            try {
                // Prompt user for book details
                System.out.print("Enter Book ID: ");
                int id = Integer.parseInt(scanner.nextLine().trim());

                // Check if the ID already exists in the HashMap
                if (allBooks.containsKey(id)) {
                    System.out.println("A book with this ID already exists. Please try again.");
                    continue;
                }

                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine().trim();

                System.out.print("Enter Author Name: ");
                String author = scanner.nextLine().trim();

                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine().trim();

                System.out.print("Enter Publication Date (YYYY-MM-DD): ");
                String date = scanner.nextLine().trim();

                System.out.print("Is the book available? (true/false): ");
                boolean availability = Boolean.parseBoolean(scanner.nextLine().trim());

                // Create a new Book object
                Book newBook = new Book(id, title, author, isbn, date, availability);

                // Add the new book to the HashMap
                allBooks.put(id, newBook);

                System.out.println("Book added successfully: " + newBook);

                // Option to exit the add book menu
                System.out.print("Add another book? (y/n): ");
                String choice = scanner.nextLine().trim();
                if (choice.equalsIgnoreCase("n")) {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values for ID and availability correctly.");
            } catch (Exception e) {
                System.out.println("An error occurred while adding the book. Please try again.");
                e.printStackTrace();
            }
        }
    }
   
   private static void searchBook(Scanner scanner, HashMap<Integer, Object> allBooks) {
	    while (true) {
	        System.out.println("\n--- Search for a Book ---");
	        System.out.print("Enter Book ID to search (or press 'b' to go back): ");
	        String input = scanner.nextLine().trim();

	        if (input.equalsIgnoreCase("b")) {
	            break; // Exit the search menu
	        }

	        try {
	            // Parse the input to an integer
	            int id = Integer.parseInt(input);

	            // Search for the book in the HashMap
	            if (allBooks.containsKey(id)) {
	                Object book = allBooks.get(id);
	                System.out.println("Book found: " + book);
	            } else {
	                System.out.println("No book found with ID " + id);
	            }

	        } catch (NumberFormatException e) {
	            System.out.println("Invalid ID format. Please enter a valid numeric ID.");
	        }
	    }
	}
   
   private static void bookAvailability(Scanner scanner, HashMap<Integer, Object> allBooks) {
	    System.out.println("\n--- Change Book Availability ---");
	    try {
	        // Prompt user for Book ID
	        System.out.print("Enter Book ID to update availability: ");
	        int bookId = Integer.parseInt(scanner.nextLine().trim());

	        // Check if the book exists in the HashMap
	        if (!allBooks.containsKey(bookId)) {
	            System.out.println("No book found with ID " + bookId + ". Please try again.");
	            return;
	        }

	        // Get the book object
	        Book book = (Book) allBooks.get(bookId);

	        // Display current availability
	        System.out.println("Current availability of the book:");
	        System.out.println(book.isAvailability());

	        // Prompt user for new availability status
	        System.out.print("Enter new availability (true/false): ");
	        boolean newAvailability = Boolean.parseBoolean(scanner.nextLine().trim());

	        // Update the availability
	        book.setAvailability(newAvailability);

	        // Display updated book details
	        System.out.println("Book availability updated successfully:");
	        System.out.println(book);

	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input. Please enter a numeric ID for the book.");
	    } catch (Exception e) {
	        System.out.println("An error occurred. Please try again.");
	        e.printStackTrace();
	    }
	}
   
   
   
   
   // Customers
   
   private static void CustomersDropdown(Scanner scanner, HashMap<Integer, Customer> customers) {
       while (true) {
           System.out.println("\n--- Books ---");
           System.out.println("1. View all registered customers");
           System.out.println("2. Add a new customer");
           System.out.println("3. Find a specific customer");
           System.out.print("Press 'b' to go back: ");
           String input = scanner.nextLine().trim();

           switch (input.toLowerCase()) {
               case "1":
                   viewCustomers(scanner, customers);
                   break;
               case "2":
                   addCustomer(scanner, customers);
                   break;
               case "3":
                   searchCustomer(scanner, customers);
                   break;
               case "b": // If 'b' or 'B' is pressed, exit the method
                   return;
               default:
                   System.out.println("Invalid input. Please try again.");
           }
       }
   }

    private static void viewCustomers(Scanner scanner, HashMap<Integer, Customer> customers) {
        while (true) {
            System.out.println("\n--- View Customers ---");
            for (Object book : customers.values()) {
                System.out.println(book);
            }
            System.out.print("Press 'b' to go back: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("b")) {
                break;
            } else {
                System.out.println("Invalid input. Press 'b' to go back.");
            }
        }
    }
    
    private static void addCustomer(Scanner scanner, HashMap<Integer, Customer> allCustomers) {
        while (true) {
            System.out.println("\n--- Add a Customer ---");

            try {
                // Prompt user for customer details
                System.out.print("Enter Customer ID: ");
                int id = Integer.parseInt(scanner.nextLine().trim());

                // Check if the ID already exists in the HashMap
                if (allCustomers.containsKey(id)) {
                    System.out.println("A customer with this ID already exists. Please try again.");
                    continue;
                }

                System.out.print("Enter Customer Name: ");
                String name = scanner.nextLine().trim();

                System.out.print("Enter Customer Email: ");
                String email = scanner.nextLine().trim();

                System.out.print("Enter Customer Phone Number: ");
                long phoneNo = Long.parseLong(scanner.nextLine().trim());

                // Create a new Customer object
                Customer newCustomer = new Customer(id, name, email, phoneNo);

                // Add the new customer to the HashMap
                allCustomers.put(id, newCustomer);

                System.out.println("Customer added successfully: " + newCustomer);

                // Option to exit the add customer menu
                System.out.print("Add another customer? (y/n): ");
                String choice = scanner.nextLine().trim();
                if (choice.equalsIgnoreCase("n")) {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values for ID and phone number correctly.");
            } catch (Exception e) {
                System.out.println("An error occurred while adding the customer. Please try again.");
                e.printStackTrace();
            }
        }
    }
    
    private static void searchCustomer(Scanner scanner, HashMap<Integer, Customer> allCustomers) {
        while (true) {
            System.out.println("\n--- Search for a Customer ---");
            System.out.print("Enter Customer ID to search (or press 'b' to go back): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("b")) {
                break; // Exit the search menu
            }

            try {
                // Parse the input to an integer
                int id = Integer.parseInt(input);

                // Search for the customer in the HashMap
                if (allCustomers.containsKey(id)) {
                    Customer customer = allCustomers.get(id);
                    System.out.println("Customer found: " + customer);
                } else {
                    System.out.println("No customer found with ID " + id);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format. Please enter a valid numeric ID.");
            }
        }
    }
    
    
    
    
    // Reservations
    
    private static void ReservationsDropdown(Scanner scanner, HashMap<Integer, Reservations> allReservations, HashMap<Integer, Object> allBooks, HashMap<Integer, Customer> allCustomers) {
        while (true) {
            System.out.println("\n--- Reservations ---");
            System.out.println("1. View all reservations");
            System.out.println("2. Add a new reservation");
            System.out.println("3. Find specific reservation by ID");
            System.out.println("4. Log a return (remove reservation)");
            System.out.print("Press 'b' to go back: ");
            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "1":
                    viewReservations(scanner, allReservations); // View all reservations
                    break;
                case "2":
                    addReservation(scanner, allReservations, allBooks, allCustomers); // Add a new reservation
                    break;
                case "3":
                    searchReservation(scanner, allReservations); // Search for a specific reservation
                    break;
                case "4":
                    removeReservation(scanner, allReservations); // Remove a reservation
                    break;
                case "b": // If 'b' or 'B' is pressed, exit the method
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void viewReservations(Scanner scanner, HashMap<Integer, Reservations> allReservations) {
        System.out.println("\n--- View Reservations ---");
        if (allReservations.isEmpty()) {
            System.out.println("No reservations available.");
        } else {
            for (Reservations reservation : allReservations.values()) {
                System.out.println(reservation);
            }
        }
        System.out.print("Press 'Enter' to continue...");
        scanner.nextLine();
    }
    
    private static void addReservation(Scanner scanner, HashMap<Integer, Reservations> allReservations, HashMap<Integer, Object> allBooks, HashMap<Integer, Customer> allCustomers) {
    	System.out.println("\n--- Add a New Reservation ---");
        try {
            // Enter Reservation ID
            System.out.print("Enter Reservation ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            if (allReservations.containsKey(id)) {
                System.out.println("A reservation with this ID already exists. Please try again.");
                return;
            }

            // Enter Book ID
            System.out.print("Enter Book ID: ");
            int bookId = Integer.parseInt(scanner.nextLine().trim());

            if (!allBooks.containsKey(bookId)) {
                System.out.println("No book found with ID " + bookId + ". Please try again.");
                return;
            }
            Book book = (Book) allBooks.get(bookId);
            
            // Check if the book is available
            if (!book.isAvailability()) {
                System.out.println("The book with ID " + bookId + " is currently not available.");
                return;
            }

            // Enter Customer ID
            System.out.print("Enter Customer ID: ");
            int customerId = Integer.parseInt(scanner.nextLine().trim());

            if (!allCustomers.containsKey(customerId)) {
                System.out.println("No customer found with ID " + customerId + ". Please try again.");
                return;
            }
            Customer customer = allCustomers.get(customerId);

            // Enter Reservation Date
            System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
            String resDate = scanner.nextLine().trim();

            // Enter Availability Date
            System.out.print("Enter Availability Date (YYYY-MM-DD): ");
            String availDate = scanner.nextLine().trim();

            // Create a new Reservation object
            Reservations newReservation = new Reservations(id, book, customer, resDate, availDate);

            // Mark the book as unavailable
            book.setAvailability(false);
            
            // Add to the reservations HashMap
            allReservations.put(id, newReservation);

            System.out.println("Reservation added successfully: " + newReservation);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values for IDs.");
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
            e.printStackTrace();
        }
    }
    
    private static void searchReservation(Scanner scanner, HashMap<Integer, Reservations> allReservations) {
        System.out.println("\n--- Search for a Reservation ---");
        try {
            System.out.print("Enter Reservation ID to search: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            if (allReservations.containsKey(id)) {
                Reservations reservation = allReservations.get(id);
                System.out.println("Reservation found: " + reservation);
            } else {
                System.out.println("No reservation found with ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric ID.");
        }
    }
    
    private static void removeReservation(Scanner scanner, HashMap<Integer, Reservations> allReservations) {
        System.out.println("\n--- Log a Return (Remove Reservation) ---");
        try {
            System.out.print("Enter Reservation ID to remove: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            if (allReservations.containsKey(id)) {
            	allReservations.get(id).getBook().setAvailability(true);;
                Reservations removed = allReservations.remove(id);
                System.out.println("Reservation removed successfully: " + removed);
            } else {
                System.out.println("No reservation found with ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric ID.");
        }
    }
}