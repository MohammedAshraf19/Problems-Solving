import java.io.*;
import java.util.*;

public class Main {

     public static TreeSet<Character> single = new TreeSet<>();
    public static TreeSet<String> team = new TreeSet<>();
    
    public static void  check (char ch1, char ch2, char ch3)
    {
        TreeSet<Character> test = new TreeSet<>();
        
        test.add(ch1);
        test.add(ch2);
        test.add(ch3);
        if (test.size() == 1)
            single.add(test.first());
        else if (test.size() == 2)
            team.add(test.first() +""+test.last());
    }
    
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio("tttt");
        int n = 3;
        String arr[] = new String[n];
        
        for (int i = 0; i < n; i++)
        {
            arr[i] = s.next();
        }
        
        // row
        for (int i = 0; i < n ; i++)
        {
            check(arr[i].charAt(0), arr[i].charAt(1), arr[i].charAt(2));
        }
        
        // Column
        for (int i = 0; i < n ; i++)
        {
            check(arr[0].charAt(i), arr[1].charAt(i), arr[2].charAt(i));
        }
        check(arr[0].charAt(0), arr[1].charAt(1), arr[2].charAt(2));
        check(arr[0].charAt(2), arr[1].charAt(1), arr[2].charAt(0));
        
        
        s.print(single.size() +"\n" + team.size() +"\n");
        s.flush();
        s.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
