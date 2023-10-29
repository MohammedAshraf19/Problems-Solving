import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        long power = s.nextInt();
        int n = s.nextInt();
        Vector<Vector<Long>> dragons = new Vector<>();
        boolean win = true;
        for (int i = 0; i < n ; i++)
        {
            Vector<Long> test = new Vector<>();
            test.add(s.nextLong());
            test.add(s.nextLong());
            dragons.add(test);
        }
        dragons.sort((a, b) -> {
            if (a.get(0) > b.get(0))
                return  1;
            else if (a.get(0) < b.get(0))
                return  -1;
            else
            {
                return b.get(1).compareTo(a.get(1));
            }
        });

        for (Vector v : dragons)
        {
            if ((long)v.get(0) >=  power)
            {
                win = false;
                break;
            }
            else {
                power += (long)v.get(1);
            }
        }
        if (win)
            s.println("YES");
        else
            s.println("NO");
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
