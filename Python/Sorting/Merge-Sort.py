def mergesort(arr,l,r):

    if l<r:
        mid = (l+r)//2
        #Recursively splitting every sub-array until each has only 1 element
        mergesort(arr,l,mid)
        mergesort(arr,mid+1,r)

        merge(arr,l,mid,r)

def merge(arr,l,m,r):

    n1 = m-l+1
    n2 = r-m

    left = [0]*n1
    right = [0]*n2

    for i in range(n1):
        left[i] = arr[l+i]
    for j in range(n2):
        right[j] = arr[m+1+j]

    i = 0  #keep track of array B
    j = 0  #keep track of array C
    k = l  #keep track of array A

    # Comparing individual element of each sub array and merging them into
    # array arr in sorted order
    while(i<n1 and j<n2):
        if left[i] <= right[j]:
            arr[k] = left[i]
            i = i + 1
        
        else:
            arr[k] = right[j]
            j = j + 1
        
        k = k + 1
    
    # if any element is remaining in array left then insert
    # it in array arr directly as they are already sorted
    while (i<n1):
        arr[k] = left[i]
        k = k + 1
        i = i + 1

    # if any element is remaining in array right then insert
    # it in array arr directly as they are already sorted
    while (j < n2):
        arr[k] = right[j]
        k = k + 1
        j = j + 1
        

#driver (or main) code

#Taking the input
array = list(map(int,input("Enter your array (as space separated integers) : ").split()))

#Passing array to the function
mergesort(array,0,len(array)-1)

print(array)
