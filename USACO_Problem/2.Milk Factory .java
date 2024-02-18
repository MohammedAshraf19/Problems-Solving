import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int n ;
    public  static  boolean visited [];
    public  static  ArrayList<Integer> stations[];
    public static  HashMap<Integer,Integer> station_visited  = new HashMap<>();
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("factory");
        n = s.nextInt();
        stations = new ArrayList[n];
        visited = new boolean[n];
        for (int i =0; i < n; i++)
        {
            stations[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++)
        {
            int station1 = s.nextInt();
            int station2 = s.nextInt();
            stations[station1 - 1].add(station2 - 1);
        }
        for (int i = 0; i < n; i++)
        {
            dfs(i);
            visited = new boolean[n];
        }
        boolean find = false;
        for (Map.Entry<Integer,Integer> a:station_visited.entrySet())
        {
            if (a.getValue() == n - 1)
            {
                s.println(a.getKey() + 1);
                find = true;
                break;
            }
        }
        if(!find)
            s.println(-1);
        s.close();
    }

    public  static  void dfs(int start)
    {
        if (visited[start])
            return;
        visited[start] = true;
        for (int a : stations[start])
        {
            station_visited.put( a, station_visited.getOrDefault(a,0) + 1);
            dfs(a);
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

