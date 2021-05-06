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

    def isLessPreced(self,i):
        precedence = {'+':1, '-':1, '*':2, '/':2, '^':3}
        try:
            a = precedence[i] 
            b = precedence[self.peek()]

            if a>b:
                return True
            else:
                return False
        except:
            return False 

    def infixToPostfix(self, exp):
        
        output = []
        # Iterate over the expression for conversion
        for i in exp:
            # If the character is an operand, 
            # add it to output
            if i.isalpha():
                output.append(i)
                
            # If the character is an '(', push it to stack
            elif i  == '(':
                self.help_stack.push(i)

            # If the scanned character is an ')', pop and 
            # output from the stack until and '(' is found
            elif i == ')':
                while( (not self.help_stack.isEmpty()) and self.help_stack.peek() != '('):
                    output.append(self.help_stack.pop())

                if not self.help_stack.isEmpty() and self.help_stack.peek() == '(':
                    self.help_stack.pop()
                else:
                    return -1
            # If the scanned character is an operator
            elif i == '+' or i == '-' or i == '*' or i == '/' or i == '%' or i == '^':
                while( (not self.help_stack.isEmpty()) and self.isLessPreced(i)):
                    output.append(self.help_stack.pop())
                self.help_stack.push(i)

        while not self.help_stack.isEmpty():
            output.append(self.help_stack.pop()) 

        return "".join(output)
    
    def evalPosfix(self,expr):
        for i in expr:
            if i.isnumeric():
                self.help_stack.push(i)
            else:
                val1 = int(self.help_stack.pop())
                val2 = int(self.help_stack.pop())

                ops = {'+':val2+val1, '-':val2-val1, '*':val2*val1, '/':val2/val1, '^':val2^val1}
                self.help_stack.push(ops.get(i))

        return self.help_stack.pop()

my_stack = Stack()       
oper = Operations()

while True:
    print("\n1. Push \n2. Pop \n3. Display \n4. Check Paranthesis \n5. Infix to Postfix \n6. Exit \n")
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
        expr = input("Enter your infix expression : ").split(" ")   
        print("Answer -> ",oper.evalPosfix(expr))     
    elif choice == 6:
        break
