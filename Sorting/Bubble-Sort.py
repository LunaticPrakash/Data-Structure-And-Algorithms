######Simple Approach########
def BubbleSort(arr):
    n = len(arr)
    for i in range(n-1):   #no need to check for last element as it will be already in correct place just after first iteration
        for j in range(n-1-i):  #ith element will be in correct position so, do not compare them
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]   #swapping
    

#####Optimized Approach######
def BubbleSort1(arr):
    n = len(arr)
    for i in range(n-1):
        swapped = False          
        for j in range(n-1-i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = True

        #If no swapping takes place in inner loop, means array is already sorted, so exit the loops
        if swapped == False:          
            break


#Taking the input
array = list(map(int,input("Enter your array (as space separated integers) : ").split()))

#Passing array to the function
BubbleSort1(array)

print(array)