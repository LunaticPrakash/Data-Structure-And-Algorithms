#Prints only first occurence index of searched value
def LinearSearch(arr,value):
        for i in range(len(arr)):
            if value == arr[i]:
                return i
        return None

#Prints all occurence index of searched value
def LinearSearch1(arr,key): 
    flag = 0  
    for i in range(len(arr)):
        if value == arr[i]:
            print(value,"found at index",i)
            flag = 1
    if flag == 0:
        print("Not Found")

def rec_LinearSearch(arr,start,end,key):
    if start<=end:
        if arr[start] == key:
            return start
        elif arr[end] == key:
            return end
        else:
            return rec_LinearSearch(arr,start+1,end-1,key)

    return -1

array = list(map(int,input("Enter your array (as space separated integers) : ").split()))
value = int(input("Enter the value to be searched : "))

LinearSearch1(array,value)
# print(rec_LinearSearch(array,0,len(array)-1,value))
