class MovieNode {
    String title;
    String director;
    int year;
    double rating;

    MovieNode next;
    MovieNode prev;

    MovieNode(String t, String d, int y, double r) {
        title = t;
        director = d;
        year = y;
        rating = r;
        next = null;
        prev = null;
    }
}

class MovieList {
    MovieNode head = null;
    MovieNode tail = null;
    void insertAtBeginning(String t, String d, int y, double r) {
        MovieNode newNode = new MovieNode(t, d, y, r);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void insertAtEnd(String t, String d, int y, double r) {
        MovieNode newNode = new MovieNode(t, d, y, r);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void insertAtPosition(int pos, String t, String d, int y, double r) {
        if (pos == 1) {
            insertAtBeginning(t, d, y, r);
            return;
        }
        MovieNode newNode = new MovieNode(t, d, y, r);
        MovieNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null)
            temp.next.prev = newNode;
        temp.next = newNode;
        if (newNode.next == null)
            tail = newNode;
    }

    void deleteMovie(String title) {
        MovieNode temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }
        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
        else
            tail = temp.prev;
    }

    void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No movie found by this director");
    }

    void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No movie found with this rating");
    }

    void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Rating Updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }
}

public class MovieManage {
    public static void main(String[] args) {
        MovieList list = new MovieList();
        list.insertAtBeginning("Inception", "Nolan", 2010, 9.0);
        list.insertAtEnd("Avatar", "Cameron", 2009, 8.5);
        list.insertAtPosition(2, "Interstellar", "Nolan", 2014, 9.2);
        System.out.println("Movies (Forward):");
        list.displayForward();
        System.out.println("\nMovies (Reverse):");
        list.displayReverse();
        System.out.println("\nSearch by Director (Nolan):");
        list.searchByDirector("Nolan");
        System.out.println("\nUpdate Rating:");
        list.updateRating("Avatar", 9.0);
        System.out.println("\nSearch by Rating (9.0):");
        list.searchByRating(9.0);
        System.out.println("\nAfter Update:");
        list.displayForward();
        System.out.println("\nDelete Movie:");
        list.deleteMovie("Inception");
        System.out.println("\nAfter Deletion:");
        list.displayForward();
    }
}