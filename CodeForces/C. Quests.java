import java.io.*;
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
            long result = 0;
            int a[] = new int[n];
            int b [] = new int[n];
            for (int i = 0; i < n ; i++)
            {
                a[i] = s.nextInt();
            }
            for (int i = 0; i < n ; i++)
            {
                b[i] = s.nextInt();
            }
            long tmp = 0;
            long sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < Integer.min(n,k); i++)
            {
                max = Integer.max(max,b[i]);
                sum += a[i];
                tmp = sum + (long) max * (k - i - 1);
                result = Long.max(tmp,result);
            }
            s.println(result);
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



