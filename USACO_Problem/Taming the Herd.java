import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("taming");
        int n = s.nextInt();
        int arr[] = new int[n];
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++)
        {
            arr[i] = s.nextInt();
        }
        for (int i = n - 1; i >= 0; i--)
        {
            if (arr[i] != -1 && arr[i] != 0)
            {
                if (arr[i - arr[i]] == -1)
                    arr[i - arr[i]] = 0;
            }
        }
        arr[0] = 0;
        boolean correct = true;
        for (int i = n - 1; i >= 0; i--)
        {
            if (arr[i] != -1 && arr[i] != 0)
            {
                if (arr[i - arr[i]] != 0)
                {
                    correct = false;
                    break;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--)
        {
            if (arr[i] == 0)
            {
                min++;
                max++;
            }
            if (arr[n-1] == -1) {
                arr[n - 1] = 0;
                max++;
            }
            if (i != n - 1 && arr[i] == -1 && arr[i + 1] == 0)
            {
                arr[i] = 0;
                max++;
            }

        }
        if (correct)
            s.println(min + " " + max);
        else
            s.println(-1);
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
