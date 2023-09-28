import java.util.ArrayList;
import java.util.Scanner;

public class Problem{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0 && count < k) {
                n = n / i;
                count++;
                arr.add(i);
            }
        }
        if (n != 1) {
            arr.add(n);
        }
        if (arr.size() != k) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if(i == arr.size()-1)
                    System.out.print(arr.get(i));
                else
                    System.out.print(arr.get(i)+" ");
            }
            System.out.println("");
        }

    }

}
