######Iterative Approach###########
def interpolationSearch(arr,low,high,value):

    while low<=high:

        # Finding the optimal position to divide (or split) the array
        # The idea is to find the position closer to searched value
        pos = low + (high-low)//(arr[high]-arr[low]) * (value-arr[low])

        if arr[pos] == value:
            return pos
        
        elif arr[pos] < value:
            low = pos + 1

        else:
            high = pos - 1

    return -1


######Recursive Approach##########
def interpolationSearch1(arr,low,high,value):

    if low<=high:

        pos = low + (high-low) // (arr[high]-arr[low]) * (value-arr[low])

        if arr[pos] == value:
            return pos

        elif arr[pos] < value:
            return interpolationSearch1(arr, pos+1,high,value)

        else:
            return interpolationSearch1(arr, low, pos-1,value)

    return -1



#driver code
array = list(map(int,input("Enter your array (as space separated integers) : ").split()))
value = int(input("Enter the value to be searched : "))

result = interpolationSearch(array,0, len(array)-1,value)

if result == -1:
    print("Not Found")
else:    
    print(value,"found at index", result)