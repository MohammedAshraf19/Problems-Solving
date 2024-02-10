import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
           int lowercase[] = new int[26];
           int uppercase[] = new int [26];
           int n = s.nextInt();
           int k = s.nextInt();
           String st = s.next();
           for (int i = 0; i < st.length(); i++)
           {
               if (st.charAt(i) >= 'a' && st.charAt(i) <= 'z')
                   lowercase[st.charAt(i) - 'a']++;
               else
                   uppercase[st.charAt(i) - 'A']++;
           }

           int count = 0;
           for (int i = 0; i < 26; i++)
           {
               if (lowercase[i] >= uppercase[i])
               {
                   if (uppercase[i] > 0)
                   {
                       count += uppercase[i];
                       lowercase[i] -= uppercase[i];
                       uppercase[i] = 0;
                       if (lowercase[i] > 0)
                       {
                           int num_operation = lowercase[i] / 2;
                           if (k >= num_operation)
                           {
                               k -= num_operation;
                               count += num_operation;
                           }
                           else {
                               count += k;
                               k = 0;
                           }
                       }
                   }
                   else {
                       int num_operation = lowercase[i] / 2;
                       if (k >= num_operation)
                       {
                           k -= num_operation;
                           count += num_operation;
                       }
                       else {
                           count += k;
                           k = 0;
                       }
                   }
               }
               else if (uppercase[i] >= lowercase[i])
               {
                   if (lowercase[i] > 0)
                   {
                       count += lowercase[i];
                       uppercase[i] -= lowercase[i];
                       lowercase[i] = 0;
                       if (uppercase[i] > 0)
                       {
                           int num_operation = uppercase[i] / 2;
                           if (k >= num_operation)
                           {
                               count += num_operation;
                               k -= num_operation;
                           }
                           else
                           {
                               count += k;
                               k = 0;
                           }
                       }
                   }
                   else {
                       int num_operation = uppercase[i] / 2;
                       if (k >= num_operation)
                       {
                           count += num_operation;
                           k -= num_operation;
                       }
                       else
                       {
                           count += k;
                           k = 0;
                       }
                   }
               }
           }

           s.println(count);
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

