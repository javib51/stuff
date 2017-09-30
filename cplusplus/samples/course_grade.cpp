#include "course_grade.hpp"

double
Course_Grade::grade(void) {
  return this->midterm * 0.2 + this->final_exam * 0.4 + 0.4 * this->homework;
}

void
Course_Grade::setMidterm(double midterm) {
  this->midterm = midterm;
}

void
Course_Grade::setFinalExam(double final_exam){
  this->final_exam = final_exam;
}
void
Course_Grade::setHomeWork(double homework) {
  this->homework = homework;
}
