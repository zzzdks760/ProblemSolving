import java.io.*;
import java.math.BigInteger;

public class 피보나치수410826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[10001];

        arr[0] = BigInteger.valueOf(0);
        arr[1] = BigInteger.valueOf(1);

        if (N == 0) {
            System.out.println(0);
            System.exit(0);
        }
        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i-2].add(arr[i-1]);
        }

        System.out.println(arr[N]);
    }
}
