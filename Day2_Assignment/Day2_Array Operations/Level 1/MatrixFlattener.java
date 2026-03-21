import java.util.Scanner;

public class MatrixFlattener {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements for the " + rows + "x" + cols + " matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] flattenedArray = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {       
            for (int j = 0; j < cols; j++) {   
                flattenedArray[index] = matrix[i][j];
                index++;
            }
        }
        System.out.print("The 1D flattened array is: ");
        for (int val : flattenedArray) {
            System.out.print(val + " ");
        }
    }
}