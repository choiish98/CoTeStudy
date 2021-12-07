#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <set>
using namespace std;

set<string> seet;
string formula;
bool a[200];
bool visit[200];
vector<pair<int, int>> par;

void dfs(int idx, int cnt) {

	if (cnt > 0) {
		string s = "";
		for (int i = 0; i < formula.size(); i++) {

			if (a[i]){
				continue;
			}
			s += formula[i];

		}
		seet.insert(s);
	}
	for (int i = idx; i < par.size(); i++) {
		if (visit[i]){
			continue;
		}

		visit[i] = true;
		a[par[i].first] = true;
		a[par[i].second] = true;
		dfs(cnt + 1, idx + 1);
		visit[i] = false;
		a[par[i].first] = false;
		a[par[i].second] = false;
	}
}

int main() {

	ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
	
	stack<int> stack;

    cin >> formula;

	for (int i = 0; i < formula.size(); i++) {

		char c = formula[i];

		if (c == '(') {
            stack.push(i);
		}else if (c == ')') {
			par.push_back({stack.top(),i});
			stack.pop();
		}
	}

	dfs(0,0);

	for (auto out : seet) {
		cout << out << '\n';
	}
	return 0;
	
}