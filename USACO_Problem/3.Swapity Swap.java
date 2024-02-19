
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("swap");
        int n = s.nextInt();
        int k = s.nextInt();
        int a1 = s.nextInt();
        int a2 = s.nextInt();
        int b1 = s.nextInt();
        int b2 = s.nextInt();
        int origin[] = new int[n+1];
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            origin[i] = i;
            arr[i] = i;
        }
        int j = 0;
        boolean equal = false;
        for (int i = 0; i < k; i++)
        {
            int left = a1;
            int right = a2;
            while (left < right)
            {
                int swap = arr[left];
                arr[left] = arr[right];
                arr[right] = swap;
                left++;
                right--;
            }
            left = b1;
            right = b2;
            while (left < right)
            {
                int swap = arr[left];
                arr[left] = arr[right];
                arr[right] = swap;
                left ++;
                right--;
            }
            if (Arrays.equals(arr,origin)){
                j++;
                equal = true;
                break;
            }
            j++;
        }
        if (equal)
        {
            k = k % j;
            for (int i = 0; i < k; i++)
            {
                int left = a1;
                int right = a2;
                while (left < right)
                {
                    int swap = arr[left];
                    arr[left] = arr[right];
                    arr[right] = swap;
                    left ++;
                    right--;
                }
                left = b1;
                right = b2;
                while (left < right)
                {
                    int swap = arr[left];
                    arr[left] = arr[right];
                    arr[right] = swap;
                    left ++;
                    right--;
                }
            }
            for (int i = 1; i <= n; i++)
                s.println(arr[i]);
        }
        else
            for (int i = 1; i <= n; i++)
                s.println(arr[i]);
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

