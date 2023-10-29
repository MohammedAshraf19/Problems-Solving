import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static int arr[];
    public  static  void increaeSecond() {
        for (int i = 1; i < arr.length ; i++)
        {
            if (arr[i] % arr[i - 1] == 0)
            {
                arr[i]++;
            }
        }
    }
    public  static  void  increaseFirst(){
        for (int i = 1; i < arr.length ; i++)
        {
            if (arr[i] % arr[i - 1] == 0)
            {
                arr[i-1]++;
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            int n = s.nextInt();
            arr = new int[n];
            for (int i = 0; i < n ; i++)
            {
                arr[i] = s.nextInt();
            }
            increaeSecond();
            increaseFirst();
            increaeSecond();
            for (int i = 0; i < n; i++)
            {
                s.print(arr[i] + " ");
            }
            s.println();
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
