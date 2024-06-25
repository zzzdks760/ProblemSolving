import java.io.*;
import java.util.*;

public class 말이되고픈원숭이1600 {
    static StringTokenizer st;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hx = {-1, -2, 1, 2, -1, -2, 1, 2};
    static int[] hy = {2, 1, 2, 1, -2, -1, -2, -1};
    static int K, W, H, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (H == 1 && W == 1) {
            System.out.println(0);
            System.exit(0);
        }

        bfs(0, 0);

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void bfs(int v, int m) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m, 0, K));
        visited[v][m][K] = true;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;
            int d = node.d;
            int horse = node.horse;

            if (x == H-1 && y == W-1) {
                answer = d;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (map[nx][ny] == 0 && !visited[nx][ny][horse]) {
                    visited[nx][ny][horse] = true;
                    q.offerLast(new Node(nx, ny, d+1, horse));
                    
                }
            }

            if (horse > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + hx[i];
                    int ny = y + hy[i];
    
                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (map[nx][ny] == 0 && !visited[nx][ny][horse-1]) {
                        visited[nx][ny][horse-1] = true;
                        q.offerLast(new Node(nx, ny, d+1, horse-1));
                    }
                }
            }

        }
    }

    public static class Node {
        int x, y, d, horse;

        public Node (int x, int y, int d, int horse) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.horse = horse;
        }
    }
}
