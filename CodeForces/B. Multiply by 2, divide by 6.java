import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            long n = s.nextInt();
            int count = 0;
            int timOut = 0;
            if (n == 1)
                s.println(0);
            else {
                while (true)
                {
                    if (n == 1 || timOut == 100)
                        break;

                    if (n / 6 == (double) n / 6)
                    {
                        n = n / 6;
                        count++;
                    }
                    else
                    {
                        n *= 2;
                        count++;
                        timOut ++;
                    }
                }

                if (n != 1)
                    s.println(-1);
                else
                    s.println(count);
            }
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
