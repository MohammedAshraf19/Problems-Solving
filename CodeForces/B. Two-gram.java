import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int n = s.nextInt();
        String st = s.next();
        int max = 0;
        String re = "";
        for (int i = 0; i < n - 1 ; i++)
        {
            int count = 1;
            String temp = st.charAt(i) +""+ st.charAt(i + 1);
            for (int k = i + 1; k < n - 1; k++)
            {
                if (temp.equals((st.charAt(k) +""+ st.charAt(k + 1))))
                {
                    count++;
                }
            }
            if (count > max)
            {
                re = temp;
                max = count;
            }
        }
        s.println(re);
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
