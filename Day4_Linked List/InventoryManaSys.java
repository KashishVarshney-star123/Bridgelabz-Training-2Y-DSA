class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int id, String name, int q, double p) {
        itemId = id;
        itemName = name;
        quantity = q;
        price = p;
        next = null;
    }
}

class InventoryList {
    ItemNode head = null;
    void insertAtBeginning(int id, String name, int q, double p) {
        ItemNode newNode = new ItemNode(id, name, q, p);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int id, String name, int q, double p) {
        ItemNode newNode = new ItemNode(id, name, q, p);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void insertAtPosition(int pos, int id, String name, int q, double p) {
        if (pos == 1) {
            insertAtBeginning(id, name, q, p);
            return;
        }
        ItemNode newNode = new ItemNode(id, name, q, p);
        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteItem(int id) {
        if (head == null) {
            System.out.println("Inventory Empty");
            return;
        }
        if (head.itemId == id) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found");
            return;
        }
        temp.next = temp.next.next;
    }

    void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity Updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                System.out.println(temp.itemId + " " + temp.itemName +
                        " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equals(name)) {
                System.out.println(temp.itemId + " " + temp.itemName +
                        " " + temp.quantity + " " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Item not found");
    }

    void totalValue() {
        ItemNode temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value = " + total);
    }

    void sortByPrice() {
        if (head == null)
            return;
        ItemNode i, j;
        for (i = head; i.next != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {
                if (i.price > j.price) {
                    int tempId = i.itemId;
                    String tempName = i.itemName;
                    int tempQty = i.quantity;
                    double tempPrice = i.price;
                    i.itemId = j.itemId;
                    i.itemName = j.itemName;
                    i.quantity = j.quantity;
                    i.price = j.price;
                    j.itemId = tempId;
                    j.itemName = tempName;
                    j.quantity = tempQty;
                    j.price = tempPrice;
                }
            }
        }
    }

    void display() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println(
                    temp.itemId + " | " +
                    temp.itemName + " | Qty: " +
                    temp.quantity + " | Price: " +
                    temp.price
            );
            temp = temp.next;
        }
    }
}

public class InventoryManaSys{
    public static void main(String[] args) {
        InventoryList list = new InventoryList();
        list.insertAtBeginning(101, "Laptop", 5, 60000);
        list.insertAtEnd(102, "Mouse", 20, 500);
        list.insertAtEnd(103, "Keyboard", 10, 1500);
        list.insertAtPosition(2, 104, "Monitor", 7, 8000);
        System.out.println("Inventory List:");
        list.display();
        System.out.println("\nSearch Item ID 102:");
        list.searchById(102);
        System.out.println("\nUpdate Quantity:");
        list.updateQuantity(103, 15);
        System.out.println("\nSearch by Name (\"Mouse\"):");
        list.searchByName("Mouse");
        System.out.println("\nTotal Inventory Value:");
        list.totalValue();
        System.out.println("\nSorted by Price:");
        list.sortByPrice();
        list.display();
        System.out.println("\nDelete Item 101:");
        list.deleteItem(101);
        System.out.println("\nAfter Deletion:");
        list.display();
    }
}