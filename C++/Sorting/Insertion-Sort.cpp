#include <iostream>

void Insertion_Sort(int arr[], int n);
void swap(int* a, int* b);

int main(){

    int arr[50], n;

    std::cout<< "Enter the size of your array : " ;
    std::cin >> n;

    std::cout<< "Enter the elements of your array : " ;
    for(int i=0; i<n; ++i)
        std::cin >>arr[i];

    Insertion_Sort(arr,n);

    std::cout<< "Sorted array : " << std::endl;
    for(int i=0; i<n; ++i)
        std::cout << arr[i] << ",";

    return 0;    
}

void Insertion_Sort(int arr[], int n){

    for (int i=1; i<n; i++){
        int temp = arr[i];
        int j = i-1;

        while(j>=0 && arr[j] > temp){
            arr[j+1] = arr[j];
            j --;
        }
        arr[j+1] = temp;
    }
}

void swap(int* a, int* b){

    int temp;

    temp = *a;
    *a = *b;
    *b = temp;
}
