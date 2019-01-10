/*
 * HW0.cpp
 *
 *  Created on: Sep 5, 2018
 *      Author: Ben Walker
 *       Class: CSC 345
 *  Assignment: Home Work 0
 * Description: Demonstrates pass by reference in C++
 */

#include <iostream>
using namespace std;

int square(int&);
int twice(int&);
int once(int&);

/*
 * Does the math by pass by reference resulting in an impossible
 * result if the rules of math were used.
 */
main(){
  int x = 3;
  int y = square(x) + twice(x) + once(x);  // y == 45, not 18
  cout << y << endl;                       // prints 45, not 18
}

/*
 * Takes in a value by reference, then updates it to the square of it.
 *
 * @param i The pass by refernce value to allow for the updating
 * of the value.
 * @return The squared value of the reference.
 */
int square(int& i){
  i = i*i;                                 // squares i
  return i;
}

/*
 * Takes in a value by reference, then updates it to twice its value.
 *
 * @param i The pass by refernce value to allow for the updating
 * of the value.
 * @return Two times the value of the reference.
 */
int twice(int& i){
  i = 2*i;                                 // doubels i
  return i;
}

/*
 * Takes in a value by reference, returns it.
 *
 * @param i The pass by refernce value.
 * @return The same as the value of the reference.
 */
int once(int& i){
  return i;
}




