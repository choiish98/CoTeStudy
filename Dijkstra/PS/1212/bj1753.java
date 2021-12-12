import java.io.*;
import java.util.*;

public class bj1753 {
    public static class Node { // 노드 클래스: 가중치를 같이 저장하기 위해 생성
        int v; // 목표 지점
        int w; // 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static List<Node>[] nodeList; // 노드를 구현 할 연결리스트
    static int[] dist; // 최솟값 저장 배열
    static int[] check; // 방문 검사 배열

    static void dijkstra(int startPoint) {
        Queue<Node> pq = new LinkedList<>();
        dist[startPoint] = 0;
        check[startPoint] = 1;
        pq.add(new Node(startPoint, 0));

        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            if(check[temp.v] == 0) continue;

            for (int i = 0; i < nodeList[temp.v].size(); i++) {
                Node linkedNode = nodeList[temp.v].get(i);

                if (temp.w + linkedNode.w < dist[linkedNode.v]) {
                    dist[linkedNode.v] = temp.w + linkedNode.w;
                    check[linkedNode.v] = 1;
                    pq.add(new Node(linkedNode.v, temp.w + linkedNode.w));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int startPoint = Integer.parseInt(br.readLine()); // 시작 노드

        check = new int[n+1]; // 방문 검사 배열 초기화
        dist = new int[n+1]; // 최솟값을 저장할 배열 크기 초기화
        Arrays.fill(dist, Integer.MAX_VALUE); // 최솟값 저장 배열 max value 초기화
        nodeList = new ArrayList[m+1]; // 연결 리스트 배열 크기 초기화
        for (int i = 1; i <= n; i++) {
            nodeList[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodeList[u].add(new Node(v, w)); // 연결 리스트에 가중치를 포함한 노드 클래스 삽입
        }

        dijkstra(startPoint); // 다익스트라
        for (int i = 1; i <= n; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }
}