import java.util.Scanner;

public class Solve {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int arr[] = new int [n];
        int sum[] = new int [n];
        int index = 0;
        int temp = 0;
        int re = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            arr[i] = s.nextInt();
            temp += arr[i];
            sum[i] = temp;
        }
        
        for (int i = 0; i< n; i++)
        {
            if (i + k -1 >= arr.length)
                break;
            else
            {
                if (i ==0)
                {
                    temp = sum[i+k-1]; 
                }
                else
                {
                    temp = sum[i+k-1] - sum[i-1]; 
                }
            }
            
            if (re > temp)
            {
                re = temp;
                index = i;
            }
        }
        System.out.println(index+1);
    }
}