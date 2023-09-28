import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("lifeguards");
        int n = s.nextInt();
        int start[] = new int[n], end[] = new int[n];

        for (int i = 0 ; i < n ; i++)
        {
            start[i] = s.nextInt();
            end[i] = s.nextInt();
        }

        long count = 0;
        for (int i = 0 ; i < n ; i++)
        {
            int test [] = new int [1001];
            for (int k = 0 ; k < n; k++)
            {
                if (k != i)
                {
                    for (int j = start[k]; j < end[k]; j++)
                    {
                        test[j]++;
                    }
                }
            }
            long temp = 0;
            for (int k = 0 ; k < test.length ; k++)
            {
                if (test[k] >= 1)
                {
                    temp++;
                }
            }
            count = Long.max(count,temp);
        }
        s.println(count);
        s.flush();
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
