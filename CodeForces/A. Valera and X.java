/**
 * ******************************************************************************
 **** ______________ __________ _______________ _ **** *** | |___|_|___|_|
 * |__________| | | ___| |___|_| | | **** *** | | | | | | |_| | | | | | | | |
 * **** *** | | | | | | |_| | | | | | | _______| | **** *** | | | | | | |_| | |
 * | | | | | | | | **** *** | | | | | | |_| | | | | | | |_|_____|_| **** *** |_|
 * ****
 * *******************************************************************************
 */
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        String st[] = new String[n];
        for (int i = 0; i < n; i++) {
            st[i] = s.next();
        }
        char diagonal = st[0].charAt(0), normal = st[0].charAt(1);
        
        boolean not = false;
        
        for (int r = 0; r < n; r++) {
            if (st[r].charAt(r) != diagonal) {
                not = true;
                break;
            }
            if (st[r].charAt(st.length - r - 1) != diagonal) {
                not = true;
                break;
            }
        }

        if (not) {
            System.out.println("NO");
        }
        else
        {
            // to check all element expect diagonal
            int left = 0, right = n - 1;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (c == left || c == right) {
                        continue;
                    }
                    if (st[r].charAt(c) != normal || normal == diagonal) {
                        not = true;
                        break;
                    }
                }
                left++;
                right--;
                if (not) {
                    System.out.println("NO");
                    break;
                }
            }
        }

        if (!not) {
            System.out.println("YES");
        }
    }
}