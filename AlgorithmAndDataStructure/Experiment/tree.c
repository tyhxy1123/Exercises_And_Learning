//
//  tree.c
//  AuD
//
//  Created by Xiangyu Hou on 30.11.18.
//  Copyright © 2018 Xiangyu Hou. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct node* tree;
typedef struct node{
    int key;
    tree left;
    tree right;
}node;

tree createTree(tree t, int key1, int key2){
    tree tmp = (tree)malloc(sizeof(node));
    tmp->key = key;
//    if(!(t->left)){
//        t->left = tmp;
//    }
//    else if(!(t->right)){
//        t->right = tmp;
//    }
//    else{
//        char t[] = "The left and right branch are full! Adding new node failed!";
//        printf("%s\n", t);
//    }
    
}




