import java.io.*;
import java.util.*;

public class 스타트링크5014 {
    static int F, S, G, U, D, cnt;
    static int[] map;
    public static void main(String[] args) throws IOException {
        // F: 10, S: 1, G: 10   U: 2, D: 1     1 -> 3, 5, 7, 9, 8, 10
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[F+1];

        bfs();

    }

    public static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(S);
        map[S] = 1;
        int n;

        while(!q.isEmpty()) {
            int x = q.pollFirst();

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    n = x + U;
                } else {
                    n = x - D;
                }

                if (n >= 1 && n <= F && map[n] == 0) {
                    map[n] = map[x]+1;
                    q.offerLast(n);

                    if (map[G] != 0) {
                        System.out.println(map[G]-1);
                        return;
                    }
                }
            }
        }
        System.out.println("use the stairs");
    }
}
