import java.io.*;
import java.util.*;

public class 적록색약10026 {
    static char[][] map;
    static char[][] map2;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        map2 = new char[N][N];
        visited = new boolean[N][N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == 'G') {
                    map2[i][j] = 'R';
                } else {
                    map2[i][j] = str.charAt(j);
                }
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R' || map[i][j] == 'G' || map[i][j] == 'B') {
                    if (!visited[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }
        }

        System.out.print(answer + " ");

        visited = new boolean[N][N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map2[i][j] == 'R' || map2[i][j] == 'B') {
                    if (!visited[i][j]) {
                        bfs2(i, j);
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int v, int m) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m));
        visited[v][m] = true;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] == map[x][y] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offerLast(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static void bfs2(int v, int m) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m));
        visited[v][m] = true;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map2[nx][ny] == map2[x][y] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offerLast(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static class Node {
        int x, y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
