#include<iostream>
#include<math.h>

int reverse(int num){
    int rev=0,rem;
    while(num>0){
        rem = num%10;
        rev = rev*10+rem;
        num = num/10;
    }
    return rev;
}

bool armstrong(int num){

    int temp = num,c=0,digit,sum=0;
    while(temp>0){
        temp = temp/10;
        c = c + 1;
    }

    temp = num;
    while(num>0){
        digit = num%10;
        sum = sum + pow(digit,c);
        num = num/10;
    }

    if(temp == sum)
        return true;
    else    
        return false;
}

int main(){

    int n;

    std::cout<<"Enter your number :  ";
    std::cin>>n;
    std::cout<<"\nReverse = "<<reverse(n);
    std::cout<<"\nArmstrong Number  =  "<<armstrong(n);
    return 0;
}