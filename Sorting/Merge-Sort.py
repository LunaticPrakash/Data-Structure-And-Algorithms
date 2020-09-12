def mergeSort(A):
    n = len(A)

    #splitting the array until each sub-array contains only 1 element
    if n > 1:
        mid = len(A)//2

        #splitting of arrays from mid
        B = A[0:mid]
        C = A[mid:]

        #Recursively splitting every sub-array until each has only 1 element
        mergeSort(B)
        mergeSort(C)

        i = 0  #keep track of array B
        j = 0  #keep track of array C
        k = 0  #keep track of array A

        # Comparing individual element of each sub array and merging them into
        # array A in sorted order
        while(i<len(B) and j<len(C)):
            if B[i] > C[j]:
                A[k] = C[j]
                j = j + 1
            
            else:
                A[k] = B[i]
                i = i + 1
            k = k + 1
        
        # if any element is remaining in array B then insert
        # it in array A directly as they are already sorted
        while (i<len(B)):
            A[k] = B[i]
            k = k + 1
            i = i + 1

        # if any element is remaining in array C then insert
        # it in array A directly as they are already sorted
        while (j < len(C)):
            A[k] = C[j]
            k = k + 1
            j = j + 1


#Taking the input
array = list(map(int,input("Enter your array (as space separated integers) : ").split()))

#Passing array to the function
mergeSort(array)

print(array)
