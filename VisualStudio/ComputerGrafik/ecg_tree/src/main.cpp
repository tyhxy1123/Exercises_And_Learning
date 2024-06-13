#include <iostream>
#include "node.h"
using namespace std;
string test(string& str){
    return str;
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    Node *root = new Node("root");
    root->add_child(new Node("left child"));
    root->add_child(new Node("right child"));
    cout << "Hello World" << endl;
    cout << root->get_name() << endl;
    cout << root->get_child(0)->get_name() << endl;
    delete root;

    return 0;





}