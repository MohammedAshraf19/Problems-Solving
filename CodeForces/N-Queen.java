import java.util.Scanner;

public class Solution{

    public static Scanner s = new Scanner(System.in);
    public static  int n = s.nextInt();
    public static  char arr[][] = new char[n][n];
    public static void main(String[] args) {

        
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                arr[i][k] = '.';
            }
        }
        queen(0, n);
    }

    public static void queen(int colm ,int n) {
        if (colm == n) {
            for (int i = 0; i < arr.length; i++) {
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[i][k]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(i, colm, n)) {
                    arr[i][colm] = 'Q';
                    queen(colm + 1, n);
                    arr[i][colm] = '.';
                }
        }
    }

    public static boolean isSafe(int row, int column, int n) {
        
        
        
        // Check Left
        for (int i = 0; i < column; i++) {
            if (arr[row][i] == 'Q') {
                return false;
            }
        }      
        // Check Upeer Diagonal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check Down Diagonal
        for (int i = row, j = column; i < n && j >= 0; i++, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}