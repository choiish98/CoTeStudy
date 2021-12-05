import sys

STEP_COUNT = int(sys.stdin.readline())  # INPUT: 계단 수
STEP_SCORES = [None] + [ int(sys.stdin.readline().strip()) for _ in range(STEP_COUNT) ]  # INPUT: [ 계단 점수, ... ]

no_adjacent_left = [0, STEP_SCORES[1]] +  [0] * (STEP_COUNT-1)  # 바로 왼쪽의 계단을 안 밟았을 경우의 최대값
has_adjacent_left = [0, STEP_SCORES[1]] +  [0] * (STEP_COUNT-1)  # 바로 왼쪽의 계단을 밟았을 경우의 최대값

for i in range(2, STEP_COUNT+1):
    no_adjacent_left[i] = max(has_adjacent_left[i-2], no_adjacent_left[i-2]) + STEP_SCORES[i]
    has_adjacent_left[i] = no_adjacent_left[i-1] + STEP_SCORES[i]


print(max(no_adjacent_left[STEP_COUNT], has_adjacent_left[STEP_COUNT]))