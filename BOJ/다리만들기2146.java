import java.io.*;
import java.util.*;

public class 다리만들기2146 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, answer, n;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        n = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j, n);
                    n++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    bfs2(i, j, map[i][j]);
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs2(int v, int m, int c) {
        visited = new boolean[N][N];
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m, 0));
        visited[v][m] = true;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] != 0 && map[nx][ny] != c) {
                    answer = Math.min(answer, cnt);
                    return;
                }
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    q.offerLast(new Node(nx, ny, cnt+1));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void bfs(int v, int m, int n) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m, 0));
        map[v][m] = n;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1) {
                    map[nx][ny] = n;
                    q.offerLast(new Node(nx, ny, 0));
                }
            }
        }
    }

    public static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
