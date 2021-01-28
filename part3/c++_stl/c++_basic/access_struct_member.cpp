#include <iostream>
#include <cstring>

using namespace std;

struct Book {
  char title[50];
  char author[50];
  char subject[50];
  int book_id;
};

int main() {
  struct Book Book1{}; // declare Book1 of type Book
  struct Book Book2{}; // declare Book2 of type Book
  strcpy(Book1.title, "Learn C++ Programming");
  strcpy(Book1.author, "anymore");
  strcpy(Book1.subject, "subject");
  Book1.book_id = 6495407;

  strcpy(Book2.title, "Telecom Billing");
  strcpy(Book2.author, "Yakit Singha");
  strcpy(Book2.subject, "Telecom");
  Book2.book_id = 6495700;

  // Print Book2 info
  cout << "Book 2 title : " << Book2.title << endl;
  cout << "Book 2 author : " << Book2.author << endl;
  cout << "Book 2 subject : " << Book2.subject << endl;
  cout << "Book 2 id : " << Book2.book_id << endl;

}