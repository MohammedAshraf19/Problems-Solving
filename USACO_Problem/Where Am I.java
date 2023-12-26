import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("whereami");
        int n = s.nextInt();
        String st = s.next();
        for (int step = 1; step <= n; step++)
        {
            HashSet<String> hashSet = new HashSet<>();
            boolean found = false;
            for (int i = 0; i < n; i++)
            {
                String test = "";
                for (int k = i; k < i + step && k < n; k++)
                {
                    test += st.charAt(k);
                }

                if (hashSet.contains(test))
                {
                    found = true;
                    break;
                }
                else {
                    hashSet.add(test);
                }
            }
            if (!found)
            {
                s.println(step);
                break;
            }
        }
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
