class TaskNode {
    int taskId;
    String taskName;
    String priority;
    String dueDate;

    TaskNode next;

    TaskNode(int id, String name, String p, String date) {
        taskId = id;
        taskName = name;
        priority = p;
        dueDate = date;
        next = null;
    }
}

class TaskSchedulerList {
    TaskNode head = null;
    TaskNode current = null;
    void insertAtBeginning(int id, String name, String p, String date) {
        TaskNode newNode = new TaskNode(id, name, p, date);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    void insertAtEnd(int id, String name, String p, String date) {
        TaskNode newNode = new TaskNode(id, name, p, date);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    void insertAtPosition(int pos, int id, String name, String p, String date) {
        if (pos == 1) {
            insertAtBeginning(id, name, p, date);
            return;
        }
        TaskNode newNode = new TaskNode(id, name, p, date);
        TaskNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        TaskNode temp = head;
        TaskNode prev = null;
        if (head.taskId == id) {
            while (temp.next != head) {
                temp = temp.next;
            }
            if (head.next == head) {
                head = null;
                return;
            }
            temp.next = head.next;
            head = head.next;
            return;
        }
        temp = head;
        while (temp.next != head && temp.taskId != id) {
            prev = temp;
            temp = temp.next;
        }
        if (temp.taskId != id) {
            System.out.println("Task not found");
            return;
        }
        if (prev != null) {
            prev.next = temp.next;
        }
    }

    void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }
        System.out.println("Current Task:");
        System.out.println(current.taskId + " | " + current.taskName + " | " + current.priority + " | " + current.dueDate);
        current = current.next;
    }

    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks");
            return;
        }
        TaskNode temp = head;
        do {
            System.out.println(temp.taskId + " | " + temp.taskName + " | " + temp.priority + " | " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority.equals(priority)) {
                System.out.println(temp.taskId + " | " + temp.taskName + " | " + temp.priority + " | " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found)
            System.out.println("No task with this priority");
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskSchedulerList scheduler = new TaskSchedulerList();
        scheduler.insertAtBeginning(1, "Complete Assignment", "High", "10-June");
        scheduler.insertAtEnd(2, "Study DSA", "Medium", "12-June");
        scheduler.insertAtEnd(3, "Project Work", "High", "15-June");
        scheduler.insertAtPosition(2, 4, "Read Book", "Low", "20-June");
        System.out.println("All Tasks:");
        scheduler.displayTasks();
        System.out.println("\nSearch High Priority:");
        scheduler.searchByPriority("High");
        System.out.println("\nView Tasks Sequentially:");
        scheduler.viewNextTask();
        scheduler.viewNextTask();
        scheduler.viewNextTask();
        System.out.println("\nDelete Task 2:");
        scheduler.deleteTask(2);
        System.out.println("\nAfter Deletion:");
        scheduler.displayTasks();
    }
}
