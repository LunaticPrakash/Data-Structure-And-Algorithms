def reverser(arr):

    start = 0
    for i in range(len(arr)):

        # When we reached the end of a word
        if arr[i] == " " or i == len(arr) - 1:

            end = i-1
            if i == len(arr)-1:
                end = i
            
            # now reverse the current word
            while start < end:
                arr[start], arr[end] = arr[end], arr[start]
                start += 1
                end -= 1
                
            # Go to the first character of next word
            start = i + 1

    return "".join(arr)

array = input("Enter string or array : ")
array = list(array)
print("Reverse : ",reverser(array))

            

