class Ticket {
    int ticketID;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return String.format("[ID: %d | Customer: %s | Movie: %s | Seat: %s | Time: %s]", 
                             ticketID, customerName, movieName, seatNumber, bookingTime);
    }
}

class ReservationSystem {
    private Ticket last = null;
    private int count = 0;
    public void addTicket(int id, String name, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, name, movie, seat, time);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        count++;
        System.out.println("Ticket booked for " + name);
    }

    public void removeTicket(int id) {
        if (last == null) return;Ticket curr = last.next;
        Ticket prev = last;
        boolean found = false;
        do {
            if (curr.ticketID == id) {
                if (curr == last && curr.next == last) {
                    last = null;
                } else {
                    prev.next = curr.next;
                    if (curr == last) last = prev;
                }
                count--;
                found = true;
                System.out.println("Ticket ID " + id + " canceled.");
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != last.next);

        if (!found) System.out.println("Ticket ID not found.");
    }

    public void displayTickets() {
        if (last == null) {
            System.out.println("No active reservations.");
            return;
        }
        Ticket temp = last.next;
        System.out.println("\n--- Current Reservations ---");
        do {
            System.out.println(temp);
            temp = temp.next;
        } while (temp != last.next);
    }

    // 4. Search for a ticket by Customer Name or Movie Nam
    public void searchTicket(String query) {
        if (last == null) return;
        Ticket temp = last.next;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found: " + temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);
        
        if (!found) System.out.println("No matching tickets found.");
    }

    public int getTotalTickets() {
        return count;
    }
}

public class OnlineTicket {
    public static void main(String[] args) {
        ReservationSystem rs = new ReservationSystem();
        rs.addTicket(501, "Alice", "Inception", "A12", "10:00 AM");
        rs.addTicket(502, "Bob", "Avatar", "B05", "01:00 PM");
        rs.addTicket(503, "Charlie", "Inception", "A13", "10:00 AM");
        rs.displayTickets();
        System.out.println("\nSearching for 'Inception'...");
        rs.searchTicket("Inception");
        rs.removeTicket(502);
        rs.displayTickets();
        System.out.println("\nTotal Booked: " + rs.getTotalTickets());
    }
}
