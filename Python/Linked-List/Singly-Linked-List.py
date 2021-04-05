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
        if head == None:
            head = Node(new_data)
        else:
            temp = head
            while temp.next != None:
                temp = temp.next
            temp.next = Node(new_data)
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

head2 = None
list2 = LinkedList()
head2 = list2.insert(head2,29)
head2 = list2.insert(head2,39)
head2 = list2.insert(head2,49)
head2 = list2.insert(head2,59)
list2.display(head2)