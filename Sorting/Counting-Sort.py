#Works for positive numbers only
def countingSort(arr):

    #finding maximum element of array
    max_element = max(arr)

    # creating two helper array with initial values as 0
    # count_arr will store frequency and then cummulative frequency 
    # of each element in array
    #output_arr will contain our final sorted array
    count_arr = [0 for i in range(max_element+1)]
    output_arr = [0 for i in range(len(arr))]


    #storing frequency/count of each element of inputted array into count_arr
    for i in range(len(arr)):
        count_arr[arr[i]] += 1


    #calculating cumulative frequqncy and storing it in count_arr
    for i in range(1,len(count_arr)):
        count_arr[i] = count_arr[i] + count_arr[i-1]


    #loop from last value to first value in unsorted array
    for i in range(len(arr)-1,-1,-1):
        element = arr[i]
        #getting the correct postion for storing that element in sorted form
        position = count_arr[element] 
        output_arr[position - 1] = element  #storing the value in sorted array
        count_arr[element] = count_arr[element] - 1 #updating the cumulative frequency in count_arr

    #returning sorted array
    return output_arr

#driver code

#Taking the input
array = list(map(int,input("Enter your array (as space separated integers) : ").split()))

#Passing array to the function
sorted_array = countingSort(array)

print(sorted_array)