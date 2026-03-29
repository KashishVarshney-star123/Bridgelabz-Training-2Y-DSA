import java.util.Scanner;
public class UniqueCharFrequency {
    public static char[] getUnique(String str) {
        char[] temp = new char[str.length()];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (temp[j] == ch) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp[index++] = ch;
            }
        }
        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }
    public static int[][] getFrequency(String str, char[] unique) {
        int[][] result = new int[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == unique[i]) {
                    count++;
                }
            }
            result[i][0] = unique[i];
            result[i][1] = count;
        }
        return result;
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
        char[] unique = getUnique(str);
        int[][] result = getFrequency(str, unique);
        display(result);
        sc.close();
    }
}