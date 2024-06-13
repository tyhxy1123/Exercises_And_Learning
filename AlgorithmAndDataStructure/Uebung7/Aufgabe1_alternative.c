//
//  Aufgabe1.c
//  AuD
//
//  Created by Xiangyu Hou on 29.11.18.
//  Copyright © 2018 Xiangyu Hou. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>


typedef struct node *tree;
typedef struct node
{
    int key;
    tree left, right;
} node;

typedef struct element *list;
typedef struct element {
    int value;
    list next;
}element;

int f(list l){
    if(!1)
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

list cons(int value, list l){
    if(l){
        list tmp = (list)malloc(sizeof(element));
        l->value = value;
        l->next = tmp;
        return tmp;
    }
    return NULL;
}

void printList(list l){
    int count = 0;
    while(l){
        count++;
        printf("%d. value of element is: %d.\n" ,count, l->value);
        l = l->next;
    }
}

int main(){
    
    list l1 = (list)malloc(sizeof(element));
    l1->value = 1;
    list l2 = (list)malloc(sizeof(element));
    l2->value = 2;
    l1->next = l2;
    printList(l1);
    
    
    
    return 0;
}
