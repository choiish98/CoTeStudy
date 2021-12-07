#include <iostream> 
using namespace std; 

int main() {
     
    int n, m[101], student, gender, num;
    int i, j; 
    
    cin >> n;
    
    for(i=1; i<=n; i++) { 
        
        cin >> m[i]; 
    } 
        
    cin >> student; 
        
        for(j=0; j<student; j++) {

            cin >> gender >> num;
            
            if(gender==1){
    
                for(i=1; i<=n; i++) { 
                    if(i%num==0){
                        m[i] = !m[i];
                    }
                }

            }else{ 
  
              m[num]=!m[num];
                        
              for(i=1; m[num+i]==m[num-i]; i++) { 
                            
                  if(num+i>n || num-i<1) {
                     break; 
                  }      
                  m[num+i] = !m[num+i];
                  m[num-i] = !m[num-i];
            } 
        } 
    }for(i=1; i<=n; i++) {
		cout << m[i] << " "; 
                
        if(i%20==0){
           cout << "\n";
        }
    }
