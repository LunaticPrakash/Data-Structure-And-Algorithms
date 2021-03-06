#include <iostream>

// Creating a Node : Data + address of next node
class Node{

    public:
        int data;
        Node* next;
};

// This class will create a linked list
// and initialize it with a head = NULL
// It also contain all functions to perform
class LinkedList{

    // Making every field/function public so that
    //it can be modified via other functions
    public:
        Node* head;

        // constructor to initialize empty linked list
        LinkedList(){
            head = NULL;
        }

        // insert function will add new node at last
        Node* insert(Node* head, int new_data){

            // First create the new node with data given
            Node* new_node = new Node();
            new_node -> data = new_data;
            new_node -> next = NULL;

            // checking if linked list is empty
            if(head == NULL)
                head = new_node;
            
            // adding value at last
            else{
                Node* ptr = head;
                while(ptr->next!=NULL)
                    ptr = ptr -> next;
            ptr -> next = new_node;
            }

        return head;           
        }

        // This function will add new node right after the node whose value is given by user
        Node* insertAfter(Node* head, int new_data, int data){

            // checking if linked list is empty
            if(head == NULL)
                std::cout << "\nThere is no existing data. First insert some value!\n";
            
            else{
                // First create the new node with data given
                Node* new_node = new Node(); 
                new_node -> data = new_data;
                new_node -> next = NULL;

                Node* ptr = head;
                while(ptr->next!=NULL && ptr -> data != data)
                    ptr = ptr -> next;
                
                //Now ptr is pointing the node next to which insertion takes place

                if(ptr->next == NULL) //check if ptr is at last node
                    ptr->next = new_node;

                else if(ptr-> data != data) //when data doesn't matches any existing value
                    std::cout << "\nGiven Value doesn't exist! \n";
                
                else{
                //inserting new node next to the ptr
                new_node -> next = ptr -> next;  
                ptr -> next = new_node; 
                }
            }
            return head;
        }

        // This function delete that node whose value is given by user
        Node* deleteByValue(Node* head, int data){

            // checking if linked list is empty
            if(head == NULL)
                std::cout << "\nLinked List is empty!\n";
            
            // if the node to be deleted is head
            else if(head->data == data){
                std::cout << head->data << " deleted successfully!\n\n";
                head = head->next;
            }

            else{
                Node* ptr = head; 
                while(ptr->next!=NULL && ptr->next->data != data)
                    ptr = ptr -> next;
                
                // now ptr will point to the node which is just before the node
                // to be deleted

                // ptr is at last node, and the node to be deleted is not yet found
                if(ptr->next == NULL)
                    std::cout << data << " don't exist!\n\n";

                else{
                    Node* temp = ptr -> next;  //temp is the node to be deleted
                    ptr->next = temp->next; 
                    std::cout << temp->data << " deleted successfully!\n\n";
                    delete temp;
                }
            }
            return head;            
        }

        // This function deletes node based on its index(0,1,2,3,...)
        Node* deleteByIndex(Node* head, int idx){

            Node* temp;
            Node* ptr;

            // checking if linked list is empty
            if(head == NULL)
                std::cout << "\nLinked List is empty!\n";

            // if the node to be deleted is head
            else if(idx == 0){
                temp = head;
                head = head -> next;
                std::cout << temp->data << " deleted successfully!\n\n";
                delete temp;
            }

            else{
                temp = head;
                for(int i=0; temp->next !=NULL && i < idx-1; i++)
                    temp = temp -> next; 

                // now temp will point to the node which is just before the node
                // to be deleted

                //checking if given index is valid or not
                if(temp == NULL || temp->next == NULL || idx < 0)    
                    std::cout << "Given index don't exist!\n\n";
                     
                else{
                    ptr = temp -> next;  //ptr is the node to be deleted
                    temp->next = ptr-> next;
                    std::cout << ptr->data << " deleted successfully!\n\n";
                    delete ptr;
                }
            }

            return head;
        }

        // This function return total number of elements in Linked List
        int Length(Node* head){

        /*****Iterative Approach******/
            int count = 0;

            Node* temp = head;
            while(temp!=NULL){
                temp = temp -> next;
                count++;
            }
            return count;

        /*****Recursive Approach******/
            // Node* temp = head;
            // if(temp == NULL)
            //     return 0;
            
            // return 1 + Length(temp->next);
        }

