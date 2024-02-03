import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int n = s.nextInt();
        int even = 0, ood = 0;
        for (int i = 0; i < n ; i++)
        {
            if (s.nextInt() % 2 == 0)
                even++;
            else
                ood++;
        }
        int count = 0;
        boolean queue = true;
        while (true)
        {
            if (queue)
            {
                if (even != 0)
                {
                    even--;
                    count++;
                }
                else if (ood - 2 >= 0)
                {
                    ood = ood - 2;
                    count++;
                }
                else
                    break;
                queue = false;
            }
            else
            {
                if (ood != 0)
                {
                    ood--;
                    count++;
                }
                else
                    break;
                queue = true;
            }
        }
        s.println(count - ood);
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
