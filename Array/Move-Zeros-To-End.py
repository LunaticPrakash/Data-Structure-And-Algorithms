def moveZerosToEnd(arr):

    count = 0

    for i in range(len(arr)):
        #first move all non-zeros element to front
        if arr[i] != 0:
            arr[count] = arr[i]
            count += 1

    #now insert all 0    
    while count < len(arr):
        arr[count] = 0
        count += 1

    return arr

def moveZerosToEnd2(arr):
    count = 0
    for i in  range(len(arr)):

        if arr[i] != 0:
            arr[count], arr[i] = arr[i], arr[count]
            count += 1
    return arr


#driver code
array = list(map(int,input("Enter array (as space separated integers) : ").split()))
print(moveZerosToEnd2(array))