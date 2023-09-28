
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("gymnastics");
        int k = s.nextInt(),  n = s.nextInt();
        int arr[][] = new int[k][n];
        int re[][] = new int [n + 1][n + 1];
        for (int i = 0 ; i < k ; i++)
        {
            for (int j = 0; j < n ; j++)
            {
                arr[i][j] = s.nextInt();
            }
        }


        for (int i = 0 ; i < k ; i++)
        {

            for (int j = 0; j < n ; j++)
            {
                for (int  m = j + 1; m < n ; m++)
                {
                    re[arr[i][j]][arr[i][m]]++;

                }
            }
        }
        int count = 0;
        for (int i = 0 ; i < n ; i++)
        {
            for (int j = 0; j < n ; j++)
            {
                if (re[i][k] == k)
                    count++;
            }
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
