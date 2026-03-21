import java.util.Scanner;
public class ArrayIndexDemo {
    public static void triggerError(String[] names) {
        System.out.println("Attempting to access index " + names.length + "...");
        System.out.println(names[names.length]); 
    }
    public static void handleIndexError(String[] names) {
        try {
            System.out.println("Safe access attempt...");
            System.out.println(names[10]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: That index is not valid for this array.");
        } catch (RuntimeException e) {
            System.out.println("Caught a generic Runtime error.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many names? ");
        int n = sc.nextInt();
        String[] names = new String[n];
        
        for(int i=0; i<n; i++) {
            System.out.print("Enter name " + (i+1) + ": ");
            names[i] = sc.next();
        }
        handleIndexError(names);
    }
}