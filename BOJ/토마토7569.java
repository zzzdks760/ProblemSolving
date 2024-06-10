import java.io.*;
import java.util.*;

public class 토마토7569 {
    static int[][][] map;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int N, M, H, answer;
    static StringTokenizer st;
    static Deque<Node> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        boolean isZero = false;

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if (map[h][i][j] == 1) {
                        q.offerLast(new Node(h, i, j));
                    }

                    if (map[h][i][j] == 0) {
                        isZero = true;
                    }
                }
            }
        }

        if (!isZero) {
            System.out.println(0);
            System.exit(0);
        }

        bfs();

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[h][i][j] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(answer-1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int z = node.z;
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && nz >= 0 && nz < H) {
                    if (map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = map[z][x][y] + 1;
                        q.offerLast(new Node(nz, nx, ny));
                        answer = Math.max(answer, map[nz][nx][ny]);
                    }
                }
            }
        }
    }

    public static class Node {
        int z, x, y;

        public Node (int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}
