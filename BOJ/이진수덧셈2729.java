import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class 이진수덧셈2729 {
    static StringTokenizer st;
    static int T, cnt, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            
            BigInteger x = new BigInteger(a, 2);
            BigInteger y = new BigInteger(b, 2);

            BigInteger answer = x.add(y);
            System.out.println(answer.toString(2));
        }
    }
}
