import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio();
        int t = s.nextInt();

        while (t-- > 0)
        {
            boolean isSorted = true;
            int n = s.nextInt();
            long arr[] = new long [n];
            long def = Long.MAX_VALUE;
            int point = 0;
            for (int i = 0; i < n ; i++)
            {
                arr[i] = s.nextLong();
                if (i !=0 && arr[i-1] > arr[i])
                    isSorted = false;
                if (i != 0 && def > arr[i] - arr[i - 1])
                {
                    def = arr[i] - arr[i - 1];
                }
            }
            if (!isSorted)
            {
                s.println(0);
                s.flush();
            }
            else
            {
                double count = def  + 1;

                if (count / 2 == (long) count / 2)
                {
                    s.println((long) count / 2);
                }
                else
                    s.println((long) count / 2 + 1);
                s.flush();
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
