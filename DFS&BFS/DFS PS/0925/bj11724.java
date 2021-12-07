import java.io.*;
import java.util.*;

public class bj11724 {
    static ArrayList<Integer>[] arr;
    static boolean[] check;

    static int dfs() {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (check[i] != true) {
                stack.push(i);
                check[i] = true;

                while (!stack.isEmpty()) {
                    int temp = stack.pop();

                    for (int node : arr[temp]) {
                        if (!check[node]) {
                            stack.push(node);
                            check[node] = true;
                        }
                    }
                }

                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        check = new boolean[n];

        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        System.out.println(dfs());
    }
}
