import java.io.*;
import java.util.*;

public class 숨바꼭질413913 {
    static int[] arr;
    static int[] parent;
    static int N, K, answer, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        parent = new int[100001];
        cnt = 1;

        bfs(N);
        System.out.println(answer-1);
        recu(K);
    }

    public static void recu (int k) { // 17
        if (k != N) { // 17 != 5
            recu(parent[k]);
        }
        System.out.print(k + " ");
    }

    public static void bfs(int v) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(v);
        arr[v] = cnt;

        while(!q.isEmpty()) {
            int x = q.pollFirst();

            if (x == K) {
                answer = arr[x];
                return;
            }

            int nx;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nx = x * 2;
                } else if (i == 1) {
                    nx = x - 1;
                } else {
                    nx = x + 1;
                }

                if (nx < 0 || nx > 100000) continue;
                if (arr[nx] == 0) {
                    arr[nx] = arr[x] + 1;
                    q.offerLast(nx);
                    parent[nx] = x;
                }
            }
        }
    }

}
