import java.util.Scanner;
public class Problem{
        public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n  =s.nextInt();
        if(((Math.pow(2, Integer.bitCount(n))-1)*(Math.pow(2, Integer.bitCount(n)-1))) == n)
        {
            System.out.println(n);
        }
        else{
        for(int i =n/2;i>= 1;i--){
            if(n%i ==0 && ((Math.pow(, Integer.bitCount(i))-1)*(Math.pow(2, Integer.bitCount(i)-1))) == i){
                System.out.println(i);
                break;
            }
        }
        }
    }
}
