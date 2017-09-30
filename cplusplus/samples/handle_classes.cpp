#include <iostream>
#include "course_grade.hpp"

int main() {
  Course_Grade course;

  course.setMidterm(7.5);
  course.setFinalExam(6.5);
  course.setHomeWork(9.5);

  std::cout << course.grade() << std::endl;
  return 0;
}

