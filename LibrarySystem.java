import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice = 0;

        do {
            try {
                displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addBook(scanner, inventory);
                        break;

                    case 2:
                        System.out.print("Enter the book ID to borrow: ");
                        int borrowId = scanner.nextInt();
                        scanner.nextLine();
                        inventory.borrowBook(borrowId);
                        break;

                    case 3:
                        System.out.print("Enter the book ID to return: ");
                        int returnId = scanner.nextInt();
                        scanner.nextLine();
                        inventory.returnBook(returnId);
                        break;

                    case 4:
                        System.out.print("Enter the full or partial book title: ");
                        String searchTitle = scanner.nextLine();
                        inventory.searchByTitle(searchTitle);
                        break;

                    case 5:
                        inventory.printAll();
                        break;

                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose a number from 1 to 6.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers where required.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

        } while (choice != 6);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println();
        System.out.println("Library System Menu");
        System.out.println("1. Add Book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Search by Title");
        System.out.println("5. Print All Books");
        System.out.println("6. Exit");
    }

    public static void addBook(Scanner scanner, Inventory inventory) {
        try {
            System.out.print("Enter book ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter ISBN number: ");
            String isbn = scanner.nextLine();

            System.out.print("Enter number of pages: ");
            int numberOfPages = scanner.nextInt();
            scanner.nextLine();

            Book book = new Book(id, title, author, isbn, numberOfPages);
            inventory.addBook(book);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Book was not added.");
            scanner.nextLine();
        }
    }
}