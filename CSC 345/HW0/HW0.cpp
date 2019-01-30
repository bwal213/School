//Written by Ben Walker

#include <iostream>
using namespace std;

int square(int&);
int twice(int&);
int once(int&);

main(){
  int x = 3;
  int y = square(x) + twice(x) + once(x);  // y == 45, not 18
  cout << y << endl;                       // prints 45, not 18
}

int square(int& i){
  i = i*i;                                 // squares i
  return i;
}

int twice(int& i){
  i = 2*i;                                 // doubels i
  return i;
}

int once(int& i){
  return i;
}
  
