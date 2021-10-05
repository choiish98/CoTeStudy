#include <iostream>
#include <algorithm>
using namespace std;
int n[5];

int main()
{
	for (int i = 0; i < 5; i++) 
        cin >> n[i];

	for (int i = 4; i > 0; i--) {
		for (int j = 0; j < i; j++) {
			if (n[j] > n[j+1]) {
				int m; 
                m = n[j]; 
                n[j] = n[j + 1];
                n[j + 1] = m;

				for (int k = 0; k < 5; k++)
					cout << n[k] << " ";

				cout << endl;
			}
		}
	}
}