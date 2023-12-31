import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("sleepy");

        int n = s.nextInt();

        int[] cows = new int[n];

        for (int i = 0; i < n; i++)
        {
            cows[i] = s.nextInt();
        }
        int result = n - 1;

        for (int i = n - 2; i >= 0; i--) {

            if (cows[i] < cows[i + 1]) {
                result = i;
            } else {
                break;
            }
        }
        s.println(result);

        s.close();
    }
    static class Pair <city,state>{
        public String city;
        public String state;
        public Pair(String city, String state) {
            this.city = city;
            this.state = state;

        }
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
