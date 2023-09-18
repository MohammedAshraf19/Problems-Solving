import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException
    {
	Kattio s = new Kattio("square");
        int width = 0, height = 0;
        int x1 = s.nextInt();
        int y1 = s.nextInt();
        int x2 = s.nextInt();
        int y2 = s.nextInt();

        int x3 = s.nextInt();
        int y3 = s.nextInt();
        int x4 = s.nextInt();
        int y4 = s.nextInt();

        width = Integer.max((x2 - x3), (x4 - x1));
        width = Integer.max(x2 - x1,width);
        width = Integer.max(x4 - x3,width);
        
        height = Integer.max((y4 - y1), (y2 - y3));
        height = Integer.max(y2 - y1, height);
        height = Integer.max(y4 - y3, height);

        int len = Integer.max(height, width);
        s.print(len * len + "\n");
        s.flush();
        s.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
