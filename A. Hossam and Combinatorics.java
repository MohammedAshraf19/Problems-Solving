import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio();
        int  t = s.nextInt();
        while (t-- > 0)
        {
            int n = s.nextInt();
            int arr[] = new int[n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0 ; i < n ; i++)
            {
                arr[i] = s.nextInt();
                max = Integer.max(max,arr[i]);
                min = Integer.min(min,arr[i]);

            }
            int countMax = 0;
            int countMin = 0;
            for (int i = 0 ; i < n ; i++)
            {
                if (arr[i] == max)
                    countMax++;
                else if (arr[i] == min)
                    countMin++;

            }
            if (min == max)
                s.println((long) n*( (long) n-(long) 1));
            else
                s.println((long) countMax * (long) countMin *(long) 2);
            s.flush();

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
