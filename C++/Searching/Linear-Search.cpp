//Including header file for using common functionalities
#include <iostream>

//Declaring function defination, to let 
//compiler know that this function do exists
void Linear_Search(int [], int , int );

int main(){

    int arr[50];
    int n, key;

    std::cout << "Enter the size of your array : " << std::endl;
    std::cin >> n;
    std::cout << "Enter your array elements : " << std::endl;

    //Inputting array
    for(int i=0; i < n; ++i)
        std::cin >>  arr[i];

    std::cout << "Enter value to search : ";
    std::cin >> key;

    Linear_Search(arr,n,key);

    return 0;
}

//Body of the declared function
void Linear_Search(int arr[], int size, int key){

    int flag = 0;

    for(int i=0; i<size; ++i)
        if (arr[i] == key){
            std::cout<< key << " found at index " << i << std::endl;
            flag = 1;
        }

    if(flag == 0)
        std::cout << key << " not found !" << std::endl;    
}