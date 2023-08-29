import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("shuffle");
        int n = s.nextInt();
        int shuffle [] = new int [n + 1]; // step that I will calculate
        int move [] = new int [n + 1]; // Calculate teh end of all cows
        for (int i = 1; i <= n; i++)
        {
            shuffle[i] = s.nextInt();
            move[i] = shuffle[i];
        }
        for (int k = 1; k < 3; k++) {
            int test [] = new int [n + 1];
            for (int i = 1; i <= n; i++) {
                test[i] = shuffle[move[i]];
            }
            move = test;
        }

        int order[] = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            order[i] = s.nextInt();
        }

        for (int i = 1; i <= n; i++)
        {
            s.print(order[move[i]] +"\n");
            s.flush();
        }

        s.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
