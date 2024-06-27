import java.io.*;
import java.util.*;

public class 상근이의여행9372 {
    static int T, N, M, answer;
    static StringTokenizer st;
    static List<Integer> list[];
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());        

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N+1];
            visited = new boolean[N+1];
            answer = 0;

            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            visited[1] = true;
            dfs(1);

            System.out.println(answer);
        }
    }

    public static void dfs(int v) {
        for (int i : list[v]) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i);
            }
        }
    }
}
