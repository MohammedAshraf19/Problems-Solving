import java.util.HashSet;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = 0;

        int n = s.nextInt();

        int k = s.nextInt();

        for (int i = 0; i < n; i++)
        {
            boolean contain = true;
            String test = s.next();
            HashSet<Integer> h = new HashSet<>(); // use for search
            for (int t = 0; t < test.length();t++)
            {
                h.add(Integer.valueOf(test.charAt(t)) - 48);
            }
           
            for (int t = 0; t <= k;t++)
            {
                if(!h.contains(t))
                {
                    contain = false;
                    break;
                }
            }
            if(contain)
                count++;
        }
       
        System.out.println(count);
    }
}