        // This function deletes alternate nodes like node 1,3,5,7,...
        Node* deleteAltNodes(Node* head){

            Node* temp = head;  //0th node
            Node* ptr = head->next;  //1st node(alternate node)
            while(ptr != NULL && temp!= NULL){
                temp->next = ptr->next;
                delete ptr;
                temp = temp->next;

                if(temp!=NULL)
                    ptr = temp->next;
            }
            return head;
        }

        // This function prints all elements of Linked List
        void display(Node* head){

            // checking if linked list is empty
            if(head == NULL)
                std::cout << "\nLinked List is empty!\n\n";

            else{
                std::cout << "\nYour Linked List :- " << std::endl;
                Node* ptr = head;
                while(ptr !=NULL){
                    std::cout << ptr -> data << "  ";
                    ptr = ptr -> next;
                }
            }            
        }

        // This function linearly searches the key given by user
        int LinearSearch(Node* head, int key){

            /***********Iterative Approach**************/
            if(head == NULL){
                std::cout << "\nLinked List is empty!\n\n";
                return -1;
            }
            
            else{
                Node* temp = head;
                while(temp != NULL){
                    if(temp->data == key)
                        return 1;
                    temp = temp->next;
                }
                return -1;
            }

            /*********Recursive Approach***********/
            // Node* temp = head;
            // if(temp == NULL)
            //     return -1;
            
            // if(temp->data == key)
            //     return 1;
            
            // return LinearSearch(temp->next,key);
        }

        // This is helper function for BinarySearch()
        // It returns middle node of Linked List
        Node* middle(Node* start,Node* last){

            if(start == NULL)
                return NULL;

            Node* slow = start;
            Node* fast = start->next;

            while(fast != last){
                fast = fast->next;

                if(fast!= last){
                    slow = slow->next;
                    fast = fast->next;
                }
            }
            std::cout<<"Middle data = " << slow->data<< std::endl;
            std::cin.get();
            return slow; 
        }

        // This function searches the key given by user by binary approach
        int BinarySearch(Node* head, int key,Node* last){

            Node* start = head;

            if(last == NULL || start != last){                
                Node* mid = middle(start,last);

                if(mid == NULL)
                    return -1;

                else if(mid->data == key)
                    return 1;

                else if(mid->data > key)
                    return BinarySearch(start,key, mid);

                else
                    return BinarySearch(mid->next,key,last);

            }
            return -1;
        }

        // This function sorts the linked list based on data
        Node* BubbleSort(Node* head) {
            
            Node* ptr1 = head;
            int temp,swap;

            while(ptr1 != NULL){
                Node* ptr2 = head;
                swap=0; 
                while(ptr2->next!=NULL)
                {
                    if(ptr2->data > ptr2->next->data){
                        //swapping
                        temp = ptr2->next->data;
                        ptr2->next->data = ptr2->data;
                        ptr2->data = temp;
                        swap = 1;  //swap takes place
                    }
                    ptr2 = ptr2->next;
                }
                if(swap == 0)  //if no swap happens break the loop
                    break;
                ptr1 = ptr1->next;
            }
            return head;
        }

        // This function sorts the linked list based on data
        Node* SelectionSort(Node* head){

            int temp;
            for(Node* ptr1=head; ptr1->next!= NULL; ptr1=ptr1->next){
                Node* min_node = ptr1;
                for(Node* ptr2= ptr1->next; ptr2 != NULL; ptr2 = ptr2->next){
                    if(min_node->data > ptr2->data)
                        min_node = ptr2;
                }
                //swapping
                temp = min_node->data;
                min_node->data = ptr1->data;
                ptr1->data = temp;
            }
            return head;
        }

        // This function displays the frequency of every elements
        void FreqofElements(Node* head){
            
            Node* ptr1 = head;
            while(ptr1 != NULL){
                int count = 1;
                Node* ptr2 = ptr1->next;
                while(ptr2!=NULL){
                    if(ptr1->data == ptr2->data)
                        count++; 
                    ptr2 = ptr2->next;                   
                }
                std::cout<< "\n" <<ptr1->data << " founds " << count << " times\n";
                while(ptr1->next != NULL && ptr1->next->data == ptr1->data)
                    ptr1 = ptr1->next;
                ptr1 = ptr1->next;
            }
        }

