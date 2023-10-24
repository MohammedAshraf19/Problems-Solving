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
           int k = s.nextInt();
           int arr[] = new int[n];
           int even = 0;
           int divis4 = 0;
           for (int i = 0; i < n; i++)
           {
               arr[i] = s.nextInt();
               if (arr[i] % 2 == 0)
                   even++;
               if (arr[i] % 4 == 0)
                   divis4 = 1;
           }
           int min4 = 0;
           if (k == 4 && divis4 == 1)
           {
               s.println(0);
           }
           else
           {
               if (k == 4  && n != 1)
                   min4 = Integer.max(0,2 - even);
               int re = Integer.MAX_VALUE;
               for (int i = 0; i < n; i++)
               {
                   int count = 0;
                   while (arr[i] %k !=0)
                   {
                       arr[i]++;
                       count++;
                   }
                   re = Integer.min(re,count);
               }
               if (k == 4  && n != 1)
                   s.println(Integer.min(re,min4));
               else
                   s.println(re);
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
