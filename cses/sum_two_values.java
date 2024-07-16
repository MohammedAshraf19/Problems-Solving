import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        Kattio s = new Kattio();
        int n = s.nextInt();
        int x = s.nextInt();
        int arr[] = new int[n];
        int origin[] = new int[n];
        for (int i = 0 ; i < n;i ++){
            int num = s.nextInt();
            arr[i] = num;
            origin[i] = num;
        }
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        boolean found = false;
        while (start != end)
        {
            if(arr[start] + arr[end] == x){
                start = arr[start];
                end = arr[end];
                found = true;
                break;
            }
            else if (arr[start] + arr[end] < x){
                start++;
            }
            else
                end--;
        }
        if (found) {
            int num1 = 0;
            int num2 = 0;
            for (int i = 0 ; i < n;i ++){
                if (start == origin[i] && num1 == 0) {
                    num1 = i + 1;
                }
                else if (end == origin[i] && num2 == 0) {
                    num2 = i + 1;
                }
            }
            if (num1 < num2)
                s.println(num1 +" " + num2);
            else
                s.println(num2 +" " + num1);
        }
        else
            s.println("IMPOSSIBLE");
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




