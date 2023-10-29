import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int n = s.nextInt();
        int[] people = new int[n * 2];
        for (int i = 0; i < n * 2; i++)
        {
            people[i] = s.nextInt();
        }
        Arrays.sort(people);

        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < people.length ; i ++)
        {
            for (int k = i + 1; k < people.length ;k++)
            {
                Vector<Integer> test = new Vector<>();
                for (int j = 0 ; j < people.length; j++)
                {
                    if (j != i && j != k)
                    {
                        test.add(people[j]);
                    }
                }
                int test_min = 0;
                for (int p = 1; p < test.size(); p+= 2)
                {
                    test_min += test.get(p) - test.get(p-1);
                }
                min = Integer.min(min,test_min);
            }
        }
        s.println(min);
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
