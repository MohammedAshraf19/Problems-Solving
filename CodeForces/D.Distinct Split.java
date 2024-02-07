import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            int n = s.nextInt();
            String st = s.next();
            int all[] = new int[26];
            int a[] = new int[26];

            for (int i = 0; i < n; i++)
            {
                all[st.charAt(i) - 'a']++;
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++)
            {
                int a_size = 0;
                int b_size = 0;
                a[st.charAt(i) - 'a']++;
                all[st.charAt(i) - 'a']--;
                for (int k = 0; k < 26; k++)
                {
                    if (a[k] >= 1)
                        a_size++;
                    if (all[k] >= 1)
                        b_size++;
                }
                max = Integer.max(max,a_size + b_size);
            }
            s.println(max);
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
