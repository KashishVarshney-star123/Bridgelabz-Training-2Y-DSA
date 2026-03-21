import java.util.ArrayList;
import java.util.List;

class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }

    public int getAge() {
        return age;
    }
}

class SocialNetwork {
    private User head = null;
    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    public User findUser(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendship(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            if (!u1.friendIDs.contains(id2)) u1.friendIDs.add(id2);
            if (!u2.friendIDs.contains(id1)) u2.friendIDs.add(id1);
            System.out.println("Friendship established between " + u1.name + " and " + u2.name);
        }
    }

    public void removeFriendship(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            u1.friendIDs.remove(Integer.valueOf(id2));
            u2.friendIDs.remove(Integer.valueOf(id1));
            System.out.println("Friendship removed.");
        }
    }

    public void findMutualFriends(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 == null || u2 == null) return;
        System.out.print("Mutual friends of " + u1.name + " and " + u2.name + ": ");
        boolean found = false;
        for (int fID : u1.friendIDs) {
            if (u2.friendIDs.contains(fID)) {
                System.out.print(fID + " ");
                found = true;
            }
        }
        if (!found) System.out.print("None");
        System.out.println();
    }

    public void displayFriends(int id) {
        User u = findUser(id);
        if (u != null) {
            System.out.println(u.name + " (Age: " + u.getAge() + ")'s Friends List (Count: " + u.friendIDs.size() + "): " + u.friendIDs);
        }
    }
}

public class SocialMedia {
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();
        sn.addUser(1, "Alice", 25);
        sn.addUser(2, "Bob", 28);
        sn.addUser(3, "Charlie", 22);
        sn.addUser(4, "David", 30);
        sn.addFriendship(1, 2);
        sn.addFriendship(1, 3);
        sn.addFriendship(2, 3);
        sn.addFriendship(2, 4);
        sn.findMutualFriends(1, 2);
        sn.displayFriends(2);
    }
}