import java.util.Scanner;
public class FriendStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age and height for " + names[i] + ": ");
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }
        int minAgeIdx = 0;
        int maxHeightIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[minAgeIdx]) minAgeIdx = i;
            if (heights[i] > heights[maxHeightIdx]) maxHeightIdx = i;
        }
        System.out.println("Youngest friend: " + names[minAgeIdx] + " (" + ages[minAgeIdx] + " years)");
        System.out.println("Tallest friend: " + names[maxHeightIdx] + " (" + heights[maxHeightIdx] + " cm)");
    }
}