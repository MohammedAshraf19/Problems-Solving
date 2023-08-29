import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter log = new PrintWriter("cowsignal.out");
        StringTokenizer st = new StringTokenizer(s.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String arr[] = new String[m];
        for (int i =0 ; i < m; i++)
        {
            st = new StringTokenizer(s.readLine());
            arr[i] = st.nextToken();
        }

        for (int i =0 ; i < m; i++)
        {
            String test = "";
            for (int j = 0; j < arr[i].length(); j++)
            {
                for (int e = 0; e < k; e++)
                {
                    test += arr[i].charAt(j);
                }
            }
            for (int e = 0; e < k; e++)
            {
                log.write(test + "\n");
                log.flush();
            }
        }
        log.close();
    }

}