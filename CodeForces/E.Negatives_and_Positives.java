import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0){
            int n = s.nextInt();
            int arr[] = new int[n];
            long sum = 0;
            int min = Integer.MAX_VALUE;
            int negative = 0;
            for (int i = 0; i < n; i++){
                arr[i] = s.nextInt();
                sum+=Math.abs(arr[i]);
                min = Integer.min(min,Math.abs(arr[i]));
                if (arr[i] < 0)
                    negative++;
            }
            if (negative % 2 == 0)
                s.println(sum);
            else
                s.println(sum - min - min);
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
            } catch (Exception ignored) {
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
