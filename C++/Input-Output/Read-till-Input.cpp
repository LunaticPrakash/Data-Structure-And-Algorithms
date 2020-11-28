#include <iostream>

int main(){

    int arr[50];

   std::cin >>arr[0] >>arr[1] >>arr[2];

   //while(std::cin >>arr[i])
    
    for(int i:arr)
        std::cout<<i <<" ";
    return 0;
    
}