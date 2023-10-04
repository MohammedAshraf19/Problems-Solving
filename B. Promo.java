    import java.io.*;
    import java.util.*;
    public class Main {
        public static void main(String[] args) throws IOException
        {
            Kattio s = new Kattio();
            int n = s.nextInt();
            int q = s.nextInt();
            int arr[] = new int[n];
            long prefix[] = new long[n];
            for (int i = 0 ; i < n; i++)
            {
                arr[i] = s.nextInt();
            }
            Arrays.sort(arr);
            prefix[0] = arr[0];
            for (int i = 1 ; i < n; i++)
            {
                prefix[i] = prefix[i - 1] + arr[i];
            }
            while (q-- > 0)
            {
                int x = n - s.nextInt();
                int y = s.nextInt();
                int max = Integer.min(n - 1, x + y - 1);
                int min = Integer.max(0,x - 1);
                if (x - 1 >= 0)
                    s.println(prefix[max] - prefix[min] );
                else
                    s.println(prefix[max]);
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
