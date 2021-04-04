def partition(arr,start,end):

    pivot = arr[start]

    i = start
    j = end

    while i<=j:

        while arr[i] <= pivot and i<end:
            i = i+1
        
        while arr[j] > pivot:
            j = j-1
        
        if i<j:
            arr[i],arr[j] = arr[j],arr[i]
        else:
            break


def quick_sort(arr,start,end):

    if start < end:
        p = partition(arr,start,end)
        quick_sort(arr,start,p)
        quick_sort(arr,p+1,end)

array = [4,3,2,5,6,44,3,1,1,5,0]  
quick_sort(array,0,len(array)-1)
print(array)      