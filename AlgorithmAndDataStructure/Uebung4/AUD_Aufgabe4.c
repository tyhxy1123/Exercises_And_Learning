#include <stdio.h>
#include <stdbool.h>

int main()
{
  int n, p=1;
  printf("Zahl eingeben:\n");
  scanf("%i", &n);
  for(int i = 1; i < n+1; i++)
  {
    p *= i;
  }

  printf("%d\n", p);


  return 0;
}


