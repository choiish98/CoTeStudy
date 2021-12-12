from collections import deque
import sys

# INPUT: 종이 길이
PAPER_LENGTH = int(sys.stdin.readline())  
# INPUT: 1,0으로 이루어진 색종이 이차원배열 초기화
paper = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(PAPER_LENGTH)]




def check_area(x_start, x_end, y_start, y_end):
    """
    -해당되는 정사각형의 구역이 1 or 0 or 섞여있는지 확인
    -섞여있으면 False, 1 or 0 이면 해당되는 string 값을 반환
    """
    global paper
    color_type = paper[y_start][x_start]
    for i in range(y_start, y_end):
        for j in range(x_start, x_end):
            if color_type != paper[i][j]:
                return False
    return str(color_type)




# 모든 종이가 같은색으로 칠해져 있는 경우 예외처리
if check_area(0, len(paper), 0, len(paper)) == "0":
    print("1\n0")
    sys.exit()
elif check_area(0, len(paper), 0, len(paper)) == "1":
    print("0\n1")
    sys.exit()



# ---------------------메인 코드------------------------
count_0 = 0
count_1 = 0
queue = deque([(0, len(paper), 0, len(paper))]) # queue에는 검사할 구역의 x,y시작/끝 좌표가 주어짐
while queue:
    area = queue.popleft()
    x_start, x_end, y_start, y_end = area

    # 1칸짜리인 경우 그대로 count에 더해준다
    if x_end - x_start == 1:
        for i in range(y_start, y_end):
            for j in range(x_start, x_end):
                if paper[i][j] == "0":
                    count_0 += 1
                else:
                    count_1 += 1
        continue

    # 4개로 나눠진 구역의 각각의 범위들
    divided_area1 = (x_start, int((x_start+x_end)/2), y_start, int((y_start+y_end)/2))
    divided_area2 = (x_start, int((x_start+x_end)/2), int((y_start+y_end)/2), y_end)
    divided_area3 = (int((x_start+x_end)/2), x_end, y_start, int((y_start+y_end)/2))
    divided_area4 = (int((x_start+x_end)/2), x_end, int((y_start+y_end)/2), y_end)

    divided_areas = [divided_area1, divided_area2, divided_area3, divided_area4]


    for divided_area in divided_areas:
        checked_area = check_area(*divided_area)
        # 1과 0이 섞여있는 경우 queue에 추가
        if not checked_area:
            queue.append(divided_area)
        # 1혹은 0으로만 이루어진 경우 count값에 +1
        else:
            if checked_area == "0":
                count_0 += 1
            else:
                count_1 += 1
    

print(count_0)
print(count_1)