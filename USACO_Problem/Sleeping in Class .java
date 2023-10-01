import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int arr[] = new int[n];
            long sum =0;
            for (int i = 0; i < n; i++)
            {
                arr[i] = s.nextInt();
                sum += arr[i];
            }

            for (int num = 0; num <= sum; num++)
            {
                if (num != 0 && sum % num !=0)
                {
                    continue;
                }

                int current_sum = 0;
                boolean found = true;

                for (int h : arr) // For check if sum of number not exceed num_hour.
                {
                    current_sum += h;
                    if (current_sum > num)
                    {
                        found = false;
                        break;
                    }
                    else if (current_sum == num)
                    {
                        current_sum = 0;
                    }
                }
                if (found)
                {
                    if (num == 0)
                        s.println(0);
                    else
                        s.println(n - (sum / num));

                    break;
                }
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
//        public Kattio() throws IOException {
//            super("/home/m7md-a4raf/IdeaProjects/Main/src/output.txt");
//            r = new BufferedReader(new FileReader("/home/m7md-a4raf/IdeaProjects/Main/src/input.txt"));
//        }

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


