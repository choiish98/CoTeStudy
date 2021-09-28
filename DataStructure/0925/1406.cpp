#include<iostream>
#include<string>
#include<stack>
using namespace std;
 
int main(){
    
    string n; 
    int m; 
    stack<char> left, right;

    cin >> n; 
    
    int len = strlen(n);
    for (int i=0; i<len; i++) {	
        left.push(n[i]);
    }

    cin >> m;
    
    while(m--){
        char cmd;
        cin >> cmd;
        
        if(cmd=='L'){
            if(!(left.empty())){  
                right.push(left.top());
                left.pop(); 
            }   
        } 
        else if(cmd=='D'){
            if(!right.empty()){ 
                left.push(right.top());
                right.pop();
            }
        }
        else if(cmd=='B'){
            if(!(left.empty())){
                left.pop();
            }
        }
        else if(cmd=='P'){
            char x;
            cin >> x;
            left.push(x);
        }    
    }
    
    while(!(left.empty())){
        right.push(left.top());
        left.pop();
    } 
    
    while(!(right.empty())){
        cout << right.top();
        right.pop();
    }
    return 0;     
}