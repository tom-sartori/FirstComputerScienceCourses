#include "../generic/myalloc.h"
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <time.h>  

#define TAILLE_MAX 1024

void test0()
{
  int i = 1;
  int* table_des_pointeurs[10]; 
  for(i = 0; i< 10; i++)
    { 
      int taille = (i+1)*sizeof(int);
      table_des_pointeurs[i] = myalloc(taille);
      printf("allocation de %d bytes à %p \n",taille,table_des_pointeurs[i]);
      int j ;
      for( j = 0; j < taille ; j++)
	{
	  table_des_pointeurs[i][j] = taille-j;
	}  
      for( j = 0; j < taille ; j++)
	{
	  assert( table_des_pointeurs[i][j] == taille-j);
	}
    }
  
  for(i = 0; i< 10; i++)
    {
      myfree(table_des_pointeurs[i]);
    }
 
}

void test2()
{
  static char* buffer_ptr = NULL;
  if(buffer_ptr == NULL)
    {
      buffer_ptr = myalloc(1024*sizeof(char));
      printf("allocation de 1024 bytes à %p \n",buffer_ptr);
      assert(buffer_ptr != NULL);
      blocinfo(buffer_ptr);
    }
  else
    {
      myfree(buffer_ptr);
    }
};
void test1()
{
  int i ;
  for(i = 10; i> 0; i--)
    { 
      int taille = i*sizeof(int);
      int* buffer = myalloc(taille);
      printf("allocation de %d bytes à %p \n",taille,buffer);
      int j ;
      for( j = 0; j< taille ; j++)
	{
	  buffer[j] = taille-j;
	}  
      for( j = 0; j < taille ; j++)
	{
	  assert(buffer[j] == taille-j);
	}
      myfree(buffer);
    }
}
int main(int argc, char* argv[])
{
  printf("[%s] lancee\n",argv[0]);
  test2();
  test1();
  test2();
  test0();
  printf("[%s] termine\n",argv[0]);
}
