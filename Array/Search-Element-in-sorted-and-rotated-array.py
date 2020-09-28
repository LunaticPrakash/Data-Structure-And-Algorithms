def search(arr,low,high,key):

    if low <= high:
        mid = (low + high) //2

        if arr[mid] == key:
            return mid
        
        # if arr[0...mid] is sorted
        if arr[low] <= arr[mid]:

            if arr[low] < key < arr[mid] :
                return search(arr,low,mid-1,key)
            return search(arr,mid+1,high,key)
        
        #arr[mid...high] will be sorted
        if arr[mid+1] <= key <= arr[high]:
            return search(arr,mid+1, high,key)
        return search(arr,low,mid-1,key)

    return -1

array = list(map(int,input("Enter your array (as space separated integers) : ").split()))
value = int(input("Enter the value to be searched : "))

result = search(array,0,len(array)-1,value)

if result == -1:
    print("Not Found")
else:    
    print(value,"found at index", result)
        