def LeftRotationOneTime(arr,d):

    if len(arr)>1:
        temp = arr[0]
        for i in range(1,len(arr)):
            arr[i-1] = arr[i]

        arr[i] = temp
    


def leftRotateby(arr, d): 
    for i in range(d): 
        LeftRotationOneTime(arr, len(arr)) 


array = list(map(int,input("Enter your array (as space separated integers) : ").split()))
d = int(input("How many times you want to rotate? "))

leftRotateby(array,d)
print(array)
