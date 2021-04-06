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
                del_node = self.head
                self.head = self.head.next
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

    # This function displays the frequency of every elements           
    def FrequencyOfElements(self):
        # checking if linked list is empty
        if self.head == None:
            print("\nLinked List is empty!\n")
        else:
            d = {}
            temp1 = self.head
            while temp1 != None:
                if temp1.data in d:
                    d[temp1.data] += 1
                else:
                    d[temp1.data] = 1
                temp1 = temp1.next
            print(d)
            
                    
    # This function checks if there is loop in Linked List
    def checkLoop(self):
        ########Floyd’s Cycle-Finding Algorithm#########
        '''Traverse linked list using two pointers.Move one pointer
        slow by one and another pointer fast by two. If they become
        equal then loop exists'''
        slow = self.head
        fast = self.head

        while slow != None and fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                return True
        return False

    # This function reverses the Linked List
    def reverse_list(self) :

        if self.head == None or self.head.next == None:
            return
        pre = None
        curr = self.head
        nex = curr.next

        while curr != None:
            curr.next = pre
            pre = curr
            curr = nex

            if nex != None:
                nex = nex.next
        self.head = pre  

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
            

# driver code

my_list = LinkedList()

while True:
    print("\n1. Insert \n2. Delete \n3. Display \n4. Length of Linked List \n5. Searching \
        \n6. Sorting \n7. Extra Functions \n8. Exit \n")
    choice = int(input("Enter your choice :  "))

    if choice == 1:
        data = int(input("\nEnter data to insert : "))
        a = int(input("1. Insert in last \n2. Insert after a value \n"))
        if a == 1:
            my_list.insert(data)
            print("\nInserted Successfully!\n")
        elif a == 2:
            temp = int(input("Enter value after which", data, "is inserted : "))
            my_list.insertAfter(temp,data)
            print("\nInserted Successfully!\n")
        
    elif choice == 2:
        a = int(input("1. Delete by value \n2. Delete by index \n3. Delete Alternate Nodes \n"))
        if a == 1:
            data = int(input("\nEnter data to delete :  "))
            my_list.deleteByValue(data)
        elif a == 2:
            idx = int(input("\nEnter index to delete :  "))
            my_list.deleteByIndex(idx)
        elif a == 3:
            my_list.delAlternateNodes()
            print("\nAlternate Nodes deleted successfully\n")

    elif choice == 3:
        my_list.display()

    elif choice == 4:
        print("\nTotal elements in Linked List = ",my_list.length())

    elif choice == 5:
        data = int(input("\nEnter element to find : "))
        a = int(input("\n1. Linear Search \n2. Binary Search \n"))
        if a == 1:
            result = my_list.LinearSearch(data)
        elif a ==2:
            result = my_list.BinarySearch(my_list.head,None,data)
        if result == -1:
            print(data,"not found!\n")
        else:
            print(data,"found!\n")

    elif choice == 6:
        a = int(input("1. Bubble Sort \n2. Selection Sort \n"))
        if a == 1:
            my_list.BubbleSort()
        elif a == 2:
            my_list.SelectionSort()
        print("\nSorted Array is : ")   
        my_list.display()

    elif choice == 7:
        a = int(input("\n1. Frequency of Elements \n2. Reverse Linked List \n3. Detect Loop \n"))
        if a == 1:
            my_list.FrequencyOfElements()
        elif a == 2:
            my_list.reverse_list()
            print("\nReversed Linked List : - ")
            my_list.display()
        elif a == 3:
            loop = my_list.checkLoop()
            if loop == True:
                print("\nLoop exists!\n")
            else:
                print("\nLoop doesn't exists!\n")

    elif choice == 8:    
        break

    else:
        print("\nWrong Choice !\n")