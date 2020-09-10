#This is helper function to generate the fibonacci number 
def FiboGen(n):
    if n<0:
        return None
    elif n==0 or n==1:
        return n
    else:
        return FiboGen(n-1) + FiboGen(n-2)

    
def FibonacciSearch(arr,value):
    m = 0
    offset = -1

    #generating the smallest fibonaaci number which is greater than len(arr)
    while FiboGen(m) < len(arr):
        m = m + 1

    while (FiboGen(m)>1):
        i = min(FiboGen(m-2)+offset, len(arr)-1)

        if arr[i] > value:
            m = m - 2  #it eliminates almost two-third of array from rear(back) side
        
        elif arr[i] < value:
            m = m - 1   #it eliminates almost one-third of array from front side

        else:
            return i

    #For the one last remaining element checking if it is equal to the searched value
    if FiboGen(m-1) and arr[offset + 1] == value:
        return offset+1

    #if not found
    return -1


array = list(map(int,input("Enter your array (as space separated integer) : ").split()))
value = int(input("Enter the value to be searched : "))

result = FibonacciSearch(array,value)

if result == -1:
    print("Not Found")

else:
    print(value,"found at index", result)

