import java.io.*;
import java.util.*;

public class 숨바꼭질1697 {
    static int N, K, cnt;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 0;
        visited = new int[100001];

        bfs();

        System.out.println(visited[K]-1);
    }

    public static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(N);
        visited[N] = 1;
        int n;

        while(!q.isEmpty()) {
            int x = q.pollFirst();

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    n = x - 1;
                } else if (i == 1) {
                    n = x + 1;
                } else {
                    n = x * 2;
                }
                
                if (n >= 0 && n <= 100000 && 0 == visited[n]) {
                    q.offerLast(n);
                    visited[n] = visited[x] + 1;

                    if (x == K) {
                        return;
                    }
                }
            }
        }
    }
}
