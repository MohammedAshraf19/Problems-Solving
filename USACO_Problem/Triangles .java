import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("triangles");
        int n = s.nextInt();
        long [] x = new long[n];
        long [] y = new long[n];

        for (int i = 0; i < n ; i++)
        {
            x[i] = s.nextInt() + 10000;
            y[i] = s.nextLong() + 10000;
        }
        double area = 0;
        for (int i = 0 ; i < n; i++)
        {
            for (int k =  0; k  < n ; k++)
            {
                for (int j = 0; j < n; j ++)
                {
                    if (y[i] == y[k] && (x[i] == x[j]))
                    {
                        area = Double.max(area, ( (x[k] - x[i])  * (y[j]  - y[i])));
                    }
                }
            }
        }
        s.println((long) area);
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
