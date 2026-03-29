import java.util.Scanner;
public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            ages[i] = sc.nextInt();
        }
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age");
            } else if (ages[i] >= 18) {
                System.out.println("Student " + (i + 1) + ": Can vote");
            } else {
                System.out.println("Student " + (i + 1) + ": Cannot vote");
            }
        }
        sc.close();
    }
}