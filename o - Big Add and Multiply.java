import java.math.BigInteger;
import java.util.Scanner;

public class Problem{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);        
        String st = s.next();
        
        BigInteger bigInteger = new BigInteger(st);
        BigInteger bigInteger2 = new BigInteger("9999");
        System.out.println(bigInteger.add(bigInteger2));
        System.out.println(bigInteger.multiply(bigInteger2));
        
    }

}