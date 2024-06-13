#include <stdio.h>
#include <stdbool.h>

bool isPrim(int n)
{
  for (int i = 2; i < n; i++)
  {
    if (n % i == 0)
    {
      return false;
    }
  }
  return true;
}

int main(void) {
  int n = 0;
  for (int i = 1; i <= 1000; i++)
  {
    if(isPrim(i))
    {
      printf("%d\t", i);
      n++;
      if(n > 6)
      {
        printf("\n");
        n = 0;
      }
    }
  }
  printf("\n");


  return 0;
}

