from collections import deque
import sys

"""
[1012]백준 - 유기농 배추(Silver2)
"""

TEST_CASE_COUNT = int(sys.stdin.readline())   # 테스트 케이스 횟수




for _ in range(TEST_CASE_COUNT):
    """
    테스트 케이스 횟수 만큼 for문 반복
    """
    WIDTH, HEIGHT, CABBAGE_COUNT = list(map(int, sys.stdin.readline().strip().split()))   # 배추밭의 (가로), (세로), (심어진 배추의 개수)

    adjacent_data = dict()   # { (i,j) :set([(인접한 배추),...]), ... }
    for _ in range(CABBAGE_COUNT):
        """
        배추의 개수만큼 좌표INPUT을 받아서 adjacent_data에 (i,j):set() 형태로 추가
        """
        cabbage_coordinate = tuple(map(int, sys.stdin.readline().strip().split()))
        adjacent_data[cabbage_coordinate] = set()


    for coord in adjacent_data.keys():
        """
        인접한 배추의 좌표를 adjacent_data의 set()에 추가
        """
        i, j = coord   # 배추의 (i,j)좌표값 할당

        if (i-1 >= 0) and type(adjacent_data.get((i-1, j))) is set: # if 배추밭 가로범위를 벗어나지 않고 and 심어져있는 배추이면
            adjacent_data[(i, j)].add((i-1, j))                     # -> 인접한 배추를 추가

        if (i+1 < WIDTH) and type(adjacent_data.get((i+1, j))) is set:
            adjacent_data[(i, j)].add((i+1, j))

        if (j-1 >= 0) and type(adjacent_data.get((i, j-1))) is set:
            adjacent_data[(i, j)].add((i, j-1))

        if (j < HEIGHT) and type(adjacent_data.get((i, j+1))) is set:
            adjacent_data[(i, j)].add((i, j+1))


    visited = set()         # 방문한 좌표
    earth_worm_count = 0    # 필요한 지렁이의 수
    for coord in adjacent_data.keys():
        """
        if 좌표(coord)가 이미 방문한 좌표이면 -> continue(다음 배추의 좌표로 이동)
        else 해당 배추의 좌표(coord)대해 BFS(너비우선탐색) 시행 -> 방문한 좌표 추가 -> 지렁이수 + 1
        """
        queue = deque([coord])

        # 방문한 좌표라면 지렁이 수를 카운트 하면 안되므로, 밑의 코드를 무시하고
        # adjacent_data의 다음 key값으로 이동하여 for문 진행
        if coord in visited:
            continue
        
        while queue:
            """
            -BFS 코드
            if queue에서 꺼낸노드(n)가 방문한 좌표가 아니면 -> 방문한 좌표에 추가
                                                              queue에 (n의 인접 좌표) 와 (방문한 좌표) 의 차집합을 추가
            """
            n = queue.popleft()
            if n not in visited:
                visited.add(n)
                queue += adjacent_data[n] - visited
        
        # 하나의 연결된 그래프(인접해있는 구역)만큼 방문한 좌표에 추가되면 -> 지렁이 수 + 1
        earth_worm_count += 1
    
    print(earth_worm_count)