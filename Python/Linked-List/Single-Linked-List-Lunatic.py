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
list1.insert(20)
list1.insert(30)
list1.insert(40)
list1.insert(50)
list1.display()
list1.insertAfter(40,45)
list1.display()
list1.deleteByValue(590)
list1.display()

list2 = LinkedList()
list2.insert(29)
list2.insert(39)
list2.insert(49)
list2.insert(59)
list2.display()