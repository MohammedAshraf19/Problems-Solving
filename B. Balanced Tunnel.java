import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        int arr2[] = new int[n];

        Set<Integer> h = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = s.nextInt();
        }

        int i = 0, j = 0;
        while (i < n && j < n) {
            if (h.contains(arr[i]) || h.contains(arr2[j])) {
                i++;
            } else if (arr[i] != arr2[j]) {
                h.add(arr2[j]);
                j++;
            } else {
                i++;
                j++;
            }
        }
        System.out.println(h.size());
    }

}