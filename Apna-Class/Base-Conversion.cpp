#include<bits/stdc++.h>

void dec2bin(int num){
    int result[50],rem,i=0;

    while(num>0){
        rem = num%2;
        num /= 2;
        result[i] = rem;
        i += 1;
    }

    for(int j=i-1;j>=0;--j)
       std::cout<<result[j]<<" ";
}

long int mod_dec2bin(long int num){

    long int x = 1, result = 0;

    while (x<=num)
        x = x*2;
    x = x/2;

    while(x>0){
        int lastdigit = num/x;
        num = num%x;
        x = x/2;
        result = result*10 + lastdigit;
    }
    return result;
}

int mod_dec2oct(int num){

    int x=1, result=0;
    while(x<=num)
        x = x*8;
    x = x/8;

    while(x>0){
        int lastdigit = num/x;
        num = num%x;
        x = x/8;
        result = result*10 + lastdigit;
    }
    return result;
}

std::string mod_dec2hex(int num){

    int x=1;
    std::string result="";
    
    while(x<=num)
        x = x*16;
    x = x/16;

    while(x>0){
        int lastdigit = num/x;
        num = num%x;
        x = x/16;

        if(lastdigit<10)
            result = result + std::to_string(lastdigit);

        else{
            char c = 55 + lastdigit;
            result = result + c;
        }
    }
    return result;
}

int bin2dec(int num){

    int result=0,base=1;
    while(num>0){
        int digit = num%10;
        result = result + base*digit;
        base = base*2;
        num = num/10;
    }
    return result;
}

int oct2dec(int num){

    int result=0,base=1;
    while(num>0){
        int digit = num%10;
        result = result + digit*base;
        base = base*8;
        num = num/10;
    }
    return result;
}

int hex2dec(std::string num){

    int result=0,base=1;
    for(int i=num.size()-1;i>=0;--i){
        if(num[i]>='0' && num[i]<='9')
            result = result + (num[i]-'0')*base;
        else if(num[i]>='A' && num[i]<='F')
            result = result + (num[i]-'A'+10)*base;
        base = base*16;
    }
    return result;
}

int main(){

    int n;

    std::cout<<"Enter your number :  ";
    std::cin>>n;

    std::cout<<"Binary  =  "<< mod_dec2bin(n) <<std::endl;
    std::cout<<"Octal  =  "<< mod_dec2oct(n) <<std::endl;
    std::cout<<"Hexadecimal  =  "<< mod_dec2hex(n) <<std::endl;

    // std::cout<<"Binary to Decimal  =  "<< bin2dec(n) <<std::endl;
    // std::cout<<"Octal to Decimal  =  "<< oct2dec(n) <<std::endl;
    // std::cout<<"Hexadecimal to Decimal  =  "<< hex2dec(n) <<std::endl;
}