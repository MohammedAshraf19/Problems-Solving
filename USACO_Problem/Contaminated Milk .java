import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("badmilk");
        int n = s.nextInt();
        int m = s.nextInt();
        int d = s.nextInt();
        int st = s.nextInt(); // Sick
        Vector<Vector<Integer>> milks = new Vector<>();
        Vector<Vector<Integer>> sick = new Vector<>();

        // Read People Data
        for (int i = 0; i < d; i++)
        {
            Vector<Integer> test = new Vector<>();
            for (int k = 0; k < 3; k++)
            {
                int num = s.nextInt();
                test.add(num);
            }
            milks.add(new Vector<>(test));
        }

        // Read sick data
        for (int i = 0; i < st; i++)
        {
            Vector<Integer> test = new Vector<>();
            for (int k = 0; k < 2; k++)
            {
                int num = s.nextInt();
                test.add(num);
            }
            sick.add(new Vector<>(test));
        }

        int result = getResult(sick, milks);
        s.println(result);

        s.close();
    }

    private static int getResult(Vector<Vector<Integer>> sick, Vector<Vector<Integer>> milks)
    {
        // Search for most common milk in sick people
        HashSet<Integer> re = new HashSet<>();
        for (int i = 0; i < sick.size() ; i++)
        {
            HashSet<Integer> test = new HashSet<>();
            for (int k = 0; k < milks.size(); k++)
            {
                if (i == 0)
                {
                    if (Objects.equals(sick.get(i).get(0), milks.get(k).get(0)) && sick.get(i).get(1) > milks.get(k).get(2))
                    {
                        re.add(milks.get(k).get(1));
                    }
                }
                else
                {
                    if (Objects.equals(sick.get(i).get(0), milks.get(k).get(0)) && sick.get(i).get(1) > milks.get(k).get(2))
                    {
                        test.add(milks.get(k).get(1));
                    }
                }
            }
            if (i != 0)
                re.retainAll(test);
        }

        // Search for people who drink bad milk
        int  result = 0;
        Iterator<Integer> it = re.iterator();
        while (it.hasNext()) {
            HashSet<Integer> repeat = new HashSet<>();
            int test = it.next(), count = 0;
            for (int k = 0; k < milks.size(); k++) {
                if (test == milks.get(k).get(1) && !repeat.contains(milks.get(k).get(0))) {
                    count++;
                    repeat.add(milks.get(k).get(0));
                }
            }
            result = Integer.max(result,count);
        }
        return result;
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

        // file input
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


