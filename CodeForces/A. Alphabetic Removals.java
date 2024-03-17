import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int arr[] = new int [26];
        int n = s.nextInt();
        int k = s.nextInt();
        String st = s.next();

        s.println(solve(n,k,st,arr));
        s.close();
    }

    public  static  StringBuilder solve(int n, int k, String st,int arr[]){
        StringBuilder re = new StringBuilder();
        for (int i = 0; i < n; i ++)
        {
            arr[st.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++)
        {
            if (arr[i] != 0 && k != 0)
            {
                if (k >= arr[i])
                {
                    k -= arr[i];
                    arr[i] = 0;
                }
                else{
                    arr[i] -= k;
                    k = 0;
                }
            }

        }
        for (int i = n - 1 ; i >= 0; i--)
        {
            if (arr[st.charAt(i) - 'a'] != 0){
                re.insert(0, st.charAt(i));
                arr[st.charAt(i) - 'a']--;
            }
        }
        return  re;
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



