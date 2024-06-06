import java.io.*;
import java.util.*;

public class 유기농배추1012 {
    static StringTokenizer st;
    static int N, M, K, answer;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
    
            map = new int[N][M];
            answer = 0;
    
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
        
    }

    public static void bfs(int v, int m) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m));
        map[v][m] = 0;

        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 1) {
                        q.offerLast(new Node(nx, ny));
                        map[nx][ny] = 0;
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
