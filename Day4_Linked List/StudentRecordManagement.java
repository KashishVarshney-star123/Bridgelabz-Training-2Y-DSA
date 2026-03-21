class StudentNode {
    int roll;
    String name;
    int age;
    String grade;
    StudentNode next;

    StudentNode(int r, String n, int a, String g) {
        roll = r;
        name = n;
        age = a;
        grade = g;
        next = null;
    }
}

class StudentList {

    StudentNode head = null;
    void insertAtBeginning(int r, String n, int a, String g) {
        StudentNode newNode = new StudentNode(r, n, a, g);
        newNode.next = head;
        head = newNode;
    }
    void insertAtEnd(int r, String n, int a, String g) {
        StudentNode newNode = new StudentNode(r, n, a, g);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void insertAtPosition(int pos, int r, String n, int a, String g) {
        StudentNode newNode = new StudentNode(r, n, a, g);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        StudentNode temp = head;
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

    void deleteStudent(int roll) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.roll == roll) {
            head = head.next;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found");
            return;
        }
        temp.next = temp.next.next;
    }

    void searchStudent(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Student Found:");
                System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void updateGrade(int roll, String newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade Updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void display() {
        if (head == null) {
            System.out.println("No Records");
            return;
        }
        StudentNode temp = head;
        while (temp != null) {
            System.out.println(
                    "Roll: " + temp.roll +
                    " Name: " + temp.name +
                    " Age: " + temp.age +
                    " Grade: " + temp.grade
            );
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.insertAtBeginning(1, "Rahul", 20, "A");
        list.insertAtEnd(2, "Aman", 21, "B");
        list.insertAtPosition(2, 3, "Riya", 19, "A+");
        System.out.println("Student Records:");
        list.display();
        System.out.println("\nSearch Roll 2");
        list.searchStudent(2);
        System.out.println("\nUpdate Grade");
        list.updateGrade(2, "A");
        System.out.println("\nAfter Update:");
        list.display();
        System.out.println("\nDelete Roll 1");
        list.deleteStudent(1);
        System.out.println("\nAfter Deletion:");
        list.display();
    }
}