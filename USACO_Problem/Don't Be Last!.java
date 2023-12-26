import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("notlast");
        int n = s.nextInt();
        TreeMap<String, Integer> cows = new TreeMap<>();
        cows.put("Bessie",0); cows.put("Elsie",0); cows.put("Daisy",0);
        cows.put("Gertie",0); cows.put("Annabelle",0); cows.put("Maggie",0);
        cows.put("Henrietta",0);
        for (int i = 0; i < n; i++)
        {
            String cow = s.next();
            int milk = s.nextInt();
            cows.replace(cow,cows.get(cow) + milk);
        }

        int arr[] = new int[cows.size()];
        int tmp = 0;
        for (int i : cows.values())
        {
            arr[tmp] = i;
            tmp++;
        }
        Arrays.sort(arr);
        int min = arr[0];
        boolean notEqual = false;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != min && min == arr[0])
            {
                min = arr[i];
                if (i == arr.length - 1)
                    notEqual = true;
            }
            else if (min != arr[i])
            {
                notEqual = true;
                break;
            }
        }
        if (!notEqual)
        {
            s.println("Tie");
        }
        else
        {
            for (String c : cows.keySet())
            {
                if (cows.get(c) == min)
                {
                    s.println(c);
                    break;
                }
            }
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
