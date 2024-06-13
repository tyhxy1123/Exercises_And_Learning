//a)
#include<stdio.h>

typedef struct node *tree;
typedef struct node
{
    int key;
    tree left, right;
} node;

int count(tree t, int k)// count how often does k in tree t vorkommen;
{
    //Notiz unvollstaedig!

    // if(t == NULL)
    //     return 0;
    // int c = 0;
    // if(t->key == k)
    // {
    //     return 1 + count(t->left, k) + count(t->right, k);
    // }
}

tree baz(tree s, tree t)
{
    tree ret = NULL; // new tree to return;

    if(s == NULL)
        return ret;

    ret = (tree) malloc(sizeof(node));

    ret->key = count(t, s->key);
    ret->left = baz(s->left, t);
    ret->right = baz(s->right, t);

    return ret;
}

int leafprod(tree t) // produkt der Blaetter eines Baumes auszurechenen (NUR der Blaetter)
{
    if(t == NULL)
    {
        return 1;
    }

    if(t->left == NULL && t->right == NULL)
    {
        return t->key;
    }

    return leafprod(t->left) * leafprod(t->right);
}

