#include <stdio.h>

int main(void)
{
    int err=0;
    printf("Enter\n");
    err = getchar();
    if (err < 0)
        {
            perror("getchar");
        }
    return 0;
}
