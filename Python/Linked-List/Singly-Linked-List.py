# Creating a Node : Data + address of next node
class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

# This class will create a linked list
# and also contain all functions to perform
class LinkedList:

    # insert function will add new node at last
    def insert(self,head,new_data):
        # checking if linked list is empty
        if head == None:
            head = Node(new_data)

        # adding value at last            
        else:
            temp = head
            while temp.next != None:
                temp = temp.next
            temp.next = Node(new_data)
        return head


    # This function will add new node right after the node whose value is given by user
    def insertAfter(self,head,data,new_data):

        # checking if linked list is empty
        if head == None:
            print("\nThere is no existing data. First insert some value!\n")
        else:
            temp = head
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
        return head
   
    # This function delete that node whose value is given by user
    def deleteByValue(self,head,data):

        # checking if linked list is empty
        if head == None:
            print("\nCan't delete, Linked List is Empty !\n")
        else:
            # if the node to be deleted is head
            if head.data == data:
                del_node = head
                head = head.next            
                print("\n",del_node.data,"deleted successfully !\n")
                del del_node

            else:
                temp = head
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

        return head

    # This function prints all elements of Linked List
    def display(self,head):
        if head == None:
            print("\nLinked List is empty !\n")
        else:
            temp = head
            while temp != None:
                print(temp.data, end = " -> ")
                temp = temp.next
            print("None")
            
head1 = None            
list1 = LinkedList()
head1 = list1.insert(head1,20)
head1 = list1.insert(head1,30)
head1 = list1.insert(head1,40)
head1 = list1.insert(head1,50)
list1.display(head1)
head1 = list1.insertAfter(head1,40,45)
list1.display(head1)
head1 = list1.deleteByValue(head1,45)
list1.display(head1)