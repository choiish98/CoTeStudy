import sys

SEQUENCE_LENGTH = int(sys.stdin.readline())  # INPUT: 수열의 길이
sequence = list(map(int, sys.stdin.readline().strip().split()))  # INPUT: 수열 리스트

dp = [1]
for i in range(1, SEQUENCE_LENGTH):
    dp_value = 0
    for j in range(i):
        if sequence[i] > sequence[j]:
            dp_value = max(dp_value, dp[j])
    dp.append(dp_value + 1)


print(max(dp))
