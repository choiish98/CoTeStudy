import java.util.*;
import java.io.*;

public class bj14496 {
    static class Point { // 노드 객체
        int tg, d;

        public Point(int tg, int d) {
            this.tg = tg;
            this.d = d;
        }
    }

    static List<Integer>[] list = new ArrayList[1001]; // 그래프 표현할 연결 리스트
    static int[] dist = new int[1001]; // 최솟값 표현 할 배열
    static int MAX = Integer.MAX_VALUE;

    // 다익스트라
    static void Dijkstra(int start) {
        Queue<Point> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        dist[start] = 0;
        pq.add(new Point(start, 0));

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            int cur = p.tg;
            int d = p.d;

            if (dist[cur] < d)
                continue;

            for (int next : list[cur]) {
                if (dist[next] > d + 1) {
                    dist[next] = d + 1;
                    pq.add(new Point(next, d + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken()); // 출발점
        int goal = Integer.parseInt(st.nextToken()); // 목표점

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 지름길 개수

        Arrays.fill(dist, MAX);
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int tg = Integer.parseInt(st.nextToken());

            list[h].add(tg);
            list[tg].add(h);
        }

        Dijkstra(target);
        System.out.println(dist[goal] == MAX ? -1 : dist[goal]); // 초기화된 값이면 ㅂㄱㄴ
    }
}