import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("cowtip");
        int n = s.nextInt();
        int arr[][] = new int[n][n];
        for (int i = 0; i < n ; i ++)
        {
            String st = s.next();
            for (int k = 0; k < n; k++)
            {
                arr[i][k] = st.charAt(k) - '0';
            }
        }
        int count = 0;
        for (int i = n - 1 ; i >= 0; i--)
        {
            for (int k = n - 1; k >= 0; k--)
            {
                if (arr[i][k] == 1)
                {
                    for (int r = 0; r <= i; r++)
                    {
                        for (int c = 0; c <= k; c++)
                        {
                            if (arr[r][c] == 1)
                                arr[r][c] = 0;
                            else
                                arr[r][c] = 1;
                        }
                    }
                    count++;
                }
            }
        }

        s.println(count);
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
