import java.io.*;
import java.util.*;

public class 숨바꼭질313549 {
    static boolean[] visited;
    static int N, K, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs(N);

        System.out.println(answer);
    }

    public static void bfs(int N) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(N, 0));
        visited[N] = true;

        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int cnt = node.cnt;

            if (x == K) {
                answer = cnt;
                return;
            }

            int n=0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    n = x * 2;
                } else if (i == 1) {
                    n = x - 1;
                } else {
                    n = x + 1;
                }

                if (n < 0 || n > 100000) continue;
                if (!visited[n] && i > 0) {
                    visited[n] = true;
                    q.offerLast(new Node(n, cnt+1));
                }
                if (!visited[n] && i == 0) {
                    visited[n] = true;
                    q.offerLast(new Node(n, cnt));
                }
            }

        }
    }

    public static class Node {
        int x, cnt;

        public Node (int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
