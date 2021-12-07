import java.io.*;
import java.util.*;

class pair {
    int node;
    int level;

    pair(int node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class bj16953 {
    static int b;

    static int bfs(int node) {
        Queue<pair> queue = new LinkedList<pair>();
        queue.add(new pair(node, 1));
        pair min = new pair(Integer.MAX_VALUE, 0);

        while (!queue.isEmpty()) {
            pair temp = queue.poll();

            int x2 = temp.node * 2;
            int plus1 = temp.node * 10 + 1;
            int next_level = temp.level + 1;

            if (x2 == b || plus1 == b) {
                return next_level;
            } else {
                queue.add(new pair(x2, next_level));
                queue.add(new pair(plus1, next_level));
                if (min.level < next_level) {
                    min.node = x2;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a));
    }
}
