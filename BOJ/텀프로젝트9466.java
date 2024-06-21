import java.io.*;
import java.util.*;

public class 텀프로젝트9466 {
    static int T, N, answer;
    static StringTokenizer st;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
                if (i == map[i]) map[i] = 0;
            }
            System.out.println(Arrays.toString(map));

            for (int i = 1; i <= N; i++) {
                if (map[i] != 0) {
                    bfs(map[i]);
                }
            }

        }
    }

    public static void bfs(int v) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(v);
        map[v] = 0;

        while(!q.isEmpty()) {
            int x = q.pollFirst(); // 3

            for (int i = 1; i <= N; i++) {
                if (map[x] != 0) 
                
            }
        }
    }
}
