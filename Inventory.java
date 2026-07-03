import java.util.ArrayList;

public class Inventory {
    private ArrayList<Book> mainInventory;
    private ArrayList<Book> lendingInventory;

    public Inventory() {
        mainInventory = new ArrayList<Book>();
        lendingInventory = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        mainInventory.add(book);
        System.out.println("Book added to the library.");
    }

    public void borrowBook(int id) {
        Book book = findBookById(mainInventory, id);

        if (book != null) {
            mainInventory.remove(book);
            lendingInventory.add(book);
            System.out.println("Book successfully borrowed.");
        } else {
            System.out.println("Book was not found or is already borrowed.");
        }
    }

    public void returnBook(int id) {
        Book book = findBookById(lendingInventory, id);

        if (book != null) {
            lendingInventory.remove(book);
            mainInventory.add(book);
            System.out.println("Book successfully returned.");
        } else {
            System.out.println("Book is not currently borrowed.");
        }
    }

    public void printAll() {
        if (mainInventory.isEmpty()) {
            System.out.println("No books are currently available in the library.");
        } else {
            for (Book book : mainInventory) {
                book.printBookInfo();
            }
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;

        for (Book book : mainInventory) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                book.printBookInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    private Book findBookById(ArrayList<Book> list, int id) {
        for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    public int getMainInventoryCount() {
        return mainInventory.size();
    }

    public int getLendingInventoryCount() {
        return lendingInventory.size();
    }
}