import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // Problem is Search for that is Cow1 is Out before Cow2 or not.
        Kattio s = new Kattio("circlecross");
        String st = s.next();
        int count = 0;
        for (int i = 0; i < st.length(); i++)
        {
            for (int k = i + 1; k < st.length() ; k++)
            {
                for (int j = k + 1; j < st.length() ; j++)
                {
                    for (int m = j+1; m < st.length() ; m++)
                    {
                        if (st.charAt(i) == st.charAt(j) && st.charAt(k) == st.charAt(m))
                            count++;
                    }
                }
            }
        }
        s.println(count);
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


