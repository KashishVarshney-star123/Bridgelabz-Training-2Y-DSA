class Process {
    int pid, burstTime, remainingTime;
    int completionTime, waitingTime, turnAroundTime;
    Process next;

    public Process(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int count = 0;
    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        count++;
    }

    public void removeProcess(int pid) {
        if (head == null) return;
        Process curr = head, prev = tail;
        do {
            if (curr.pid == pid) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                }
                count--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void simulate(int quantum) {
        if (head == null) return;
        int currentTime = 0;
        int completed = 0;
        int totalProcesses = count;
        Process curr = head;
        System.out.println("--- Execution Starts ---");
        while (completed < totalProcesses) {
            if (curr.remainingTime > 0) {
                int executeTime = Math.min(curr.remainingTime, quantum);
                curr.remainingTime -= executeTime;
                currentTime += executeTime;
                System.out.println("Time " + currentTime + ": Process " + curr.pid + " executed for " + executeTime + "ms");
                if (curr.remainingTime == 0) {
                    curr.completionTime = currentTime;
                    curr.turnAroundTime = curr.completionTime;
                    curr.waitingTime = curr.turnAroundTime - curr.burstTime;
                    completed++;
                }
            }
            curr = curr.next;
        }
        displayMetrics(totalProcesses);
    }

    private void displayMetrics(int n) {
        double totalWT = 0, totalTAT = 0;
        Process temp = head;
        System.out.println("\nPID\tBurst\tWaiting\tTurnaround");
        do {
            totalWT += temp.waitingTime;
            totalTAT += temp.turnAroundTime;
            System.out.println(temp.pid + "\t" + temp.burstTime + "\t" + temp.waitingTime + "\t" + temp.turnAroundTime);
            temp = temp.next;
        } while (temp != head);
        System.out.println("\nAverage Waiting Time: " + (totalWT / n));
        System.out.println("Average Turnaround Time: " + (totalTAT / n));
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        int timeQuantum = 2;
        scheduler.simulate(timeQuantum);
    }
}