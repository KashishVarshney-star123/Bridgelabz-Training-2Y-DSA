class Book {
    String title, author, genre;
    int bookID;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(int bookID, String title, String author, String genre, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return String.format("[ID: %d | Title: %s | Author: %s | Genre: %s | Available: %s]", 
                             bookID, title, author, genre, isAvailable ? "Yes" : "No");
    }
}

class Library {
    private Book head;
    private Book tail;
    private int size;
    public void addBookAtEnd(int id, String title, String author, String genre, boolean status) {
        Book newBook = new Book(id, title, author, genre, status);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        size++;
    }

    public void addBookAtBeginning(int id, String title, String author, String genre, boolean status) {
        Book newBook = new Book(id, title, author, genre, status);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        size++;
    }

    public void removeBook(int id) {
        Book current = head;
        while (current != null) {
            if (current.bookID == id) {
                if (current == head) head = head.next;
                if (current == tail) tail = tail.prev;
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                size--;
                System.out.println("Book ID " + id + " removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book ID " + id + " not found.");
    }

    public void searchBook(String query) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(query) || current.author.equalsIgnoreCase(query)) {
                System.out.println("Found: " + current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No books found matching: " + query);
    }

    public void updateAvailability(int id, boolean status) {
        Book current = head;
        while (current != null) {
            if (current.bookID == id) {
                current.isAvailable = status;
                System.out.println("Status updated for ID " + id);
                return;
            }
            current = current.next;
        }
    }

    public void displayForward() {
        System.out.println("\nBooks (Forward):");
        Book current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        System.out.println("\nBooks (Reverse):");
        Book current = tail;
        while (current != null) {
            System.out.println(current);
            current = current.prev;
        }
    }

    public int getTotalBooks() {
        return size;
    }
}

public class LibraryManage {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBookAtEnd(101, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", true);
        lib.addBookAtEnd(102, "1984", "George Orwell", "Dystopian", true);
        lib.addBookAtBeginning(100, "The Hobbit", "J.R.R. Tolkien", "Fantasy", true);
        lib.displayForward();
        lib.displayReverse();
        System.out.println("\nTotal Books: " + lib.getTotalBooks());
        lib.searchBook("1984");
        lib.updateAvailability(101, false);
        lib.removeBook(102);
        lib.displayForward();
    }
}