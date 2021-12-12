import java.io.*;
import java.util.*;

public class bj1916 {
    public static class Bus {
        int e;
        int w;

        public Bus(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    static ArrayList<Bus>[] al; // 노드
    static boolean[] check; // 방문 검사
    static int[] dist; // 최소값 저장

    static int dist(int startPoint, int endPoint) {
        Queue<Bus> q = new LinkedList<Bus>();
        q.add(new Bus(startPoint, 0));
        dist[startPoint] = 0;

        while (!q.isEmpty()) {
            Bus temp = q.poll();
            int nextNode = temp.e;

            if (!check[nextNode]) {
              check[nextNode] = true;

              for (Bus linkedNode : al[nextNode]) {
                  if (!check[linkedNode.e] && dist[linkedNode.e] > dist[nextNode] + linkedNode.w) {
                      dist[linkedNode.e] = dist[nextNode] + linkedNode.w;
                      q.add(new Bus(linkedNode.e, dist[linkedNode.e]));
                  }
              }
            }
        }

        return dist[endPoint];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        check = new boolean[n + 1]; // 방문 검사 초기화
        dist = new int[n + 1]; // 최소값 배열 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        al = new ArrayList[n + 1]; // 노드 초기화
        for (int i = 1; i <= n; i++) {
            al[i] = new ArrayList<Bus>();
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            al[s].add(new Bus(e, w)); // 노드 연결
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        // 다익스트라
        System.out.println(dist(startPoint, endPoint));
    }
}