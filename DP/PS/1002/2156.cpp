#include<iostream>
#include<algorithm>
using namespace std;

int main(){

    int n;
    int DP[100001];
    int wine[10001];

    cin >> n;

    for(int i=1; i<n+1; i++){
        cin >> wine[i];
    }

    DP[1] = wine[1];
    DP[2] = wine[1] + wine[2];

    for(int j=3; j<n+1; j++){
        DP[j] = max(DP[j-1], max(DP[j-2]+wine[j], DP[j-3]+wine[j-1]+wine[j]));
    }

    cout << DP[n];
}