# Creating a Node : Data + address of next node
class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

# This class will create a linked list
# and initialize it with a head = None
# It also contain all functions to perform
class LinkedList:
    
    # constructor to initialize linked list with a head
    def __init__(self):
        self.head = None

    # insert function will add new node at last
    def insert(self,new_data):
        if self.head == None:
            self.head = Node(new_data)
        else:
            temp = self.head
            while temp.next != None:
                temp = temp.next
            temp.next = Node(new_data)

    # This function will add new node right after the node whose value is given by user
    def insertAfter(self,data,new_data):

        # checking if linked list is empty
        if self.head == None:
            print("\nThere is no existing data. First insert some value!\n")
        else:
            temp = self.head
            while temp != None and temp.data != data:
                temp = temp.next

            # check if temp is at last node
            if temp == None:
                print(data,"doesn't exist !\n")
            else:
                # Now temp is pointing the node next to which insertion takes place 
                new_node = Node(new_data)
                new_node.next = temp.next
                temp.next = new_node

    # This function delete that node whose value is given by user
    def deleteByValue(self,data):

        # checking if linked list is empty
        if self.head == None:
            print("\nCan't delete, Linked List is Empty !\n")

        else:
            # if the node to be deleted is head
            if self.head.data == data:
                del_node = head
                head = head.next
                print("\n",del_node.data,"deleted successfully !\n")
                del del_node
                
            else:
                temp = self.head
                while temp.next != None and temp.next.data != data:
                    temp = temp.next
                
                # temp is at last node, and the node to be deleted is not yet found
                if temp.next == None:
                    print(data,"doesn't exist !\n")
                else:
                    # Here temp will point to the node which is just before the node
                    # to be deleted
                    del_node = temp.next
                    temp.next = del_node.next
                    print("\n",del_node.data,"deleted successfully !\n")
                    del del_node

# This function deletes node based on its index(0,1,2,3,...)
    def deleteByIndex(self,idx):
        # checking if linked list is empty
        if self.head == None:
            print("\nCan't delete, Linked List is Empty !\n")
            
        # if the node to be deleted is head        
        else:
            if idx == 0:
                del_node = self.head
                head = head.next
                print("\nIndex :",idx,"Value :",del_node.data,"deleted successfully!\n")
                del del_node
            else:
                temp = self.head
                for i in range(idx-1):
                    if temp.next != None:
                        temp = temp.next
                if temp.next == None or idx<0:
                    print("\nGiven index is out of range!\n")
                else:
                    # temp is previous to the node to be deleted
                    del_node = temp.next
                    temp.next = del_node.next
                    print("\nIndex :",idx,"Value :",del_node.data,"deleted successfully!\n")
                    del del_node
        

    # This function return total number of elements in Linked List        
    def length(self):
        if self.head == None:
            return 0
        else:
            count = 0
            temp = self.head
            while temp!=None:
                temp = temp.next
                count += 1
            return count

    # This function deletes alternate nodes like node 2,4,6,...
    def delAlternateNodes(self):

        # checking if linked list is empty
        if self.head == None:
            print("\nCan't delete, Linked List is Empty !\n") 
        
        elif self.length() == 1:
            print("\nCan't delete, Only 1 element!\n") 

        else:
            first = self.head # 1st node
            second = self.head.next # 2nd node
            while first != None and second != None:
                print("first :",first.data,"second :",second.data)
                first.next = second.next
                del second
                first = first.next

                if first != None:
                    second = first.next


    # This function linearly searches the key given by user

    ######Iterative Approach######
    def LinearSearch(self,key):

        # checking if linked list is empty
        if self.head == None:
            print("\nLinked List is empty!\n")
            return -1
        else:
            temp = self.head
            while temp != None:
                if temp.data == key:
                    return 1
                temp = temp.next
            return -1

    ######Recursive Approach######

    # def LinearSearch(self,start,key):
    #     # checking if linked list is empty
    #     if start == None:
    #         return -1
    #     else:
    #         temp = start
    #         if temp.data == key:
    #             return 1
    #         return self.LinearSearch(start.next,key)


    # This is helper function for BinarySearch()
    # It returns middle node of Linked List
    def middle(self,start,last):

        if start == None:
            return None
        
        slow = start
        fast = start.next
        
        while(fast != last):
            fast = fast.next
            if  fast != last:
                fast = fast.next
                slow = slow.next
        return slow
    
    # This function searches the key given by user by binary approach
    def BinarySearch(self,start,last,key):
        if start != None and start != last:
            mid = self.middle(start,last)

            if mid == None:
                return -1
            elif mid.data == key:
                return 1
            elif mid.data > key:
                return self.BinarySearch(start,mid,key)
            elif mid.data < key:
                return self.BinarySearch(mid.next,last,key)
        
        return -1

    # This function sorts the linked list based on data
    def BubbleSort(self):
        # checking if linked list is empty
        if self.head == None:
            print("\nLinked List is empty!\n")
        else:
            temp1 = self.head
            while temp1 != None:
                temp2 = self.head
                while temp2.next != None:
                    if temp2.data > temp2.next.data:
                        # swapping
                        temp2.data, temp2.next.data = temp2.next.data, temp2.data
                    temp2 = temp2.next
                temp1 = temp1.next

    # This function sorts the linked list based on data
    def SelectionSort(self):
        # checking if linked list is empty
        if self.head == None:
            print("\nLinked List is empty!\n")
        else:
            temp1 = self.head
            while temp1 != None:
                min_node = temp1
                temp2 = temp1.next
                while temp2!= None:
                    if min_node.data > temp2.data:
                        min_node = temp2
                    temp2 = temp2.next
                # swapping                        
                temp1.data, min_node.data = min_node.data, temp1.data
                temp1 = temp1.next

                

    # This function prints all elements of Linked List
    def display(self):
        if self.head == None:
            print("\nLinked List is empty !\n")
        else:
            temp = self.head
            while temp != None:
                print(temp.data, end = " -> ")
                temp = temp.next
            print("None")
            
           
list1 = LinkedList()
list1.insert(120)
list1.insert(30)
list1.insert(40)
list1.insert(0)
list1.insert(2)
list1.insert(0)
list1.display()
list1.insertAfter(40,-5)
list1.display()
list1.SelectionSort()
list1.display()
print("length =",list1.length())