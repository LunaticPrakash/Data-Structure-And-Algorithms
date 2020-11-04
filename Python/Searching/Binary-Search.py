#######Iterative Method#########

#low = starting index = 0
#high = last index = len(arr)-1
def BinarySearch(arr,low,high,value):

    while low <= high:

        mid = (low+high)//2

        if arr[mid] == value:
            return mid

        elif arr[mid] > value:
            high = mid-1

        else:
            low = mid+1

    #if not found
    return -1


#####Recursive Method#########
def BinarySearch1(arr,low,high,value):

    if low <= high:
        mid = (low + high)//2

        if arr[mid] == value:
            return mid

        elif arr[mid] > value:
            return BinarySearch1(arr,low,mid-1,value)

        else:
            return BinarySearch1(arr,mid+1,high,value)
            
    #if not found
    return -1

array = list(map(int,input("Enter your array (as space separated integers) : ").split()))
value = int(input("Enter the value to be searched : "))

result = BinarySearch1(array,0,len(array)-1,value)

if result == -1:
    print("Not Found")
else:    
    print(value,"found at index", result)