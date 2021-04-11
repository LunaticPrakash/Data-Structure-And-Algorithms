class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class Stack:

    def __init__(self):
        self.top = None

    def isEmpty(self):
        return self.top == None

    def peek(self):
        return self.top.data
    
    def push(self,new_data):
        new_node = Node(new_data)
        if self.isEmpty():
            self.top = new_node
        else:
            new_node.next = self.top
            self.top = new_node
    
    def pop(self):
        if self.isEmpty():
            return None
        else:
            del_node = self.top
            self.top = self.top.next
            return del_node.data

    def display(self):
        if self.isEmpty():
            print("\nStack is empty!\n")
        else:
            temp = self.top
            while temp!= None:
                print(temp.data,end="->")
                temp = temp.next
            print("End")

class Operations():

    def __init__(self):
        self.help_stack = Stack()

    def isParanthesisBalanced(self,expr):
        open_sym = ['(','{','[']
        close_sym = [')','}',']']

        for i in expr:
            # if it is opening bracket
            if i in open_sym:
                self.help_stack.push(i)
            # if it is closing bracket                
            elif i in close_sym:
                # if no opening bracket is found yet
                if self.help_stack.isEmpty():
                    return False
                # pop the stack
                top_stack = self.help_stack.pop()
                # matching corresponding brackets
                if i == ')' and top_stack != '(':
                    return False
                elif i == '}' and  top_stack != '{':
                    return False
                elif i == ']' and top_stack != '[':
                    return False

        if self.help_stack.isEmpty():
            return True
        return False

    
my_stack = Stack()       
oper = Operations()

while True:
    print("\n1. Push \n2. Pop \n3. Display \n4. Check Paranthesis \n5. Exit \n")
    choice = int(input("Enter your choice :  "))

    if choice == 1:
        data = int(input("\nEnter data to insert : "))
        my_stack.push(data)
    elif choice == 2:
        print(my_stack.pop(),"deleted\n")
    elif choice == 3:
        print("\nStack ->\n")
        my_stack.display()
    elif choice == 4:
        expr = input("Enter your expression : ")
        if oper.isParanthesisBalanced(expr):
            print("\nParanthesis Balanced\n")
        else:
            print("\nParanthesis Not Balanced\n")            
    elif choice == 5:
        break
