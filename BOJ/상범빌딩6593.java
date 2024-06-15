import java.io.*;
import java.util.*;

public class 상범빌딩6593 {
    static char[][][] map;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int T, N, M, answer;
    static StringTokenizer st;
    static Deque<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[T][N][M];
            answer = 0;
    
            if (T == 0 && N == 0 && M == 0) break;

            q = new ArrayDeque<>();

            for (int t = 0; t < T; t++) {
                for (int i = 0; i < N; i++) {
                    String str = br.readLine();
                    for (int j = 0; j < M; j++) {
                        map[t][i][j] = str.charAt(j);
                        
                        if (map[t][i][j] == 'S') {
                            q.offerLast(new Node(t, i, j, 0));
                        }
                    }
                }
                String temp = br.readLine();
            }

            
            bfs();

            if (answer != 0) {
                System.out.println("Escaped in " + answer + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            int z = node.z;
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                
                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= T) continue;
                if (map[nz][nx][ny] == '#' || map[nz][nx][ny] == 'S') continue;
                if (map[nz][nx][ny] == 'E') {
                    answer = cnt+1;
                    return;
                }
                if (map[nz][nx][ny] == '.') {
                    map[nz][nx][ny] = 'S';
                    q.offerLast(new Node(nz, nx, ny, cnt+1));
                }
            }
        }
    }

    public static class Node {
        int z, x, y, cnt;

        public Node (int z, int x, int y, int cnt) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
