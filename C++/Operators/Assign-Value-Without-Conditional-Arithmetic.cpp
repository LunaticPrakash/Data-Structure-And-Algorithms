/*
If 'x' is 0, 
   Assign value 'a' to variable 'y' 
Else (If 'x' is 1)
   Assign value 'b' to variable 'y'.

You are not allowed to use any
conditional operator (including ternary operator)
or any arithmetic operator ( +, -, *, /).
*/

#include <iostream>

int Assign_Value(int a, int b, int x){
    int y;
    int arr[2];

    arr[0] = a;
    arr[1] = b;

    y = arr[x];
    return y;
}

int main(){

    int a,b,x;

    std::cout << "Enter value of a : " ;
    std::cin >> a;

    std::cout << "Enter value of b : " ;
    std::cin >> b;

    std::cout << "Enter value of x : " ;
    std::cin >> x;

    std::cout << "\nValue of y = " << Assign_Value(a,b,x) << std::endl;

    return 0;

}