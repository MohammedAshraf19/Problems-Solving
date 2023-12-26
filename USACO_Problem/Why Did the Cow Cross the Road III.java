import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("cowqueue");
        int n = s.nextInt();
        Vector<Vector<Integer>> cows = new Vector<>();

        for (int i = 0; i < n; i ++)
        {
            Vector<Integer> v = new Vector<>();
            v.add(s.nextInt());
            v.add(s.nextInt());
            cows.add(v);
        }
        cows.sort((a, b) -> {
            if (a.get(0) > b.get(0))
                return 1;
            else if (a.get(0) < b.get(0))
                return  -1;
            return 0;
        });
        long count = 0;
        for (int i = 0; i < n; i ++)
        {
            if (count < cows.get(i).get(0))
            {
                count = cows.get(i).get(0) + cows.get(i).get(1);
            }
            else
                count += cows.get(i).get(1);
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
