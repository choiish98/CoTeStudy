import java.util.*;
import java.io.*;

public class bj1446 {
    static class Graph { // 길 객체
        int s, e, w;

        public Graph(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드의 개수
        int d = Integer.parseInt(st.nextToken()); // 도착지점

        List<Graph> list = new ArrayList<>(); // 지름길 리스트

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 예외처리
            if (e > d) // 도착 지점 넘어갈 경우
                continue;
            if (e - s <= w) // 지름길 가성비 ㅎㅌㅊ
                continue;

            list.add(new Graph(s, e, w));
        }

        // 정렬
        Collections.sort(list, new Comparator<Graph>() {
            public int compare(Graph o1, Graph o2) {
                if (o1.s == o2.s)
                    return o1.e - o2.e;
                return o1.s - o2.s;
            }
        });

        int idx = 0, move = 0; // 지름길 인덱스, 내 위치
        int[] dist = new int[10001]; // 총 비용 배열
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        // 다익스트라
        while (move < d) {
            if (idx < list.size()) { // 지름길 먼저 값을 넣기 위해
                Graph g = list.get(idx);
                if (move == g.s) {
                    dist[g.e] = Math.min(dist[move] + g.w, dist[g.e]);
                    idx++;
                } else {
                    dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                    move++;
                }
            } else {
                dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                move++;
            }
        }

        System.out.println(dist[d]);
    }
}