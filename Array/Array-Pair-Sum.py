def check_array_pair(arr,k):

    if len(arr) < 2:
        return None
    
    else:
        
        seen = set()
        # sum = i + j
        # so we will assume each array element as i and
        # try to find if any matching j is available
        for i in range(len(arr)):
            j = k - arr[i]
            if j in seen:
                print("(",arr[i],",",j,")")
            seen.add(arr[i])

#Taking the input
array = list(map(int,input("Enter your array (as space separated integers) : ").split()))
k = int(input("Enter value of sum : "))
check_array_pair(array,k)