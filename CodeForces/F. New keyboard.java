import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Scanner ss = new Scanner(System.in);
        while (ss.hasNext()){
            StringBuilder st = new StringBuilder(ss.next());
            StringBuilder re = new StringBuilder();
            int indicator = 0;
            int count = 0;
            for (int i = 0; i < st.length() ;i++)
            {
                if (st.charAt(i) == '[') {
                    indicator = 1;
                    count = 0;
                }
                else if(st.charAt(i) == ']') {
                    indicator = 0;
                    count = 0;
                }
                else {
                    if (indicator == 0) {
                        re.append(st.charAt(i));
                    }
                    else{
                        re.insert(count, st.charAt(i));
                        count++;
                    }
                }
            }
            System.out.println(re);
        }
    }
}

