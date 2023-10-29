import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio();
        int n = s.nextInt();
        int winner[] = new int[n];
        int loser []= new int[n];
        int difference = 0;
        int difference2 = 0;
        for (int i =0; i< n; i++)
        {
            winner[i] = s.nextInt();
        }

        for (int i =0; i< n; i++)
        {

            loser[i] = s.nextInt();
            if (winner[i] == 1 && loser[i] == 0)
                difference++;
            if (winner[i] == 0 && loser[i] == 1)
                difference2++;
        }

        if (difference == 0)
        {
                s.println(-1);
        }
        else
        {
            if ((double) (difference2 + 1) / (double)difference ==  (difference2 + 1) / difference)
                s.println( (difference2 + 1) / difference);
            else
                s.println(( (difference2 + 1) / difference) + 1) ;
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


