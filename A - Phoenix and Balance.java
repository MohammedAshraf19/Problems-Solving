import java.io.*;
import java.util.*;
// import java.util.Scanner;

public class Solution{
    
   
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            int n = s.nextInt();
            long spilt1 = (long)Math.pow(2, n);
            long spilt2 = 0;
            
            for (int i = 1; i < n / 2; i++)
            {
                spilt1 += Math.pow(2, i);
            }
            for (int i = n - 1; i >= n / 2; i--)
            {
                spilt2 += Math.pow(2, i);
            }
            s.print(Math.abs(spilt1 - spilt2) +"\n");
            s.flush();
        }
        s.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}

   