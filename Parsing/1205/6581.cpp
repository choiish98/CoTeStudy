#include <iostream>

#include <string>

using namespace std;

int main(){

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string str;
    int lineSize = 0;

    while (cin >> str){

        if (str == "<br>"){
            cout << "\n";
            lineSize = 0;
        }
        
        else if (str == "<hr>"){
            if (lineSize==0){
                for (int i = 0; i < 80; i++){
                    cout << "-";
                }
                cout << "\n";
            }else{
                lineSize = 0;
                cout << "\n";
                
                for (int i = 0; i < 80; i++){
                    cout << "-";
                }
                cout << "\n";        
            }
        }

        else{

            if (lineSize==0){
                lineSize = str.length();
                cout << str;
            }

            else if(lineSize + str.length() < 80){
                cout << " ";
                lineSize += 1; 
                lineSize += str.length();
                cout << str;

                if (lineSize == 80){
                    cout << "\n";
                    lineSize = 0;
                }                 
            }
            else{
                cout << "\n";
                lineSize = str.length();
                cout << str;
            }
        }
    }
}