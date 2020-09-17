class DynamicArray:

    def __init__(self):
        self.current_index = 0
        self.capacity = 1
        self.array = self.make_array(self.capacity)

    #just to make len() works
    def __len__(self):
        return self.current_index

    #to get an item
    def getItem(self, index):
        if index < 0 and index > self.capacity:
            return IndexError("Index is out of bounds")
        else:
            return self.array[index]

    #to insert an value
    def add(self,value):
        if self.current_index == self.capacity:
            self._resize(2*self.capacity)

        self.array[self.current_index] = value
        self.current_index += 1


    #to print the array
    def display(self):
        for i in range(self.current_index):
            print(self.array[i],end=",")


    #to increase the array capacity when it's full
    def _resize(self,new_capacity):
        new_array = self.make_array(new_capacity)

        for i in range(self.current_index):
            new_array[i] = self.array[i]

        self.array = new_array
        self.capacity = new_capacity
        del new_array


    #to create an array
    def make_array(self,capacity):
        return (capacity * [0])



#driver code
arr = DynamicArray()

for i in range(10):
    #printing all relevant details
    print("Array = ", end="  ")
    arr.display()
    print("\nlen(arr) = ",len(arr))
    print("Capacity = ",arr.capacity)
    print("Current Index = ",arr.current_index)
    print("\n")
    arr.add(i)   #inserting element in array
