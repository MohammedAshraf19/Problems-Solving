import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long arr[] = new long[n];
        boolean allEqual = true;
        long min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (min > arr[i]) {
                min = arr[i];
            }
            if (i != 0) {
                if (arr[i] != arr[i - 1]) {
                    allEqual = false;
                }
            }
        }
        int temp = 0;
        int num_min = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == min) {
                num_min++;
            }
        }

        long arr2[] = new long[num_min];
        for (int i = 0; i < n; i++) {
            if (arr[i] == min) {
                arr2[temp] = i;
                ++temp;

            }
        }
        if (allEqual) {
            System.out.println(arr[0] * n);
        } else if (num_min == 1) {
            System.out.println((n * min) + (n - 1));
        } else {
            long addtional = 0;
            for (int i = 1; i < num_min; i++) {
                addtional = Long.max(addtional, (arr2[i] - arr2[i - 1] - 1));
            }
            addtional = Long.max(addtional, n - (arr2[num_min - 1] - arr2[0] + 1));
            System.out.println(n * min + addtional);
        }
    }
}