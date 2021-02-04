#include <memory>
#include <iostream>

using namespace std;
struct C : std::enable_shared_from_this<C> {

};

int main() {
  shared_ptr<C> foo, bar;
  foo = make_shared<C>();
  bar = foo->shared_from_this();
  if (!foo.owner_before(bar) && !bar.owner_before(foo)) {
    cout << "bother pointer shared ownership" <<endl;
  }
}