#include <iostream>

int main(){

    int i = 0;
    int arr[] = {1,2,3,4,5};

    std::cout << "Size of array = " << sizeof(arr)/sizeof(arr[0]) <<"\n";
    std::cout << "Size of array = " << *(&arr + 1) - arr;

    return 0;
}