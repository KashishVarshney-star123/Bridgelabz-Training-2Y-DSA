import java.util.Scanner;
public class NestedFrequency {
    public static int[][] getFrequency(String str) {
        int n = str.length();
        int[] visited = new int[n];
        int[][] result = new int[n][2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                    visited[j] = 1;
                }
            }
            result[index][0] = str.charAt(i);
            result[index][1] = count;
            index++;
        }
        int[][] finalResult = new int[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }
    public static void display(int[][] result) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < result.length; i++) {
            System.out.println((char)result[i][0] + "\t\t" + result[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int[][] result = getFrequency(str);
        display(result);
        sc.close();
    }
}