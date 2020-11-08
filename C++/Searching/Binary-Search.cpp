//Including header file for using common functionalities
#include <iostream>

//Declaring function defination, to let 
//compiler know that this function do exists
int Binary_Search(int arr[], int size, int key);
int rec_Binary_Search(int arr[], int left, int right, int key);


int main(){

    int arr[50], n, key;

    std::cout<< "Enter the size of your array : " ;
    std::cin >> n;

    std::cout<< "Enter the elements of your array : " ;
    for(int i=0; i<n; ++i)
        std::cin >>arr[i];

    std::cout<< "Enter the value to be search : ";
    std::cin >> key;

    int result = Binary_Search(arr,n,key);

    if(result == -1)
        std::cout<< key, " not exist!";
    else
        std::cout<< key << " found at index " << result;   
    return 0;
}

//Iterative approach for Binary-Search
int BinarySearch(int arr[], int size, int key){

    int left = 0;
    int right = size;
    while (left < right){

        int mid = (left + right) / 2;
        if(arr[mid] == key)
            return key;

        else if(arr[mid] < key)
            left = mid + 1;

        else
            right = mid - 1;       
    }

    return -1;
}

//Recursive approach for Binary-Search
int rec_Binary_Search(int arr[], int left, int right, int key){

    if(left <= right){

        int mid = (left + right)/2;

        if(arr[mid] == key)
            return mid;

        else if (arr[mid] > key)
            return rec_Binary_Search(arr,left, mid-1,key);
        
        else
            return rec_Binary_Search(arr,mid+1,right, key);       
    }
    return -1;
}