import java.util.Scanner;

public class Solve {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int q = s.nextInt();
        int arr[] = new int[2000000];
        for (int i = 0; i < n; i++) {
            int l = s.nextInt();
            int r = s.nextInt();

            arr[l] += 1;
            arr[r + 1] -= 1;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
                
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= k)
                arr[i] = 1;
            else
                arr[i] = 0;
        }
        
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }

        for (int i = 1; i <= q; i++) {
            int l = s.nextInt();
            int r = s.nextInt();
            System.out.println(arr[r] - arr[l-1]);
        }
    }
}