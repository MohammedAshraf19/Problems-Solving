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
        int a = s.nextInt();
        
        if (a == 0) {
            System.out.println(1);
        }
        else 
        {
            switch (a % 4) {
                case 0:
                    System.out.println(6);
                    break;
                case 1:
                    System.out.println(8);
                    break;
                case 2:
                    System.out.println(4);
                    break;
                default:
                    System.out.println(2);
                    break;
            }
        }
    }

}