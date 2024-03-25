import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int n = s.nextInt();
        int arr[] = new int[100001];
        int max = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int num = s.nextInt();
            arr[num]++;
            max = Math.max(max,arr[num]);
            if (arr[num] == 1)
                arrayList.add(num);
        }
        Collections.sort(arrayList);
        while (max-- > 0)
        {
            for (int i : arrayList){
                if(arr[i] != 0)
                {
                    arr[i]--;
                    s.print(i +" ");
                }
            }
            s.println();
        }
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



