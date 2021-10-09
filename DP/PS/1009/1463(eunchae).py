import sys

n = int(sys.stdin.readline())

dp = [None,0]

# 2에서 n까지 최소한의 연산횟수로 1을 만드는 방법을 dp에 저장
for i in range(2,n+1):
    dp_value_list = []

    # dp[i-1] + 1 은 dp[i]의 후보군이 된다.
    dp_value_list.append(dp[i-1] + 1)
    
    # if i%3==0  ->  dp[i//3] + 1 은 dp[i]의 후보군이 된다.
    if i%3 == 0:
        dp_value_list.append(dp[i//3] + 1)
    
    # if i%2==0  ->  dp[i//2] + 1 은 dp[i]의 후보군이 된다.
    if i%2 == 0:
        dp_value_list.append(dp[i//2] + 1)

    # 후보군 중 가장 최소한의 연산횟수를 dp[i]로 추가
    dp.append(min(dp_value_list))

print(dp)
print(dp.pop())