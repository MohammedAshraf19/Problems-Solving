import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("cownomics");
        int n = s.nextInt();
        int m = s.nextInt();
        String [] spoty = new String[n];
        String [] plain = new String[n];

        for (int i = 0; i < n ; i++)
        {
            spoty[i] = s.next();
        }
        for (int i = 0; i < n ; i++)
        {
            plain[i] = s.next();
        }
        int count = 0;
        for (int i = 0; i < m ; i++)
        {
            boolean isAll = true;
            HashSet<Character> hashSet = new HashSet<>();

            for (int k = 0 ; k < n; k++)
            {
                hashSet.add(plain[k].charAt(i));
            }
                for (int k = 0 ; k < n ; k++)
                {
                    if (hashSet.contains(spoty[k].charAt(i)))
                    {
                        isAll = false;
                        break;
                    }
                }
                if (isAll)
                    count++;
        }
        s.println(count);
        s.flush();
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
