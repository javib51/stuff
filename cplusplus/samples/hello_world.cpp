#include <iostream>
#include <vector>
// #include <stdio.h>

void hello_world() {
  std::cout << "Hello World!" << std::endl;
}

void hello_var_1() {
  std::string name;
  std::cout << "Please enter your first name: ";
  std::cin >> name;
  std::cout << "Hello " << name << "!" <<std::endl;
}

void multiple_var_1() {
  double d1, d2;
  std::cout << "Please enter two numbers: ";
  std::cin >> d1 >> d2;
  std::cout << "numbers " << d1 << " " << d2 <<std::endl;
}

// void invert_text_1() {
//   std::vector<std::string> input;
//   std::string aux;
//   while (std::cin >> aux) {
//     input.push_back(aux);
//   }

//   std::cout << "Size: " << input.size << std::endl;
//   // while(input.size > 0)
//   //   std::cout << input.pop_back() << "\t";
  
//   std::cout << std::endl;
// }

int main(int argc, char **argv) {
  
  std::cout << "hello_world:" << std::endl;
  hello_world();
  std::cout << std::endl;
  
  std::cout << "hello_var_1:" << std::endl;
  hello_var_1();
  std::cout << std::endl;

  std::cout << "multiple_var_1:" << std::endl;
  multiple_var_1();
  std::cout << std::endl;

  // std::cout << "invert_text_1:" << std::endl;
  // invert_text_1();
  // std::cout << std::endl;

  return 0;
}
