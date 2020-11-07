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

//Iterative approach for Linear-Search
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


//Recursive approach for Linear-Search
int rec_Linear_Search(int arr[], int first, int last, int key){

    if(first < last)
        return -1;
    
    else if(arr[first] == key)
        return first;

    else if(arr[last] == key)
        return last;
     
    rec_Linear_Search(arr,first + 1, last-1, key);

}