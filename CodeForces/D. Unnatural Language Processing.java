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
            String st = s.next();
            for (int i = 0 ; i < st.length(); i++)
            {
                char ch = st.charAt(i);
                if (ch != 'a' && ch != 'e')
                {
                    s.print(ch);
                }
                else
                {
                    if (i + 2 < st.length())
                    {
                        if (st.charAt(i + 2) == 'a' || st.charAt(i + 2) == 'e')
                        {
                            s.print(ch);
                            s.print(".");
                        }
                        else {
                            s.print(ch);
                            s.print(st.charAt(i + 1));
                            s.print(".");
                            i++;
                        }
                    }
                    else if (i + 1 < st.length())
                    {
                        s.print(ch);
                        s.print(st.charAt(i + 1));
                        break;
                    }
                    else
                    {
                        s.print(ch);
                    }
                }
            }
            s.println();
        }

        s.close();
    }
    static class Pair <city,state>{
        public String city;
        public String state;
        public Pair(String city, String state) {
            this.city = city;
            this.state = state;

        }
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
