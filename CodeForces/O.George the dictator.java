import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = s.nextInt();
        int k = s.nextInt();
        int arr[] = new int [n];
        for (int i = 0; i < n; i ++){
            arr[i] = s.nextInt();
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0) + 1);
        }
        long re = 0;
        for (int i = 0; i < n; i ++){
            if (k - arr[i] == arr[i]) {
                re += ((long) (hashMap.get(arr[i]) - 1) * (hashMap.get(arr[i])) / 2);
                hashMap.replace((arr[i]), 0);
            }
            else if (hashMap.containsKey(k - arr[i])){
                re += (long) hashMap.get(k - arr[i]) * hashMap.get(arr[i]);
                hashMap.replace(arr[i], 0);
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



