
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("revegetate");
        int n = s.nextInt();
        int m = s.nextInt();
        ArrayList<Integer> pastures[] = new ArrayList[n + 1];
        HashSet<Integer> cows[] = new HashSet[m + 1];
        String re  = "";
        for (int i = 0; i <= n; i ++)
        {
            pastures[i] = new ArrayList<>();
        }
        for (int i = 0; i <= m; i ++)
        {
            cows[i] = new HashSet<>();
        }
        for (int i = 1; i <= m; i ++)
        {
            int field1 = s.nextInt();
            int field2 = s.nextInt();

            pastures[field1].add(i);
            pastures[field2].add(i);
        }
        for (int i = 1; i <= n; i ++)
        {
            int count = 1;
            while (count <= 4)
            {
                boolean find = true;
                for (int cow : pastures[i])
                {
                    if (cows[cow].contains(count))
                    {
                        find = false;
                        break;
                    }
                }
                if (find)
                {
                    re = re + count;
                    for (int cow : pastures[i])
                    {
                        cows[cow].add(count);
                    }
                    break;
                }
                count++;
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

