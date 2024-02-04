import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("outofplace");
        int n = s.nextInt();
        int count = 0;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = s.nextInt();
        }
        for (int i = 0 ; i < n; i++)
        {
            int tmp = arr[i];
            int swap = 0;
            for (int k = i + 1; k <n ; k++)
            {
                if (swap != 0 && arr[swap] >= arr[k])
                {
                    swap = k;
                }
                else if (swap == 0 &&  arr[k] < arr[i])
                    swap = k;
            }
            if (swap != 0) {
                arr[i] = arr[swap];
                arr[swap] = tmp;
                count++;
            }
        }

        s.println(count);
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
