import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int n = s.nextInt();
        int m = s.nextInt();
        int height[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            height[i] = s.nextInt();
        }
        long frontDamage[] = new long[n];
        long backDamage[] = new long[n];
        long test = 0;
        for (int i = 1; i < n; i ++)
        {
            if (height[i] < height[i - 1])
            {
                test += height[i - 1] - height[i];
                frontDamage[i] = test;
            }
            else
                frontDamage[i] = test;
        }
        test = 0;
        for (int i = n - 1; i > 0; i--)
        {
            if (height[i] > height[i - 1])
            {
                test += height[i] - height[i - 1];
                backDamage[n - i] = test;
            }
            else
                backDamage[n - i] = test;
        }
        while (m-- > 0)
        {
            int l = s.nextInt();
            int e = s.nextInt();

            if (l < e)
            {
                s.println(Math.abs(frontDamage[l - 1] - frontDamage[e - 1]));
            }
            else {
                 l = n - l;
                 e = n - e;
                 s.println(Math.abs(backDamage[l ] - backDamage[e ]));
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
