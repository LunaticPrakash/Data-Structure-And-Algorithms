#include <iostream>

void Selection_Sort(int arr[], int n);
void swap(int* a, int* b);

int main(){

    int arr[50], n;

    std::cout<< "Enter the size of your array : " ;
    std::cin >> n;

    std::cout<< "Enter the elements of your array : " ;
    for(int i=0; i<n; ++i)
        std::cin >>arr[i];

    Selection_Sort(arr,n);

    std::cout<< "Sorted array : " << std::endl;
    for(int i=0; i<n; ++i)
        std::cout << arr[i] << ",";

    return 0;
}

void Selection_Sort(int arr[], int n){

    for(int i=0; i<n; ++i){
        int min_idx = i;
        for(int  j=i+1; j<n; ++j){
            if (arr[min_idx] > arr[j])
                min_idx = j;
        }
    
        swap(&arr[i], &arr[min_idx]);
    }
}

void swap(int* a, int* b){

    int temp;

    temp = *a;
    *a = *b;
    *b = temp;
}
