import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException
    {
        Kattio s = new Kattio();
        int k = s.nextInt();
        int n = s.nextInt();

        int points_jury[] = new int[k + 1];
        int values[] = new int[n];
        HashSet<Integer> scores = new HashSet<>();
        for (int i = 1; i <= k; i++)
        {
            points_jury[i] = s.nextInt() + points_jury[i - 1];
        }
        for (int i = 0; i < n; i++)
        {
            values[i] = s.nextInt();
        }
        for (int i = 1; i <= k; i++)
        {
            scores.add(values[0] - points_jury[i]);
        }

        int start = 0;
        for (int score : scores)
        {
            HashSet<Integer> score_test = new HashSet<>();
            for (int i = 1; i <= k; i++)
            {
                score_test.add(score + points_jury[i]);
            }
            boolean valid = true;
            for (int t : values)
            {
                valid &= score_test.contains(t);
            }
            start += valid ? 1 : 0;
        }
        s.println(start);
        s.close();
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


/*
Kattio s = new Kattio();
        int numJury = s.nextInt();
        int numScores = s.nextInt();
        int[] changes = new int[numJury + 1];
        int[] scores = new int[numScores];
        for (int x = 1; x <= numJury; x++) {
            changes[x] = s.nextInt() + changes[x - 1];
        }
        for (int x = 0; x < numScores; x++) { scores[x] = s.nextInt(); }
        Set<Integer> possStarts = new TreeSet<>();
        for (int x = 1; x <= numJury; x++) {
            possStarts.add(scores[0] - changes[x]);
        }
        int validStarts = 0;
        for (int sc : possStarts) {
            Set<Integer> points = new TreeSet<>();
            for (int i = 1; i <= numJury; i++) { points.add(sc + changes[i]); }
            boolean valid = true;
            for (int p : scores) { valid &= points.contains(p); }
            validStarts += valid ? 1 : 0;
        }
        s.println(validStarts);
        s.close();

 */
