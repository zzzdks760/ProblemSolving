import java.io.*;
import java.util.*;

public class 영역구하기2583 {
    static int N, M, K, answer, x1, y1, x2, y2, cnt;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ArrayList<Integer> list = new ArrayList<>();

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                    answer++;
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
        System.out.println(answer);
        Collections.sort(list);
        for (int x : list) {
            System.out.print(x + " ");
        }
    }

    public static void bfs(int v, int m) {
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(v, m));
        map[v][m] = 1;
        cnt++;

        while(!q.isEmpty()) {
            Node node = q.pollFirst();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        cnt++;
                        q.offerLast(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
