import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            int n = s.nextInt();
            Integer arr[] = new Integer[n];
            int sum[] = new int[n + 1];
            sum[0] = 0;
            boolean isEqual = true;
            for (int i = 0 ; i < n ; i ++)
            {
                arr[i] = s.nextInt();
                sum[i + 1] = arr[i] + sum[i];

                if (i > 0 && !Objects.equals(arr[i], arr[i - 1]))
                {
                    isEqual = false;
                }
            }
            if (isEqual || n == 1)
            {
                s.println("NO");
            }
            else
            {
                boolean revers = false;
                for (int i = 0 ; i < n; i++)
                {
                    if (arr[i] == sum[i])
                    {
                        revers = true;
                        break;
                    }
                }
                if (revers)
                {
                    Arrays.sort(arr,Collections.reverseOrder());
                    int swap = arr[1];
                     arr[1] = arr[arr.length-1];
                    arr[arr.length-1] = swap;
                    s.println("YES");
                    for (int i = 0 ; i < n ; i++)
                    {
                        s.print(arr[i] +" ");
                    }
                    s.println();
                }
                else
                {
                    s.println("YES");
                    for (int i = 0 ; i < n ; i++)
                    {
                        s.print(arr[i] +" ");
                    }
                    s.println();
                }
            }
            s.flush();
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


