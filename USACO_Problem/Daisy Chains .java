
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio();
        int n = s.nextInt();
        double arr[] = new double[n];
        for (int i = 0 ; i < n ; i++)
        {
            arr[i] = s.nextDouble();
        }
        int count = 0;
        for (int i = 0 ; i < n ; i++)
        {
            for (int j = i ; j < n; j++)
            {
                HashSet<Double> h = new HashSet<>();
                double average = 0;

                for (int index = i ; index <= j ; index++)
                {
                    average += arr[index];
                    h.add(arr[index]);
                }
                average = average / (j - i + 1);
                if (h.contains(average))
                    count++;
            }
        }

        s.println(count);
        s.flush();
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
