import java.io.*;
import java.util.*;

public class bj12886 {
    static int result = 0;
    static boolean[][] visited = new boolean[1501][1501];

    static void cal(int a, int b, int c) {
        int small = Math.min(a, b);
        int big = Math.max(a, b);

        if (!visited[small * 2][big - small]) {
            visited[small * 2][big - small] = visited[big - small][small * 2] = true;
            dfs(small * 2, big - small, c);
        }
    }

    static void dfs(int a, int b, int c) {
        if (a == b && b == c) {
            result = 1;
        }

        cal(a, b, c);
        cal(b, c, a);
        cal(a, c, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        dfs(a, b, c);
        System.out.println(result);
    }
}