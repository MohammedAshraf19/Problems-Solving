import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        char ch[] = new char[26];
        int count = 0;
        for (char i = 'a'; i <= 'z'; i++)
        {
            ch[count] = i;
            count++;
        }
        int t = s.nextInt();
        while (t-- > 0)
        {
            int n = s.nextInt();
            int k = s.nextInt();
            StringBuilder re = new StringBuilder("");
            n--;
            for (int i = 0; i < k; i++)
            {
                re.append(ch[i]);
            }
            while (n-- > 0)
            {
                for (int i = 0; i < k; i++)
                {
                    re.append(ch[i]);
                }
            }
            s.println(re);
        }
        s.close();
    }
    public static class ValueComparator implements Comparator<Character> {
        Map<Character, Integer> base;

        public ValueComparator(Map<Character, Integer> base) {
            this.base = base;
        }
        public int compare(Character a, Character b) {
            if (base.get(a) >= base.get(b)) {
                return 1;
            } else {
                return -1;
            } // returning 0 would merge keys
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
