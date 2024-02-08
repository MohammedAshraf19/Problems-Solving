import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            int k = s.nextInt();
            int end = s.nextInt();
            if (end == k)
            {
                for (int i = 1; i <= end; i++)
                {
                    s.print(i +" ");
                }
                s.println();
            }
            else
            {
                int count = 0;
                List<Integer> re = new ArrayList<>();
                for (int i = end; i >= 1; i-= count)
                {
                    if (re.size() >= k)
                        break;
                    re.add(i);
                    count++;
                }
                count = 1;
                while (re.size() < k)
                {
                    if (!re.contains(count))
                    {
                        re.add(count);
                    }
                    count++;
                }
                Collections.sort(re);
                for (int i = 0 ; i < re.size(); i++)
                {
                    s.print(re.get(i) +" ");
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

