import java.util.Scanner;

public class Solution{
    
    public static boolean visit[] = new boolean[5];
    public static boolean found = false;
    
    public static Scanner s = new Scanner(System.in);
        
    public static int arr[] = new int [5];
    public static void main(String[] args) {;
           while (true)
           {          
               int sum = 0;
               for (int i = 0; i < 5; i++)
               {
                   arr[i] = s.nextInt();
                   sum+= arr[i];
               }
               if (sum == 0)
                   break;
               
               solve(0, 0, true);
               if (found)
                   System.out.println("Possible");
               else
                   System.out.println("Impossible");
           }
        }
    
    public static  void solve(int len, int value, boolean isFisrt)
    {
        if (found)
        {
            return;
        }
        if (len == 5)
        {
            if(value == 23)
                found = true;
            return;
        }
        for (int i = 0; i < 5; i++)
        {
           if(visit[i])
           {
               continue;
           }
           visit[i] = true;
           if (!isFisrt)
           {
               solve(len + 1, value + arr[i] , false);
               solve(len + 1, value - arr[i], false);
               solve(len + 1, value * arr[i], false);
           }
           else
           {
               solve(len + 1, arr[i], false);
           }
           
           visit[i] = false;
        }
    }
}