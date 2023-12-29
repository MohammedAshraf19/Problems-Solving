import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            long n = s.nextLong();
            if (n % 2 == 1 )
            {
                s.println(-1);
            }
            else
            {
                if (n % 6 == 0)
                {
                    min = n / 6;
                }
                else {
                    min = n / 6;
                    if ((n % 6) / 4 != 0)
                    {
                        min += (n % 6) / 4;
                    }
                    else
                        min++;
                    if (n / 4 == 0)
                        min = Long.min(min, n / 4);
                }
                max = Long.max(n / 4,n / 6);
                if (min == 0)
                    s.println(-1);
                else
                    s.println(min + " " + max);
            }
        }
       s.close();
    }
    static class Pair <city,state>{
        public String city;
        public String state;
        public Pair(String city, String state) {
            this.city = city;
            this.state = state;

        }
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
