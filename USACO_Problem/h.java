import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static class Air
    {
        int a;
        int b;
        int reduce;
        int cost;
        Air(int start, int end, int reduce, int cost){
            this.a = start;
            this.b = end;
            this.reduce = reduce;
            this.cost = cost;
        }
    }
    public static int stalls[] = new int [101];
    static int  min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int n = s.nextInt();
        int m = s.nextInt();

        for (int i = 0 ; i < n ; i ++)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            for (int g = a; g <= b; g++)
            {
                stalls[g] = c;
            }
        }
        ArrayList<Air> airs = new ArrayList<>();
        for (int i = 0 ; i < m ; i++)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            int reduce = s.nextInt();
            int cost = s.nextInt();
            Air air = new Air(a, b,reduce,cost);
            airs.add(air);
        }

        solve(airs,m);
        s.println(min);
        s.close();
    }
    public static void solve(ArrayList<Air> airs, int m)
    {
        for (int i = 0; i < (1 << m); i++)
        {
            int arr[] = new int[101];
            int cost = 0;
            for (int k = 0 ; k < m ; k++)
            {
                if ((i & (1 << k)) != 0)
                {
                    for (int j = airs.get(k).a; j <= airs.get(k).b; j++)
                    {
                        arr[j] += airs.get(k).reduce;
                    }
                    cost += airs.get(k).cost;
                }
            }
            boolean valid = true;

            for (int k = 0 ; k < stalls.length; k++)
            {
                if (arr[k] < stalls[k])
                {
                    valid = false;
                    break;
                }
            }
            if (valid)
            {
                min = Integer.min(min,cost);
            }
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
