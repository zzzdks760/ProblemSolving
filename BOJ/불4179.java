import java.io.*;
import java.util.*;

public class 불4179 {
    static int N, M, answer;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<Node> q = new ArrayDeque<>(); //지훈
    static Deque<Node> q2 = new ArrayDeque<>(); //불
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'F') {
                    q.offerLast(new Node(i, j));
                }
                if (map[i][j] == 'J') {
                    q2.offerLast(new Node(i, j));
                }
            }
        }
        
        bfs();
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int fSize = q2.size();
            for (int i = 0; i < fSize; i++) {
                Node node = q2.pollFirst();
                
                for (int j = 0; j < 4; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (map[nx][ny] != '#' && map[nx][ny] != 'F') {
                            map[nx][ny] = 'F';
                            q2.offerLast(new Node(nx, ny));
                        }
                    }
                }
            }

            int jSize = q.size();
            for (int j = 0; j < jSize; j++) {
                Node node = q.pollFirst();

                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        System.out.println(answer+1);
                        return;
                    }
    
                    
                    if (map[nx][ny] != '#' && map[nx][ny] != 'F' && map[nx][ny] != 'J') {
                        map[nx][ny] = 'J';
                        q.offerLast(new Node(nx, ny));
                    }
                    
                }
            }
            answer++;
        }
        System.out.println("IMPOSSIBLE");
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
