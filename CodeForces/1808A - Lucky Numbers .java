import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            int max = 0, min = 0, num = 0;
            int l = s.nextInt();
            int r = s.nextInt();
            for (int i = l; i <= r; i++) {
                int test_max = Integer.MIN_VALUE;
                int test_min = Integer.MAX_VALUE;
                String tmp = String.valueOf(i);
                for (int k = 0; k < tmp.length();k++)
                {
                    test_max = Integer.max(test_max, (tmp.charAt(k) - '0'));
                    test_min = Integer.min(test_min, (tmp.charAt(k) - '0'));
                }
                if (test_max - test_min == 9)
                {
                    num = i;
                    break;
                }
                if (test_max - test_min >= max - min) {
                    max = test_max;
                    min = test_min;
                    num = i;
                }
            }
            s.println(num);
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
