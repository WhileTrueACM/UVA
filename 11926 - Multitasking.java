import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (true){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;

            int start [] = new int[1000001];
            int end   [] = new int[1000001];
            for (int i = 0 ; i < n ; ++i){
                ++ start[sc.nextInt()];
                ++ end  [sc.nextInt()];
            }

            for (int i = 0 ; i < m ; ++i){
                int s = sc.nextInt();
                int e = sc.nextInt();
                int p = sc.nextInt();
                for (int j = s ; j <= 1000000 ; j += p)
                    ++ start[j];
                for (int j = e ; j <= 1000000 ; j += p)
                    ++ end[j];
            }

            int numberOfTasks = 0 ;
            boolean conflict = false;
            for (int i = 0 ; i <= 1000000  ; ++i){
                numberOfTasks += (start[i] - end[i]);
                if (numberOfTasks > 1)  {
                    conflict = true;
                    break;
                }
            }

            if (conflict) out.print("CONFLICT\n");
            else out.print("NO CONFLICT\n");
        }
        out.flush();
        out.close();
    }















    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


    }
}
