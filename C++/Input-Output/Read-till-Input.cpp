#include <iostream>
#include <string>
#include <vector>
#include <sstream>

int main()
{

    int arr[10], b, c, d;

    // Taking single input
    std::cout <<"Enter single input : "<<std::endl;
    std::cin>>b;
    std::cout <<"Output = " <<b << std::endl;

    //Taking multiline input or multiple input on the same line when no. of inputs is known
    std::cout <<"Enter 3 input (either space separated or on new line) : "<<std::endl;
    std::cin>>b >> c >> d;
    std::cout << "Output = " << b << c << d;
    
    // Inputting array on same line
    std::cout <<"\nEnter input  for array(either space separated or on new line) : "<<std::endl;
    for(int i=0;i<8;i++){
        std::cin>>arr[i];
    }

    for (int i = 0; i < 8; i++)
            std::cout << "Output = " << arr[i] << "  ";

    //Taking multiline input no. of lines/inputs is unknown
    std::cout<<"\nEnter input  for array(either space separated or on new line). Press q to exit:" <<std::endl;
    while (std::cin>>b){
        if(b==117)  //Enter 'q' to exit
            break;
        else
            std::cout<<"Output = "<<b<< std::endl;
    }

    // Taking matrices as input
    int x[10][10];
    int row = 3, column = 3;
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < column; j++)
        {
            std::cin >> x[i][j];
        }
    }

    std::cout << "Output = \n";
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < column; j++)
        {
            std::cout << x[i][j] << "  ";
        }
        std::cout << "\n";
    }

    // Taking word as input
    std::string word;
    std::cout<< "\nEnter your single word : "<<std::endl;
    std::cin>>word;
    std::cout<<"Output = "<<word;

    //Taking Sentence as input on single line
    std::string sentence;
    std::cout<< "\nEnter your sentence : "<<std::endl;
    std::getline(std::cin,sentence);
    std::cout<<"Output = "<<sentence;
}