# Function for nth Fibonacci number
import matplotlib.pyplot as plt 
import time 
import math
import numpy as np

def rec_Fibonacci(n):

	if n<0:
		print("Incorrect input")
	# First Fibonacci number is 0
	elif n==0:
		return 0
	# Second Fibonacci number is 1
	elif n==1:
		return 1
	else:
		return rec_Fibonacci(n-1)+rec_Fibonacci(n-2)

def dp_fibonacci(n):
	f = [0, 1]
	for i in range(2, n+1):
		f.append(f[i-1] + f[i-2])
	return f[n]

def op_fibo(n):
    phi = (1 + math.sqrt(5)) / 2
 
    return round(pow(phi, n) / math.sqrt(5))	


# Driver Program
times1 = []
times2 = []
elements=[]
for i in range(1, 34): 

	a = i  
	# start = time.time() 
	# rec_Fibonacci(a) 
	# end = time.time()

	elements.append(a) 
	# times1.append(end-start) 

	start = time.time() 
	dp_fibonacci(a) 
	end = time.time()  

	times2.append(end-start) 

	print("Sorted list is ", a) 
	print("for a = ",a,"calculated in", end-start) 

plt.xlabel('Number') 
plt.ylabel('Time Complexity') 
# plt.plot(elements, times2, label ='DP-Fibonaaci') 
plt.plot(elements, times1, label ='Rec-Fibonaaci') 
plt.grid() 
plt.legend() 
plt.show() 


def FindNumbersDivisibe(a,b,div):

	mylist = []
	for i in range(a,b+1):
		if i%div==0:
			mylist.append(i)
	return len(mylist)

result = FindNumbersDivisibe(14,80,7)
print(result)

def abc(ax,ay,bx,by):
	da = ax**2 + ay**2
	db = bx**2 + by**2

	if(da>db):
		return db
	else:
		return da

count = {}
list = str.split()

for i in list:
	if i in count:
		count[i] += 1
	else:
		count[i] = 1
	
result = sorted(count,key=lambda x:X[1], reverse=True)
return result[0][0]

class Node:
 
    # Constructor to initialize the node object
    def __init__(self, data=None):
        self.data = data
        self.next = None

def addTwoNumbers(list1,list2):

	carry = 0
	head = None
	prev = None
	while(list1 != None and list2 != None):

		if(list1.data != None):
			digit1 = list1.data
		else:
			digit1 = 0

		if(list2.data != None):
			digit2 = list1.data
		else:
			digit2 = 0
		
		sum = carry + digit1 + digit2

		if sum >=10:
			carry = 1
			sum = sum % 10
		else:
			carry = 0
		

		new_node = Node(sum)
		
		if(head==None):
			head = new_node
		else:
			prev.next = new_node

		prev = new_node

		if list1 is not None:
			list1 = list1.next
		if list2 is not None:
			list2 = list2.next

	if carry > 0:
		new_node.next = Node(carry)


def printList(self):
        temp = self.head
        while(temp):
            print temp.data,
            temp = temp.next
 