import java.io.*;
import java.util.*;

public class 토마토7576 {
    static int[][] map;
    static int N, M, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<Node> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        M = Integer.parseInt(st.nextToken()); //열
        N = Integer.parseInt(st.nextToken()); //행

        map = new int[N][M];

        boolean isAllRip = false;

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if (map[i][j] == 0) {
                    isAllRip = true;
                }
            }
        }

        if (!isAllRip) {
            System.out.println(0);
            System.exit(0);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    q.offerLast(new Node(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    answer = -1;
                    System.out.println(answer);
                    System.exit(0);
                }
            }
        }

        System.out.println(answer-1);

    }

    public static void bfs() {
        
        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                        q.offerLast(new Node(nx, ny));
                        answer = Math.max(map[nx][ny], answer);
                    }
                }
            }
        }
    }

    public static class Node{
        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
