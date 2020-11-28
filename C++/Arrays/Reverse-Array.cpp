#include <iostream>

// Iterative Approach
std::string Reverse(std::string str){

    int n = str.length()-1;
    for(int i=0; i<n/2; ++i)    
        std::swap(str[i], str[n-i]);
    
    return str;   
}

// Recursive Approach
std::string rec_Reverse(std::string str, int start, int end){

    if(start < end){
        std::swap(str[start], str[end]);
        return rec_Reverse(str, start+1, end-1);
    }

    return str;
}


int main(){

    std::string my_str, rev_str;

    std::cout << "Enter your string : ";
    // std::cin >> my_str;
    getline(std::cin,my_str);

    rev_str = rec_Reverse(my_str,0,my_str.length()-1);
    std::cout << "Reverse of String = " <<  rev_str ;
    return 0;
}