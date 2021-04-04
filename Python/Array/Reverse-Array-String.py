def reverseIterative(arr):
    start = 0 
    end = len(arr) - 1 
    while start < end:
        arr[start], arr[end] = arr[end], arr[start]
        start += 1
        end -= 1

    return "".join(arr)

def reverseRecursive(arr,start,end):
    if start < end:
        arr[start], arr[end] = arr[end], arr[start]
        reverseRecursive(arr, start + 1, end -1)
    return "".join(arr)

array = input("Enter string or array : ")
array = list(array)
print("Reverse : ",reverseRecursive(array,0,len(array)-1))