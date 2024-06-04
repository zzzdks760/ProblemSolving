import java.io.*;
import java.util.*;

public class DFS와BFS {
    static StringTokenizer st;
    static int N, M, V;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        System.out.println(Arrays.deepToString(map));
        
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    public static void dfs(int v) {
        visited[v] = true;

        System.out.print(v + " ");
        for (int i = 1; i <= N; i++) {
            if (map[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(v);
        visited[v] = true;
        
        System.out.print(v + " ");
        while (!q.isEmpty()) {
            int x = q.pollFirst();

            for (int i = 1; i <= N; i++) {
                if (map[x][i] == 1 && !visited[i]) {
                    System.out.print("bfs: " + i);
                    visited[i] = true;
                    q.offerLast(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}
