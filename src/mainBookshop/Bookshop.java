package mainBookshop;

import java.util.Scanner;

public class Bookshop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Bookshop Menu!");
            System.out.println("1. View Books");
            System.out.println("2. Add a Book");
            System.out.println("3. Search for a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (or 'q' to quit): ");

            input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "1":
                    viewBooks(scanner);
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

    private static void viewBooks(Scanner scanner) {
        while (true) {
            System.out.println("\n--- View Books ---");
            // Add logic to display books here (dummy message for now)
            System.out.println("Displaying all books...");

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