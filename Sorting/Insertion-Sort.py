def InsertionSort(arr):
    for i in range(1,len(arr)):
        j = i -1
        key = arr[i]

        # Moving elements of arr[0...i-1], which are greater than key
        # to one position ahead of their current position 
        while(j >=0 and arr[j]>key):
            arr[j+1] = arr[j]
            j = j-1
        #inserting key at it's correct position in sorted
        arr[j+1] = key

#Taking the input
array = list(map(int,input("Enter your array (as space separated integers) : ").split()))

#Passing array to the function
InsertionSort(array)

print(array)
