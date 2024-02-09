import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            String st = s.next();
            long p = s.nextLong();
            char[] c = st.toCharArray();
            long sum = 0;
            for (int i = 0; i < c.length; i++)
            {
                sum += ((c[i] - 'a') + 1);
            }
            if (sum <= p)
                s.println(st);
            else
            {
                sum = 0;
                Arrays.sort(c);
                int [] ch = new int[27];
                for (int i = 0; i < c.length; i++) {
                    if (sum + (c[i] - 'a') + 1 <= p)
                    {
                        sum += ((c[i] - 'a') + 1);
                        ch[(c[i] - 'a')]++;
                    }
                }
                for (int i = 0; i < st.length(); i++)
                {
                    if (ch[st.charAt(i) - 'a'] != 0)
                    {
                        s.print(st.charAt(i));
                        ch[st.charAt(i) - 'a']--;
                    }
                }
                s.println();
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

