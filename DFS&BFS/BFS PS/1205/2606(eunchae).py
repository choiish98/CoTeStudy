import sys
from collections import deque

COMPUTER_COUNT = int(sys.stdin.readline())  # INPUT: 컴퓨터의 수
COMPUTER_SET_COUNT = int(sys.stdin.readline())  # INPUT: 연결된 컴퓨터 쌍의 수

graph = {i: set() for i in range(1, COMPUTER_COUNT+1)}

# 연결된 컴퓨터들의 관계 추가
for _ in range(COMPUTER_SET_COUNT):
    com1, com2 = map(int, sys.stdin.readline().strip().split())  # 연결된 두개의 컴퓨터
    graph[com1].add(com2)
    graph[com2].add(com1)

infected_computers = set([1])  # 감염된 컴퓨터들

queue = deque([1])
count = 0
while queue:
    com = queue.popleft()
    
    for c in graph[com] - infected_computers:
        infected_computers.add(c)
        queue.append(c)

print(len(infected_computers) - 1)

