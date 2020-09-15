import math
#For sorting values in Buckets
def insertionSort(arr):
    for i in range(len(arr)):
        key = arr[i]
        j = i - 1

        while j>=0 and arr[j]>key:
            arr[j+1] = arr[j]
            j = j - 1
        arr[j+1] = key

    return arr


def bucketSort(a):
    n = len(a)  # number of buckets

    # Create n empty buckets where n is equal to the length of the input list
    buckets_list= []
    for i in range(n):
        buckets_list.append([]) 

    #inserting elements in their respective bucket
    for i in range(len(a)):
        bucket_index = int(n*a[i])
        buckets_list[bucket_index].append(a[i])


    # Sort individual buckets  
    for i in range(n): 
        buckets_list[i] = insertionSort(buckets_list[i]) 
  
    k = 0
    for i in range(n): 
        for j in range(len(buckets_list[i])): 
            a[k] = buckets_list[i][j] 
            k += 1

    return a

# Driver Code 
x = [0.1,0.545,0.543,0.2,0.25,0.30,0.9,0.2,0.2,0.3,0.4,0.5,0.56]  
 
sorted_array = bucketSort(x)
print("Sorted Array is \n",sorted_array)