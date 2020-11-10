#include <iostream>

void Bubble_Sort(int arr[], int n);
void opt_Bubble_Sort(int arr[], int n);
void swap(int* a, int* b);

int main(){

    int arr[50], n;

    std::cout<< "Enter the size of your array : " ;
    std::cin >> n;

    std::cout<< "Enter the elements of your array : " ;
    for(int i=0; i<n; ++i)
        std::cin >>arr[i];

    opt_Bubble_Sort(arr,n);

    std::cout<< "Sorted array : " << std::endl;
    for(int i=0; i<n; ++i)
        std::cout << arr[i] << ",";
        
    return 0;

}

void Bubble_Sort(int arr[], int n){

    for (int i=0; i<n; ++i)
        for (int j=0; j<n-1-i; ++j)
            if (arr[j] > arr[j+1])
                swap(&arr[j], &arr[j+1]);
}

void opt_Bubble_Sort(int arr[], int n){

    for (int i=0; i<n; ++i){

        bool swapped = false;
        for(int j=0; j<n-i; ++j){
            if(arr[j] > arr[j+1]){
                swap(&arr[j], &arr[j+1]);
                swapped = true;
            }
        }
        if (swapped == false)    
            break;
    }
}

void swap(int* a, int* b){

    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}
