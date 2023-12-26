import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("herding");
        int n = 3;
        int step_back = 0;
        int step_forward = 0;
        int arr[] = new int[n];
        int arr2[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            int num = s.nextInt();
            arr[i] = num;
            arr2[i] = num;
        }
        Arrays.sort(arr);
        if (arr[2] - arr[1] == 2 || arr[1] - arr[0] == 2)
            s.println(1);
        else if (arr[0] + 1 == arr[1] && arr[1] + 1 == arr[2])
            s.println(0);
        else
            s.println(2);
        if (arr[0] != arr[1] - 1 || arr[1] != arr[2] - 1)
        {
            while (true)
            {
                if (arr[2] > arr[1])
                {
                    arr[2] = arr[1] - 1;
                    step_back++;
                    if (arr[2] - 1 == arr[0] || arr[2] == arr[0])
                        break;
                }
                else {
                    step_back++;
                    arr[1] = arr[2] - 1;
                    if (arr[1] - 1 == arr[0])
                        break;
                }
            }
            while (true)
            {
                if (arr2[0] < arr2[1])
                {
                    arr2[0] = arr2[1] + 1;
                    step_forward++;
                    if (arr2[0] + 1 == arr2[2] || arr2[0]  == arr2[2])
                        break;
                }
                else {
                    arr2[1] = arr2[0] + 1;
                    step_forward++;
                    if (arr2[1] + 1 == arr2[2])
                        break;
                }
            }
        }
        s.println(Math.max(step_forward,step_back));
        s.close();
    }
    public static long gcd(long a, long b){
       while (b != 0)
       {
           long a2 = a;
           a = b;
           b = a2 % b;
       }
       return  a;
    }
    static class Pair <city,state>{
        public String city;
        public String state;
        public Pair(String city, String state) {
            this.city = city;
            this.state = state;

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
