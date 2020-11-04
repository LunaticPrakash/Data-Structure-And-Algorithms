def hourglasssum(arr):
    
    # In a matrix total number of hour glass is (R-2)*(C-2)
    # row = len(arr) 
    # column = len(arr[0])

    if len(arr) < 3 or len(arr[0]) < 3:
        return 0

    curr_sum = 0
    max_sum = -63  # if -9 <= arr[i][j] <= 9

    for i in range(len(arr)-2):   
        for j in range(len(arr[0])-2): 
            curr_sum = (arr[i][j] + arr[i][j+1] + arr[i][j+2]) + \
                             (arr[i+1][j+1])  +  \
                  (arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2])

            max_sum = max(curr_sum,max_sum)

            #for printing each hourglass
            print(arr[i][j]," ",arr[i][j+1]," ",arr[i][j+2])
            print("   ",arr[i+1][j+1], "     = ", sum)
            print(arr[i+2][j], " ", arr[i+2][j+1], " ",arr[i+2][j+2])
            print("\n")


    print("Total Number pf HourGlass = ", (len(array)-2)*(len(array[0])-2))
    return max_sum


array = [ [1, 1, 1, 0, 0,0],
          [0, 1, 0, 0, 0,0],
          [1, 1, 1, 0, 0,0],
          [0, 0, 2, 4, 4,0],
          [0, 0, 0, 2, 0,0],
          [0, 0, 1, 2, 4,0]]
         
print("Maximum sum = ",hourglasssum(array))
