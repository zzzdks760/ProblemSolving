import java.io.*;
import java.util.*;

public class 빙산2573 {
    static StringTokenizer st;
    static int N, M, max, cnt, answer, t, zcnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        while (true) {
            zcnt = 0;
            t++;
            q = new ArrayDeque<>();

            visited = new boolean[N][M];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        int n = zero(i, j); //주변 바닷물 수
                        q.offerLast(new Node(i, j, n));
                    }
                }
            }
            bfs(); // -1년후 빙산
            // System.out.println(Arrays.deepToString(map));

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        bfs2(i, j);
                        cnt++;
                    }
                    if (map[i][j] > 0) zcnt++;
                }
            }
            if (cnt > 1) {
                System.out.println(t);
                System.exit(0);
            }
            if (zcnt == 0) {
                System.out.println(0);
                break;
            }
        }
    }


    public static void bfs2(int v, int m) {
        q = new ArrayDeque<>();
        q.offerLast(new Node(v, m, 0));
        visited[v][m] = true;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] > 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offerLast(new Node(nx, ny, 0));
                }
            }
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;
            int n = node.n;
            if (map[x][y] - n < 0) {
                map[x][y] = 0;
            } else {
                map[x][y] = map[x][y] - n;
            }
        }
    }

    public static int zero (int x, int y) {
        int n = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (map[nx][ny] == 0) {
                n++;
            }
        }
        return n;
    }

    public static class Node {
        int x, y, n;

        public Node (int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
}
