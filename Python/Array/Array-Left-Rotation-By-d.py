import math
def LeftRotationOneTime(arr):

    if len(arr)>1:
        temp = arr[0]
        for i in range(1,len(arr)):
            arr[i-1] = arr[i]

        arr[i] = temp
    
def leftRotatebyd(arr, d): 
    for i in range(d): 
        LeftRotationOneTime(arr) 
    return arr
#######  More efficient algorithm ###########        

def rotateLeft(arr,d):

    n = len(arr)
    Gcd = math.gcd(n,d)
    for i in range(Gcd):

        temp = arr[i]
        j = i
        while 1:
            k = j + d
            if k>=n:
                k = k-n
            if k==i:
                break
            arr[j] = arr[k]
            j = k
        arr[j] = temp

    return arr

array = list(map(int,input("Enter your array (as space separated integers) : ").split()))
d = int(input("How many times you want to rotate? "))

a = leftRotatebyd(array,d)
print(a)
