import java.io.*;
import java.util.*;

public class 나이트의이동7562 {
    static int[][] map;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
    static boolean[][] visited;
    static int N, x2, y2, answer;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); // 한변의 길이
            map = new int[N][N];
            visited = new boolean[N][N];
            answer = 0;

            st = new StringTokenizer(br.readLine()); // 시작 위치
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()); // 이동 위치
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            
            bfs(x1, y1);

            System.out.println(answer);
        }
    }

    public static void bfs(int v, int m) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m, 0));
        visited[v][m] = true;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            if (x == x2 && y == y2) {
                answer = cnt;
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offerLast(new Node(nx, ny, cnt+1));
                    }
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
