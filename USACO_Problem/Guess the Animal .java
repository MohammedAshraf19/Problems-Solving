import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("guess");
        int n = s.nextInt();
        HashSet<String>[] animals = new HashSet[n];
        for (int i = 0 ; i < n ; i++)
        {
            String animal = s.next();
            int character = s.nextInt();

            animals[i] = new HashSet<>();
            for (int k = 0 ; k < character ; k++)
            {
                String st = s.next();
                animals[i].add(st);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < n ; i++)
        {
            for (int k = i + 1 ; k < n ; k++)
            {
                HashSet<String> hashSet = new HashSet<>(animals[i]);
                hashSet.retainAll(animals[k]);

                max = Integer.max(max, hashSet.size());
            }
        }
        s.println(max + 1);
        s.flush();
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
