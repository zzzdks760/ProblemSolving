import java.io.*;
import java.util.*;

public class 벽부수고이동하기316933 {
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, K, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][11];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        if (answer > 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs(int v, int m) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m, 1, 0, true)); // true: 낮, false: 밤
        visited[v][m][0] = true;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;
            int d = node.d;
            int k = node.k;
            boolean day = node.day;

            if (x == N-1 && y == M-1) {
                answer = d;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0 && !visited[nx][ny][k]) {
                    visited[nx][ny][k] = true;
                    q.offerLast(new Node(nx, ny, d+1, k, !day));
                } else if (k < K) {
                    if (map[nx][ny] == 1 && !visited[nx][ny][k+1]) {
                        if (!day) {
                            q.offerLast(new Node(x, y, d+1, k, !day));
                        } else {
                            visited[nx][ny][k+1] = true;
                            q.offerLast(new Node(nx, ny, d+1, k+1, !day));
                        }
                    }
                }
            }
        }
    }

    public static class Node {
        int x, y, d, k; 
        boolean day;

        public Node (int x, int y, int d, int k, boolean day) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.k = k;
            this.day = day;
        }
    }
}

