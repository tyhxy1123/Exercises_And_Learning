#include "node.h"

static int node_id = 0;


Node::Node(const string& str ){
        Node::name = str;
        node_id++;
        cout << node_id << endl;
    }
    Node::~Node(){
        for(int i = 0; i < children.size(); i++){
            delete children.at(i);
        }
}


const string& Node::get_name() const {
    return name;
}

void Node::set_name(const string& new_name) {
    Node::name = new_name;
}

int Node::get_nr_children() const{
    return Node::children.size();
}

Node* Node::get_child(int i) const{
    return children.at(i);
}

void Node::add_child(Node * child) {
    if (children.empty()) {
        cout << "children is empty" << endl;

    }
    else {
        cout << "children is not empty" << endl;
    }

    children.push_back(child);
}