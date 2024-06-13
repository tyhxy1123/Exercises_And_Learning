//6. Uebung AuD

#include<stdio.h>

typedef struct element *list;

struct element 
{
    int value;
    list next;
}

int sum_it(list l)
{
    int sum = 0;
    while(l)
    {
        sum += l->value;
        l = l->next;
    }
    return sum;
}

int sum_rec(list l)
{
    if(!l)// if l == NULL
    {
        return 0;
    }
    return l->value + sum_rec(l->next);
}

void rmEvens_it(list* l)
{
    if(!l) return;
    while(*l != NULL)
    {
        if((*l)->value % 2 == 0)
        {
            list tmp = *l;
            *l = (*l)->next;
            free(tmp); //free the memory after deleted the node;
        }    
        else
        {
            l = &((*l)->next);
        }
    }
}

//entfernt ungerade Zahl recursively
void rmEvens_rec(list* l)
{
    if(!l || !*l)
    {
        return;
    }

    

    if((*l)->value % 2 == 0)
    {
        list tmp = *l;
        *l = (*l)->next;
        free(tmp); //free the memory after deleted the node;
    }

    rmEvens_rec(&((*l)->next));
    
}

int void main()
{
    list1 = cons(8,cons(5,cons(2,cons(3,cons(1,cons(6,NULL))))));
    list1_2 = cons(8,cons(5,cons(2,cons(3,cons(1,cons(6,NULL))))));

    printList(l);
    printf("sum(it): %d\n", sum_it(l));
}






























