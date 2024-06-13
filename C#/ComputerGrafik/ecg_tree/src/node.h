#ifndef ECT_TREE_NODE_H
#define ECT_TREE_NODE_H

#include <string>
#include <iostream>
#include <vector>

using namespace std;

class Node {
private:
    string name;
    vector<Node*> children;

public:
    Node(const string& str );
    virtual ~Node();

    const string& get_name() const;

    void set_name(const string& new_name);

    int get_nr_children() const;

    Node* get_child(int i) const;

    void add_child(Node * child);
};


#endif //ECT_TREE_NODE_H
