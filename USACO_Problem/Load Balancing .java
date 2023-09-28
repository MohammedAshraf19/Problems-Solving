import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // Problem is Search for that is Cow1 is Out before Cow2 or not.
        Kattio s = new Kattio("balancing");
        int n = s.nextInt();
        int b = s.nextInt();
        int x[] = new int[n];
        int y[] = new int[n];
        int min = Integer.MAX_VALUE;
        Set<Integer> x_Axis = new HashSet<>();
        Set<Integer> y_Axis = new HashSet<>();
        for (int i = 0 ; i < n; i++)
        {
             x[i] = s.nextInt();
             y[i] = s.nextInt();
             x_Axis.add(x[i] + 1);
             y_Axis.add(y[i] + 1);
        }

        for(int i : x_Axis)
        {
            for (int k : y_Axis)
            {
                int rightUP= 0;
                int rightDown= 0;
                int leftUP= 0;
                int leftDown= 0;
                for (int position = 0 ; position < n; position++)
                {
                    if (x[position] <= b && y[position] <= b){
                        if (x[position] > i && y[position] > k)
                            rightUP++;
                        else if (x[position] < i && y[position] > k) {
                            leftUP++;
                        }

                        else if (x[position] > i && y[position] < k) {
                            rightDown++;
                        }
                        else if (x[position] < i && y[position] < k) {
                            leftDown++;
                        }
                    }
                }
                int test_max = Integer.max(rightUP,rightDown);
                test_max = Integer.max(test_max,leftUP);
                test_max = Integer.max(test_max,leftDown);

                min = Integer.min(test_max,min);

            }
        }
        s.println(min);
        s.close();
    }


    static class Kattio extends PrintWriter {

        private final BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }
//        public Kattio() throws IOException {
//            super("/home/m7md-a4raf/IdeaProjects/Main/src/output.txt");
//            r = new BufferedReader(new FileReader("/home/m7md-a4raf/IdeaProjects/Main/src/input.txt"));
//        }

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


