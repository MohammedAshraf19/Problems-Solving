import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            int r = s.nextInt();
            int c = s.nextInt();

            int arr[][] = new int[r][c];
            for (int i = 0; i < r; i++)
            {
                for (int k = 0; k < c; k++)
                {
                    arr[i][k] = s.nextInt();
                }
            }

            long max = 0;
            for (int i = 0 ; i < c; i++)
            {
                long sum = 0 ;
                int test[] = new int[r];
                for (int k = 0; k < r; k++)
                {
                    test[k] = arr[k][i];
                    sum += arr[k][i];
                }
                long current = 0;
                Arrays.sort(test);
                for (int k = 0; k < r; k++)
                {
                    current += test[k];
                    max += Math.abs((sum - current) - (long) (r - 1 - k) * test[k]);
                }

            }
            s.println(max);
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
