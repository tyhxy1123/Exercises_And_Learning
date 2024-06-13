#include <stdio.h>
#include <stdlib.h>

typedef struct node *tree;
typedef struct LinkedList *list;
struct node
{
    int key;
    tree left, right;
};

struct LinkedList
{
    int value;
    list next;
};


int f(list l){
    if(!l)
        return 1;

    while(l->next){
        if(!(l->value == l->next->value || l->value == l->next->value + 1 || l->value + 1 == l->next->value))
            return 0;
        l = l->next;
    }

    return 1;
}

void defol(tree* t){
    if(!t || !(*t))
        return;

    if((*t)->left == NULL && (*t)->right == NULL){
        free(*t);
    }


}