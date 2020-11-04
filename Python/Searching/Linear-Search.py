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

array = list(map(int,input("Enter your array (as space separated integers) : ").split()))
value = int(input("Enter the value to be searched : "))

LinearSearch(array,value)
