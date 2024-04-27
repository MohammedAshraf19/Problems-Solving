import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Kattio s = new Kattio();
        int n = s.nextInt();
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> all = new ArrayList<>();
        int[] teach = new int[n];
        int zero = 0;
        for (int i = 0; i < n; i++){
            teach[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++){
            int num = s.nextInt();
            if (teach[i] - num < 0){
                all.add((teach[i] - num) * -1);
            }
            else if (teach[i] - num > 0){
                positive.add(teach[i] - num);
                all.add(teach[i] - num);
            }
            else
                zero++;
        }
        long  re = 0;
        re += (long) positive.size() * zero;
        Collections.sort(all);
        Collections.sort(positive);
        for (int i =  0; i < all.size(); i++){
            int l = 0;
            int h = positive.size();
            while (l < h){
                int mid = (l + (h - l) / 2);
                if (Objects.equals(positive.get(mid), all.get(i))){
                    re += i;
                    positive.remove(mid);
                    break;
                } else if (all.get(i) > positive.get(mid)){
                    l = mid;
                }
                else
                    h = mid;
            }
        }
        s.println(re);
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
            } catch (Exception ignored) {
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



