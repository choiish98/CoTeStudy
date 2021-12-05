#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using ll = long long;

int N;
int dp[22][103]; //i번째 사람의 j 체력일때의 행복 최댓값
int happy[22];
int power[22];

int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(NULL);

	cin >> N;

	for (int i = 1; i <= N; i++) {
        cin >> power[i];
    }

	for (int i = 1; i <= N; i++) {
        cin >> happy[i];
    }

    int maxhappy = -1e8;

	for (int i = 1; i <= N; i++) {
		for (int j = 100; j >= 0; j--) {
			
            if (j - power[i] >= 1) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - power[i]] + happy[i]);
            }else {
                dp[i][j] = dp[i - 1][j];
            }

			maxhappy = max(maxhappy, dp[i][j]);
		}
	}
	cout << maxhappy;
}