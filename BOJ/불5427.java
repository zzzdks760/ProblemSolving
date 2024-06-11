import java.io.*;
import java.util.*;

public class 불5427 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int T, W, H, answer;
    static StringTokenizer st;
    static Deque<Node> s_q;
    static Deque<Node> f_q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            answer = 0;
    
            map = new char[H][W];

            s_q = new ArrayDeque<>();
            f_q = new ArrayDeque<>();
    
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
    
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '@') {
                        s_q.offerLast(new Node(i, j));
                    }
                    if (map[i][j] == '*') {
                        f_q.offerLast(new Node(i, j));
                    }
                }
            }

            bfs();
        }
    }

    public static void bfs() {
        while(!s_q.isEmpty()) {
            int fsize = f_q.size();
            for (int j = 0; j < fsize; j++) {
                Node node = f_q.pollFirst();
                int x = node.x;
                int y = node.y;

                for (int i = 0 ; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                        if (map[nx][ny] == '.' || map[nx][ny] == '@') {
                            map[nx][ny] = '*';
                            f_q.offerLast(new Node(nx, ny));
                        }
                    } 
                }
            }

            int ssize = s_q.size();
            for (int j = 0; j < ssize; j++) {
                Node node = s_q.pollFirst();
                int x = node.x;
                int y = node.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                        System.out.println(answer + 1);
                        return;
                    }

                    if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = '@';
                            s_q.offerLast(new Node(nx, ny));
                        }
                    }
                }
            }
            answer++;
        }
        System.out.println("IMPOSSIBLE");
    }

    public static class Node {
        int x, y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
