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

public class JavaApplication1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        long n = s.nextInt();        // Size of Number

        long t = s.nextInt();        // number is divide

        long test = n, num = t;

        while (n-- > 0)         // check is size is small than number is divide
        {
            t /= 10;
        }

        if (t > 0) {
            System.out.print(-1);
        } 
        else
	{
            // check if number is large than 10 or not
            if (num >= 10) {
                long f = num;
                int count = 1;
                while (num >= 10) {
                    num /= 10;
                    count++;
                }
                while (test-- > count) {
                    System.out.print(num);
                }
                System.out.print(f);
            }
            else
            {
                while (test-- > 0) {
                    System.out.print(num);
                }
            }
        }
        System.out.println();

    }
}