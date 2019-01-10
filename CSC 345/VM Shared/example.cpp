#include<iostream>

using namespace std;

int sq (int& i);

main ()
{
  int x = 5;
  cout << sq(x) << endl;
  cout << x << endl;

  return 0;
} 

int sq(int& i)
{
  i = i*i;
  return i;
}
