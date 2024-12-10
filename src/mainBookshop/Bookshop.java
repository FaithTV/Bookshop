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
    	HashMap<Integer, Object> customers = new HashMap<>();
    	
    	ArrayList<Book> books = scanBooks("fake_books", Book.class);
    	ArrayList<Comicbook> comicBooks = scanBooks("fake_comic_books", Comicbook.class);
    	ArrayList<Audiobook> audiobooks = scanBooks("fake_audiobooks", Audiobook.class);
    	
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
        
        // Display all books
        for (Object book : allBooks.values()) {
            System.out.println(book);
        }

        System.out.println("Total books loaded: " + allBooks.size());
    	
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
                    addBook(scanner);
                    break;
                case "3":
                    searchBook(scanner);
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

   private static void BooksDropdown(Scanner scanner, HashMap<Integer, Object> allBooks) {
        while (true) {
            System.out.println("\n--- Books ---");
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Find specific book");
            System.out.print("Press 'b' to go back: ");
            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "1":
                    viewBooks(scanner, allBooks);
                    break;
                case "2":
                    addBook(scanner);
                    break;
                case "3":
                    searchBook(scanner);
                    break;
                case "b": // If 'b' or 'B' is pressed, exit the method
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
    
   private static void CustomersDropdown(Scanner scanner, ArrayList<Customer> customers) {
       while (true) {
           System.out.println("\n--- Books ---");
           System.out.println("1. View all registered customers");
           System.out.println("2. Add a new customer");
           System.out.println("3. Find specific book");
           System.out.print("Press 'b' to go back: ");
           String input = scanner.nextLine().trim();

           switch (input.toLowerCase()) {
               case "1":
                   viewCustomers(scanner, customers);
                   break;
               case "2":
                   addBook(scanner);
                   break;
               case "3":
                   searchBook(scanner);
                   break;
               case "b": // If 'b' or 'B' is pressed, exit the method
                   return;
               default:
                   System.out.println("Invalid input. Please try again.");
           }
       }
   }
   
    private static void viewBooks(Scanner scanner,HashMap<Integer, Object> allBooks) {
        while (true) {
            System.out.println("\n--- View Books ---");
            // Add logic to display books here (dummy message for now)
            System.out.println("Displaying all books...");
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

    private static void addBook(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Add a Book ---");
            // Add logic to add a book here (dummy message for now)
            System.out.println("Feature to add a book will be implemented.");

            System.out.print("Press 'b' to go back: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("b")) {
                break;
            } else {
                System.out.println("Invalid input. Press 'b' to go back.");
            }
        }
    }

    private static void searchBook(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Search for a Book ---");
            // Add logic to search for a book here (dummy message for now)
            System.out.println("Feature to search for a book will be implemented.");

            System.out.print("Press 'b' to go back: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("b")) {
                break;
            } else {
                System.out.println("Invalid input. Press 'b' to go back.");
            }
        }
    }
}