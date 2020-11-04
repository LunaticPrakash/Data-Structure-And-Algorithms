def SelectionSort(arr):
    for i in range(len(arr)):
        #Finding minimum element from remaining unsorted array
        min_idx = i  
        for j in range(i+1,len(arr)):
            if arr[min_idx] > arr[j]:
                min_idx = j
        
        #swapping
        arr[i], arr[min_idx] = arr[min_idx], arr[i]

#Taking the input
array = list(map(int,input("Enter your array (as space separated integers) : ").split()))

#Passing array to the function
SelectionSort(array)

print(array)