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

        
};

int main(){

    int choice = 0, data;
    int c,index,length,key,value;

    LinkedList list1;
    // Node* head = NULL;

    while (choice != 6){

    std::cout << "\n1. Insert" << "\n2. Delete" << "\n3. Display" 
                <<"\n4. Length of Linked List" <<"\n5. Searching" <<"\n6. Exit\n";
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
                break;

            case 6: 
                exit(0);
            
            default :
                std::cout << "\nWrong Choice!\n\n";
        }
    }

    return 0;

}