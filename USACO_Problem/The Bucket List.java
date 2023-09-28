import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("blist");
        int n = s.nextInt();
        int re[] = new int[1001];

        for (int i = 1; i <= n; i++)
        {
            int s1 = s.nextInt();
            int t1 = s.nextInt();
            int b = s.nextInt();

            re[s1] = b;
            re[t1] = -1 * b;
        }
        int max = 0;
        for (int  i = 1; i < re.length ;i++)
        {
            re[i] += re[i - 1];
            max = Integer.max(max, re[i]);
        }
        s.print(max+ "\n");
        s.flush();
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
