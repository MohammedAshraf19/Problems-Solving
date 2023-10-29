import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio();
        int t = s.nextInt();
        while (t-- > 0)
        {
            int n = s.nextInt();
            int k = s.nextInt();
            HashSet<Integer> hashSet = new HashSet<>();
            int[] arr = new int[n];
            for (int i = 0 ; i < n; i++)
            {
                arr[i] = s.nextInt();
            }

            int count = 1;
            for (int i = 0 ; i < n ; i++)
            {
                if (arr[i] == count)
                {
                    count++;
                }
                else
                {
                    hashSet.add(arr[i]);
                }
            }
            s.println(doubleEqualInt(hashSet.size(),k));
        }
        s.close();
    }
    public  static  long doubleEqualInt(long a, long b)
    {
        if (a / b == (double)a / (double) b)
        {
            return  a/ b;
        }
        else {
            return  a / b + 1;
        }
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


