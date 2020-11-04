def rearrange(arr):

    for i in range(0,len(arr)):
        if arr[i] != -1 and arr[i] != i:
            x = arr[i]

            while arr[x] != -1 and arr[x] != x:

                # copy existing value so that we can store x
                # at its position
                y = arr[x]
                
                # inserting x at its correct position
                arr[x] = x

                # Now we have to find place for y
                # so make it equal to x and repeat prevoius steps
                x = y
            
            arr[x] = x

            # if no correct position is found
            if arr[i] != i:
                arr[i] = -1


arr = [-1, -1, 6, 1, 9, 3, 2, -1, 4, -1 ]
rearrange(arr)
print("\nFinal :",arr)