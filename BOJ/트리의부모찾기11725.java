import java.io.*;
import java.util.*;

public class 트리의부모찾기11725 {
    static List<Integer> list[];
    static int[] count;
    static int N, answer;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = new int[N+1];

        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        count[1] = 1;
        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(count[i]);
        }

    }

    public static void dfs(int v) {
        for (int i : list[v]) {
            if (count[i] == 0) {
                count[i] = v;
                dfs(i);
            }
        }
    }
}
