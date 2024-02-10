import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
           int n = s.nextInt();
           int k = s.nextInt();
           int arr[] = new int[n];
           for (int i = 0; i < n; i ++)
           {
               arr[i] = s.nextInt();
           }
           Arrays.sort(arr);
           while (k-- > 0)
           {
               int num = s.nextInt();
               for (int i = 0; i < n ; i++)
               {
                   if (arr[i] <= num) {
                       arr[i] = num;
                       break;
                   }
                   if (i == n - 1)
                       arr[0] = num;
               }
               Arrays.sort(arr);
           }
            BigInteger bigInteger = new BigInteger("0");
           for (int i = 0; i < n; i ++)
           {
               bigInteger = bigInteger.add(BigInteger.valueOf(arr[i]));
           }
           s.println(bigInteger);
        }
        s.close();
    }
    static class Kattio extends PrintWriter {

        private final BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}

