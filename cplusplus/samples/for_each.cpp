#include <vector>
#include <iostream>

void vector() {
  std::vector<int> nums{3, 4, 2, 8, 15, 267};
  
  for(auto el: nums) {
    std::cout << el << '\t';
  }
  std::cout << std::endl;
}

void array() {
  int nums[6] = {3, 4, 2, 8, 15, 267};
  
  for(auto el: nums) {
    std::cout << el << '\t';
  }
  std::cout << std::endl;
}

int main()
{
  std::cout << "Vector:" << std::endl;
  vector();
  std::cout << std::endl;

  std::cout << "Vector:" << std::endl;
  array();
  std::cout << std::endl;
}
