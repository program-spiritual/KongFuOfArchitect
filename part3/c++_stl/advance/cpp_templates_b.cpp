#include <iostream>
#include <vector>
#include <cstdlib>
#include <string>
#include <stdexcept>

using namespace std;

template<class T>
class Stack {
private:
    vector<T> elements; // elements
public:
    void push(T const &); // push elem
    void pop(); // return top element
    T top() const; // return top element
    bool empty() const {  // return true if empty.
        return elements.empty();
    }
};

template<class T>
void Stack<T>::push(const T &elem) {
    // append copy of passed element
    elements.push_back(elem);
}

template<class T>
void Stack<T>::pop() {
    if (elements.empty()) {
        throw out_of_range("Stack<>::pop(): empty stack");
    }
    // remove last element
    elements.pop_back();
}

template<class T>
T Stack<T>::top() const {
    if (elements.empty()) {
        throw out_of_range("Stack<>::top(): empty stack");
    }

    // return copy of last element
    return elements.back();
}

int main(){
    try{
        Stack<int>  intStack;
        Stack<string>  stringStack;
        // manipulate int stack
        intStack.push(7);
        cout << intStack.top() <<endl;

        // manipulate string stack
        stringStack.push("hello");
        cout << stringStack.top() << std::endl;
        stringStack.pop();
        stringStack.pop();
    } catch (exception const &ex) {
        cerr << "Exception: " << ex.what() <<endl;
        return -1;
    }
}
