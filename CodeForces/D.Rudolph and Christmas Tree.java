import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            int n = s.nextInt();
            int d = s.nextInt();
            int h = s.nextInt();
            int height[] = new int[n];
            double area = 0;
            for (int i = 0; i < n; i++)
            {
                height[i] = s.nextInt();
                area +=  (0.5 * h * d);
            }
            for (int i = 0; i < n; i++)
            {
                for (int k = i + 1; k < n && k < i + 2 ; k++)
                {
                    if (k != i && height[i] <= height[k] && height[i] + h > height[k] && height[i] + h <= height[k] + h)
                    {
                        double base = (double) (height[i] + h - height[k]) / h * d;
                        area -=  (0.5 * (height[i] + h - height[k]) * base);
                        break;
                    }
                    else if (k != i && height[i] == height[k])
                    {
                        area -=  (0.5 * h * d);
                        break;
                    }
                }
            }
            s.println(area);
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
