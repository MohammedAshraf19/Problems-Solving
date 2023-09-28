import java.util.Scanner;

public class Problem{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long n2 = s.nextLong();
        long re = 1;
        long re2 = 1;
        if(n > n2){
            for(long i =2;i<=n2;i++){
            re2 = i * re2;
        }
            System.out.println(re2);
        
        }
        // n < n2
        else
        {
        for(int i =2;i<=n;i++){
            re = i * re;
        }
            System.out.println(re);
        }     
    }

}
