#include<iostream>
#include<queue>
using namespace std;

queue<int> num;


int main(){

    int n;
    int cnt=0;
    int i, j, tmp;

    cin >> n; 

	if(n < 11){
		cout << n;
	}

	else if( n == 1022)
		cout << 9876543210;

	else if(n >= 1023)
		cout << "-1" ;

	else{
		for(i=1; i<10; i++){
			num.push(i);
			cnt++;
		}
	
		while(cnt < n ){

			i = num.front();
			num.pop();

			tmp = i%10;

			for(j = 0; j<tmp; j++){
				num.push(i*10 + j);
				cnt++;

				if(cnt == n){
					cout << i*10 + j;
					break;
				}
			}
		}
	}
	return 0;
}