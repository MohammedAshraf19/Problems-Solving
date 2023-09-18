import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Kattio s = new Kattio();
        int x1 = s.nextInt() * 2;
        int y1 = s.nextInt() * 2;
        int x2 = s.nextInt() * 2;
        int y2 = s.nextInt() * 2;

        int x3 = s.nextInt() * 2;
        int y3 = s.nextInt()* 2;
        int x4 = s.nextInt()* 2;
        int y4 = s.nextInt()* 2;

        int x5 = s.nextInt()* 2;
        int y5 = s.nextInt()* 2;
        int x6 = s.nextInt()* 2;
        int y6 = s.nextInt()* 2;

        boolean istrue = false;

        for (int x = x1; x <= x2; x++) {
            if (check(x, y1, x3, y3, x4, y4) || check(x, y1, x5, y5, x6, y6)) {
            }
            else
            {

                s.print("YES\n");
                s.flush();
                return;
            }
            if (check(x, y2, x3, y3, x4, y4) || check(x, y2, x5, y5, x6, y6)) {

            }
            else {

                s.print("YES\n");
                s.flush();
                return;
            }
        }

        for (int y = y1; y <= y2; y++) {
            if (check(x1, y, x3, y3, x4, y4) || check(x1, y, x5, y5, x6, y6)) {
            }
            else
            {
                s.print("YES\n");
                s.flush();
                return;
            }
            if (check(x2, y, x3, y3, x4, y4) || check(x2, y, x5, y5, x6, y6)) {
            }
            else
            {
                s.print("YES\n");
                s.flush();
                return;
            }
        }

        s.print("NO\n");
        s.flush();

        s.close();

    }

    public static boolean check(int x, int y, int x1, int y1, int x2, int y2) {
        return (x >= x1 && x2 >= x && y >= y1 && y2 >= y);
    }

    static class Kattio extends PrintWriter {

        private BufferedReader r;
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
