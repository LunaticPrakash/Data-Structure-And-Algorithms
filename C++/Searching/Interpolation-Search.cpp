#include <iostream>

int Interpolation_Search(int arr[], int low, int high, int key);
int rec_Interpolation_Search(int arr[], int low, int high, int key);


int main(){

    int arr[50], n, key;

    std::cout<< "Enter the size of your array : " ;
    std::cin >> n;

    std::cout<< "Enter the elements of your array : " ;
    for(int i=0; i<n; ++i)
        std::cin >>arr[i];

    std::cout<< "Enter the value to be search : ";
    std::cin >> key;

    int result = rec_Interpolation_Search(arr,0,n-1,key);

    if(result == -1)
        std::cout<< key <<" not exist!";
    else
        std::cout<< key << " found at index " << result; 

    return 0;
}

int Interpolation_Search(int arr[], int low, int high, int key){

    while(low<=high && key >= arr[low] && key <= arr[high]){

        int pos = low + (int)((high-low)/(arr[high]-arr[low])) * (key-arr[low]);
        // int pos = low + (((double)(high - low) / (arr[high] - arr[low])) * (key - arr[low])); 
  
        std::cout<<"pos = " <<pos <<std::endl;
        std::cout<<"high - low = " <<high - low <<std::endl;
        std::cout<<"arr[high] - arr[low] = " <<arr[high] - arr[low] <<std::endl;

        std::cin.get();


        if(arr[pos] == key)
            return pos;

        else if(arr[pos] < key)
            low = pos+1;

        else
            high = pos - 1;
    }
    
    return -1;
}


//Recusrive approach
int rec_Interpolation_Search(int arr[], int low, int high, int key){


    if(low<=high && key >= arr[low] && key <= arr[high]){

        int pos = low + (int)(high-low)/(arr[high]-arr[low]) * (key-arr[low]);
        if(arr[pos] == key)
            return pos;

        else if(arr[pos] < key)
            return rec_Interpolation_Search(arr, pos+1,high,key);

        else
            return rec_Interpolation_Search(arr,low,pos-1,key);
    }

    return -1;
}