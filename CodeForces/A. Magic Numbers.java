import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        String num = s.next();
        boolean out = false;
        for (int i = 0 ; i < num.length(); i++)
        {
            if (num.charAt(i) != '1' && num.charAt(i) != '4')
                out = true;
        }
        if (out)
        {
            s.println("NO");
        }
        else
        {
            int one = 0;
            int four = 0;
            for (int i = 0 ; i < num.length(); i++)
            {
                if (num.charAt(i) == '1')
                {
                    one = 1;
                }
                else
                {
                    if (one == 1)
                    {
                        four = 1;
                        one = 0;
                    }
                    else if (four == 1)
                    {
                        four = 0;
                    }
                    else {
                        out = true;
                        break;
                    }
                }
            }
            if (out)
            {
                s.println("NO");
            }
            else
                s.println("YES");
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
