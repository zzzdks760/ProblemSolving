import java.io.*;
import java.util.*;
// 같으면 다 포함
public class 숫자고르기2668 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] == i) {
                list.add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        System.out.println(list);
    }

    public static void dfs(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }

        if (arr[start] == target) {
            list.add(target);
        }
    }
}
