import java.util.*;
import java.io.*;

public class 확장게임16920 {
    static char[][] map;
    static int[] S; //연속 이동 횟수
    static int[] numCnt; //번호 개수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, P, answer;
    static StringTokenizer st;
    static Deque<Node>[] q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        S = new int[P];
        numCnt = new int[P];
        q = new ArrayDeque[P];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            q[i] = new ArrayDeque<>();
        }

        int x;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] != '.' && map[i][j] != '#') {
                    x = str.charAt(j) - '0';
                    numCnt[x-1]++;
                    q[x-1].add(new Node(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i < P; i++) {
            System.out.print(numCnt[i] + " ");
        }
    }

    public static void bfs() {
        
        while (true) {
            for (int u = 0; u < P; u++) { //플레이어 수
                int s = S[u]; //연속 이동 횟수
                for (int i = 0; i < s; i++) {
                    int size = q[u].size(); //번호마다 q사이즈
                    
                    for (int j = 0; j < size; j++) {
                        Node node = q[u].pollFirst();
                        
                        int x = node.x;
                        int y = node.y;
    
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (map[nx][ny] == '.') {
                                map[nx][ny] = map[x][y];
                                q[u].offerLast(new Node(nx, ny));
                                numCnt[u]++;
                            }
                        }
                    }

                    if (q[u].isEmpty()) {
                        break;
                    }
                }
            }
            boolean f = true; // 모든 플레이어의 q가 비어있는지 확인
            for (int u = 0; u < P; u++) {
                if (!q[u].isEmpty()) {
                    f = false;
                    break;
                }
            }
            if (f) break;
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
