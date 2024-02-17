
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("planting");
        int n = s.nextInt();
        int degree[] = new int[n + 1];
        for (int i =1; i < n; i++)
        {
            degree[s.nextInt()]++;
            degree[s.nextInt()]++;
        }
        int max = 0;
        for (int i =0; i < n; i++)
        {
            max = Integer.max(max,degree[i]);
        }
        s.println(max + 1);
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

