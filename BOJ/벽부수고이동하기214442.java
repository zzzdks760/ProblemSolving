import java.io.*;
import java.util.*;

public class 벽부수고이동하기214442 {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][] visited;
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
        q.offerLast(new Node(v, m, 1, 0));
        visited[v][m][0] = true;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;
            int d = node.d;
            int b = node.b;

            if (x == N-1 && y == M-1) {
                answer = d;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0) { //길
                    if (!visited[nx][ny][b]) {
                        visited[nx][ny][b] = true;
                        q.offerLast(new Node(nx, ny, d+1, b));
                    }
                } else {
                    if (b < K) {
                        if (!visited[nx][ny][b+1]) {
                            visited[nx][ny][b+1] = true;
                            q.offerLast(new Node(nx, ny, d+1, b+1));
                        }
                    }
                }

            }
        }
    }

    public static class Node {
        int x, y, d, b;

        public Node (int x, int y, int d, int b) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.b = b;
        }
    }
}
