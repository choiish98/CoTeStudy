#include <iostream>
#include <string>
 
using namespace std;
 
int main(){

    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);

    string outstr;

    string str;
    cin >> str;
 
    bool isCPP = false, isJAVA = false, isError = false;
    
    for (int i = 0; i < str.length(); i++){
        
        if (isupper(str[i])){
            if (i==0 || isCPP){
                isError = true;
                break;
            }
            
            outstr += '_';
            outstr += str[i] + 32;
            isJAVA = true;
        }
        else if (str[i] == '_')
        {
            if (isJAVA || i==0 || i == str.length() - 1 || str[i + 1] == '_' || isupper(str[i + 1]))
            { 
                isError = true;
                break;
            }
            outstr += str[i + 1] - 32;
            i++;
            isCPP = true;
        }
        
        else{
                outstr += str[i];
        }
    }
 
    if (isError){ cout << "Error!"; }
    
    else{ cout << outstr; }       
 
    return 0;
}