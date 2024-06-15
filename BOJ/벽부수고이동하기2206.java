import java.io.*;
import java.util.*;

public class 벽부수고이동하기2206 {
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] brvisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        brvisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        bfs();
        
        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void bfs() {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(0, 0, 1, 0));
        map[0][0] = 1;
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;
            int d = node.d;
            int br = node.br;

            if (x == N-1 && y == M-1) {
                answer = d;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 1 && !brvisited[nx][ny]) {
                        if (br == 0) {
                            brvisited[nx][ny] = true;
                            q.offerLast(new Node(nx, ny, d+1, 1));
                        }
                    } else if (map[nx][ny] == 0){
                        if (br == 1 && !brvisited[nx][ny]) {
                            brvisited[nx][ny] = true;
                            q.offerLast(new Node(nx, ny, d+1, 1));
                        } else if(br == 0 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offerLast(new Node(nx, ny, d+1, 0));
                        }
                    } 
                }
            }
        }
    }

    public static class Node {
        int x, y, d, br;

        public Node (int x, int y, int d, int br) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.br = br;
        }
    }
}
