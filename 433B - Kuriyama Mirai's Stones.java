import java.util.Arrays;
import java.util.Scanner;

public class Solve{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long arr[] = new long [n];
        long arr_sort[] = new long [n];
        
        for (int i = 0; i < n; i++)
        {
            arr[i] = s.nextLong();
            arr_sort[i] = arr[i];
        }
        Arrays.sort(arr_sort);
        
        for (int i = 1; i < n; i++)
        {
            arr[i] += arr[i - 1];
            arr_sort[i] += arr_sort[i-1];
        }
        int q = s.nextInt();
        while(q-- != 0)
        {
            int m = s.nextInt();
            int l = s.nextInt();
            int r = s.nextInt();
            r--;
            l--;
            if(m == 1)
            {
                if (l == 0)
                    System.out.println(arr[r]);
                else
                    System.out.println(Math.abs(arr[r] - arr[l-1]));
            }
            else
            {
                if (l == 0)
                    System.out.println(arr_sort[r]);
                else
                    System.out.println(Math.abs(arr_sort[r] - arr_sort[l-1]));
            }
        }        
    }
}