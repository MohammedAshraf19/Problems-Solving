
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("gymnastics");
        int k = s.nextInt();
        int n = s.nextInt();

        int pairs = 0;
        int arr[][] = new int[n][k];
        for (int i = 0; i < k; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[s.nextInt() - 1][i] = j + 1;
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                boolean isbig = true;
                boolean issmall = true;
                for (int r = 0; r < k; r++)
                {
                    if (arr[i][r] > arr[j][r])
                    {
                        isbig = false;
                    } else if (arr[i][r] < arr[j][r])
                    {
                        issmall = false;
                    }
                }
                if (isbig || issmall)
                    pairs++;
            }
        }

        s.println(pairs);
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

