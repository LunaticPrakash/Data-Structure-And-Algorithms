def findMissing(arr1,arr2):
    miss_num = 0

    # 4 XOR 8 = 12 and 12 XOR 8 will give us 4 again 
    # so, we will use this concept as same numbers
    # will cancel out and missing one will be left.
    for i in range(len(arr1)):
        miss_num = miss_num ^ arr1[i]
        print(miss_num)

    for i in range(len(arr2)):
        miss_num = miss_num ^ arr2[i]
        print(miss_num)

    return miss_num

#Taking the input
array1 = list(map(int,input("Enter your array (as space separated integers) : ").split()))
array2 = list(map(int,input("Enter your array (as space separated integers) : ").split()))

missing_number = findMissing(array1,array2)
print("Missing Number = ",missing_number)