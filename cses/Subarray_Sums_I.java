import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        Kattio s = new Kattio();
        int n = s.nextInt();
        int x = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i <n; i++){
            arr[i] = s.nextInt();
        }
        int start = 0, end = 0;
        int result = 0;
        long sum = 0;
        while (end < n){
            sum += arr[end];
            while (sum > x){
                sum -= arr[start];
                start++;
            }
            if (sum == x)
                result++;
            end++;
        }
        s.println(result);
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
