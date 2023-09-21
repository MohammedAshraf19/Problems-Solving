import java.io.*;
import java.util.*;
public class Main {
    public static HashSet<Integer> hashSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("backforth");
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0 ; i < 10 ; i ++)
        {
            int num = s.nextInt();
            a.add(num);
        }
        for (int i = 0 ; i < 10 ; i ++)
        {
            int num = s.nextInt();
            b.add(num);
        }
        Solve(0,1000,a,1000,b);
        s.println(hashSet.size());
        s.close();
    }

    public static void Solve(int day, int aTank, List<Integer> a,int bTAnk, List<Integer> b)
    {
        if (day == 4)
        {
            hashSet.add(aTank);
            return;
        }

        for (int i = 0 ; i < a.size(); i++)
        {
            int num = a.get(i);
            List<Integer> newA = new ArrayList<>(a);
            List<Integer> newB = new ArrayList<>(b);
            newA.remove(i);
            newB.add(num);
            Solve(day + 1,bTAnk + num, newB, aTank - num, newA);
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

