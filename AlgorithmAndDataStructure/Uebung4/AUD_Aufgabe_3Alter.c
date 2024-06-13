#include <stdio.h>
#include <stdbool.h>
#define LEN 1000001

int main()
{
  int sieb[LEN];
  int i,j;
  sieb[0] = 0, sieb[1] = 0;
  for( i = 2; i < LEN; i++)
  {
    sieb[i] = 1;
  }

  for(i = 2; i < LEN; i++)
  {
    if(sieb[i] != 0)
    {
      for(j = 2 * i; j < LEN; j+=i)
      {
        sieb[j]=0;
      }
    }
  }

  for(i = 0; i < LEN; i++)
  {
    if(sieb[i] != 0)
    {
      printf("%d\n", i);
    }
  }
  return 0;
}