        // This function checks if there is loop in Linked List
        bool checkLoop(Node* head){

            /*******Floyd’s Cycle-Finding Algorithm******/
            /*Traverse linked list using two pointers.Move one pointer
            slow by one and another pointerfast by two. If they become
            equal then loop exists*/

            Node* slow = head;
            Node* fast = head;

            while(slow!=NULL && fast!=NULL && fast->next!=NULL){
                slow = slow->next;
                fast = fast->next->next;
                if(slow == fast)            
                    return true;
            }
            return false;
        }

        // This function reverses the Linked List
        Node* reverse(Node* head){
            Node* pre = NULL;
            Node* curr = head;
            Node* next = curr->next;

            while(curr != NULL){
                curr->next = pre;
                pre = curr;
                curr = next;

                if(next!=NULL)
                    next = next->next;
            }
            return pre;
        }

        
};

int main(){

    int choice = 0, data;
    int c,index,length,key,value;

    LinkedList list1;
    // Node* head = NULL;

    while (choice != 8){

    std::cout << "\n1. Insert" << "\n2. Delete" << "\n3. Display" 
                <<"\n4. Length of Linked List" <<"\n5. Searching" <<
                "\n6. Sorting" << "\n7. Extra Functions" <<"\n8. Exit\n";

    std::cout << "Enter your choice :  ";
    std::cin >> choice;

        switch(choice){

            case 1: 
                std::cout << "\nEnter data to insert : ";
                std::cin >> data;
                std::cout << "1. Insert in last\n" << "2. Insert after a value\n" ;
                std::cin >> c ;
                if(c == 1)
                    list1.head = list1.insert(list1.head,data);
                    
                else if(c == 2){
                    std::cout << "Enter value after which " << data << " is inserted : ";
                    std::cin >> value;
                    list1.head = list1.insertAfter(list1.head, data,value);
                }
                break;

            case 2: 
                std::cout << "1. Delete by value\n" << "2. Delete by index\n" 
                            <<"3. Delete Alternate Nodes\n";
                std::cin >> c ;
                if(c == 1){
                    std::cout << "\nEnter data to delete :  ";
                    std::cin >> data;
                    list1.head = list1.deleteByValue(list1.head,data);
                }
                else if(c == 2){
                    std::cout << "\nEnter index to delete :  ";
                    std::cin >> index;
                    list1.head = list1.deleteByIndex(list1.head, index);
                }

                else if(c==3){
                    list1.head = list1.deleteAltNodes(list1.head);
                    std::cout << "\nAlternate Nodes deleted successfully\n";
                }
                break;

            case 3:
                list1.display(list1.head);
                break;  

            case 4:
                length = list1.Length(list1.head);
                std::cout << "\nTotal elements in Linked List = " << length <<std::endl;
                break;

            case 5: 
                std::cout <<"\n\nEnter element to find : ";
                std::cin >> key;
                std::cout << "\n1. Linear Search\n" << "2. Binary Search\n" ;
                std::cin >> c;

                if(c==1){
                    int result =  list1.LinearSearch(list1.head, key);
                    if(result == 1)
                        std::cout<< key << " found!\n\n";
                    else
                         std::cout<< key << " not found!\n";                       
                }

                else if(c==2){
                    int result = list1.BinarySearch(list1.head,key,NULL);
                    if(result == 1)
                        std::cout<< key << " found!\n\n";
                    else
                         std::cout<< key << " not found!\n"  ;  
                }                  
                break;

            case 6: 
                std::cout << "1. Bubble Sort\n" << "2. Selection Sort\n";
                std::cin >> c;

                if(c==1){
                    list1.head = list1.BubbleSort(list1.head);
                    std::cout << "\nSorted Array is : ";
                    list1.display(list1.head);
                }
                else if(c==2){
                    list1.head = list1.SelectionSort(list1.head);
                    std::cout << "\nSorted Array is : ";
                    list1.display(list1.head);
                }

            case 7:
                std::cout << "1. Frequency of Elements\n" << "2. Reverse Linked List\n"
                            <<"3. Detect Loop\n";
                std::cin >> c;

                if(c==1)
                    list1.FreqofElements(list1.head);

                else if(c==2){
                    list1.head = list1.reverse(list1.head);
                    std::cout<< "\nReversed Linked List :  ";
                    list1.display(list1.head);
                }
                                
                else if(c=3){
                    bool loop = list1.checkLoop(list1.head);
                    if(loop)
                        std::cout<<"\nLoop exists\n";
                    else
                        std::cout<<"\nLoop don't exists\n";
                }

                break;

            case 8: 
                exit(0);
            
            default :
                std::cout << "\nWrong Choice!\n\n";
        }
    }

    return 0;

}