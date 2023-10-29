import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            BigInteger sum = new BigInteger(String.valueOf(BigInteger.ZERO));
            int n = s.nextInt();
            int q = s.nextInt();
            int arr[] = new int[n + 1];
            long arrSum[] = new long[n + 1];
            for (int i = 1; i <= n ; i++)
            {
                arr[i] = s.nextInt();
                if (i == 1)
                    arrSum[i] = arr[i];
                else
                    arrSum[i] = arr[i] + arrSum[i -1];
                sum = sum.add(BigInteger.valueOf(arr[i]));
            }
            while (q-- > 0)
            {
                BigInteger test = new BigInteger(String.valueOf(sum));
                int start = s.nextInt();
                int end = s.nextInt();
                int num = s.nextInt();
                if (start - 1 <= 0)
                {
                    test = test.subtract(BigInteger.valueOf(arrSum[end]));
                    test = test.add(BigInteger.valueOf((long) num * (end - start + 1)));

                }
                else
                {
                    test = test.subtract(BigInteger.valueOf(arrSum[end] - arrSum[start - 1]));
                    test = test.add(BigInteger.valueOf((long) num * (end - start + 1)));
                }
                if (test.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE))
                {
                    s.println("YES");
                }
                else
                    s.println("NO");
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
