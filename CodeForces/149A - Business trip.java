import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int k = s.nextInt();
        int n =12;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = s.nextInt();
        }
        if (k == 0)
            s.println(0);
        else {
            Arrays.sort(arr);
            int sum = 0;
            int count = 0;
            for(int i = n - 1; i >= 0; i--)
            {
                sum += arr[i];
                count++;
                if (sum >= k)
                    break;
            }
            if (sum >= k)
                s.println(count);
            else 
                s.println(-1);
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
