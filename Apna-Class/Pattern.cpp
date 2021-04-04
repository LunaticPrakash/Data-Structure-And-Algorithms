#include<iostream>

void rectangular_pattern(int row, int column, std::string pattern){

    for(int i=0;i<row;++i){
        for(int j=0;j<column;++j)
            std::cout<<pattern << "  ";
        std::cout<<"\n\n";
    }
}

void hollow_rectangular_pattern(int row, int column, std::string pattern){

    for(int i=0;i<row;++i){
        for(int j=0;j<column;++j){
            if(i == 0 || i == row-1 || j == 0 || j == column - 1)
                std::cout<<pattern << "  ";
            else
                std::cout<< "   ";
        }
        std::cout<<"\n\n";
    }
}


void inverted_half_pyramid(int n,std::string pattern){

    for(int i = 0; i <= n; ++i){
        for(int j=0; j<n-i; j = j+1)
            std::cout<<pattern << "  "; 
        std::cout << "\n\n";
    
    }
}

void right_lower_triangle_pyramid(int row,std::string pattern){

    for(int i=0;i<row;++i){
        for(int j=0; j<row; ++j)
            if(i+j >= row-1)
                std::cout<<pattern << "  ";
            else
                std::cout<<"   ";
        std::cout<<"\n\n";
    }

}


void left_lower_triangle_pyramid(int row,std::string pattern){

    for(int i=0;i<row;++i){
        for(int j=0; j<row; ++j)
            if(i>=j)
                std::cout<<pattern << "  ";
            else
                std::cout<<"   ";
        std::cout<<"\n\n";
    }

}

void butterfly_pattern(int row, std::string pattern){

    for(int i =0; i<row; ++i){
        for(int j=0; j<=i; ++j)
            std::cout<< pattern;
        
        int space = 2*row-2*i;
        for(int j=0; j<=space; ++j)
            std::cout<<" ";

        for(int j=0; j<=i; ++j)
            std::cout<< pattern;
        
        std::cout<< std::endl;
    }

    for(int i =row-1; i>0; --i){
        for(int j=0; j<=i; ++j)
            std::cout<<pattern;
        
        int space = 2*row-2*i;
        for(int j=0; j<=space; ++j)
            std::cout<<" ";

        for(int j=0; j<=i; ++j)
            std::cout<<pattern;
        
        std::cout<< std::endl;
    }
}

void number_pattern(int row){

    for(int i=0;i<row;++i){
        for(int j=1; j<=row-i;++j)
            std::cout<<j<<"  ";
        std::cout<<"\n\n";
    }
}

void binary_pattern(int row){

    for(int i=0;i<row;++i){
        int count = 0;
        for(int j=0;j<=i;++j)
            (i+j)%2==0 ? std::cout<<"1  " : std::cout<<"0  ";   
        std::cout<<"\n\n"; 
    }
}

void rhombus_pattern(int row, std::string pattern){

    for(int i=0;i<row;++i){
        for(int j=0;j<row-i;++j)
            std::cout<<"  ";
        for(int j=0;j<row;++j)
            std::cout<<pattern<< "  ";

        std::cout<<"\n\n";
    }
}

void number_heap_pattern(int row){

    for(int i=1;i<=row;++i){
        for(int j=0;j<row-i;++j)
            std::cout<<"  ";
        for(int j=1;j<=i;++j)
            std::cout<<j<<"  ";
        std::cout<<"\n\n";
    }
}

void palindromic_pattern(int row){
    for(int i=1;i<=row;++i){
        for(int j=1;j<row-i;++j)
            std::cout<<" ";
        for(int j=i;j>=1;--j)
            std::cout<<j;
        for(int j=2;j<=i;++j)
            std::cout<<j;
        std::cout<<"\n\n";
    }
}

void diamond_pattern(int row, std::string pattern){

    for(int i=0;i<row;++i){
        for(int j=0;j<row-i;++j)
            std::cout<<"  ";
        
        for(int j=0;j<2*i-1;++j)
            std::cout<<pattern<<" ";
        
        std::cout<<"\n\n";
    }

    for(int i=row-1;i>=0;--i){
        for(int j=0;j<row-i;++j)
            std::cout<<"  ";
        
        for(int j=0;j<2*i-1;++j)
            std::cout<<pattern<<" ";
        
        std::cout<<"\n\n";
    }
}

void zig_zag_pattern(int row,int column, std::string pattern){

    for(int i=1; i<=row; ++i){
        for(int j=1; j<=column;++j){
            if(((i+j)%4==0) || (i%2==0 && j%4==0)){
                std::cout<<pattern<<" ";
            }
            else{
                std::cout<<"  ";
            }
        }
        std::cout<<std::endl;
    }
}

int fact(int n){

    if(n<0)
        return -1;

    else if(n==0 || n==1)
        return 1;
    
    else
        return n*fact(n-1);
}

int cal_ncr(int n,int r){
    return fact(n)/(fact(n-r)*fact(r));
}
void pascal_triangle(int row){

    for(int i=0;i<row;++i){
        for(int j=0;j<=i;++j)
            std::cout<<cal_ncr(i,j)<<"  ";
        std::cout<<"\n";
    }
}

int main(){

    int row,column,choice;
    std::string pattern;

    std::cout << "Enter number of rows :  ";
    std::cin >> row;
    std::cout << "Enter number of column :  ";
    std::cin >> column;
    std::cout << "Enter element/pattern :  ";
    std::cin >> pattern;
    std::cout << "\n\n";

    std::cout << "1. Rectangular Pattern \n2. Hollow Rectangular Pattern\n";
    std::cout << "3. Inverted Half Pyramid \n4. Right Lower Triangle Pyramid\n";
    std::cout << "5. Left Lower Triangle Pyramid\n6. Butterfly Pattern\n";
    std::cout << "7. Number Pattern\n8. Binary Pattern\n9. Rhombus Pattern\n";
    std::cout << "10. Number Heap Pattern\n11. Palindromic Pattern\n12. Diamond Pattern\n";
    std::cout << "13. Zig Zag Pattern\n14. Pascal Triangle\n";

    std::cout<<"\n\nEnter your choice :  ";
    std::cin>>choice;

    if(choice == 1)
        rectangular_pattern(row,column,pattern);
    
    else if(choice == 2)
        hollow_rectangular_pattern(row,column,pattern);

    else if(choice == 3)
        inverted_half_pyramid(row,pattern);
    
    else if(choice == 4)
        right_lower_triangle_pyramid(row,pattern);

    else if(choice == 5)
        left_lower_triangle_pyramid(row,pattern);

    else if(choice == 6)
        butterfly_pattern(row,pattern);

    else if(choice == 7)
        number_pattern(row);

    else if(choice == 8)
        binary_pattern(row);
    
    else if(choice == 9)
        rhombus_pattern(row,pattern);

    else if(choice == 10)
        number_heap_pattern(row);
    
    else if(choice == 11)
        palindromic_pattern(row);
    
    else if(choice == 12)
        diamond_pattern(row,pattern);
    
    else if(choice == 13)
        zig_zag_pattern(row,column, pattern);

    else if(choice == 14)
        pascal_triangle(row);

    return 0;
}