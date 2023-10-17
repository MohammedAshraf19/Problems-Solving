import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int start = equal(n,2);
            for (int i = 2; i <= start; i++)
            {
                if ( (n / (int)(Math.pow(2,i) - 1)) == n / (Math.pow(2,i) - 1))
                {
                    s.println((int)(n / (Math.pow(2,i) - 1)));
                    break;
                }
            }
        }
       s.close();
    }

    public static int equal(int a, int b)
    {
        if (a / b == (double)a / (double) b)
            return  a / b;
        else
            return a / b + 1;
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
