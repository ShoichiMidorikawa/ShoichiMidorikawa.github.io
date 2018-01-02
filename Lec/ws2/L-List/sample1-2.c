/*
   ˜AŒ‹ƒŠƒXƒg‚Ì‰Šú‰»‚Q
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct cell{
    struct cell *next;
    int data;
}cell;
 
int main(void){
 
  cell *p;

  cell c3 = {NULL, 97};
  cell c2 = { &c3, 31};
  cell c1 = { &c2, 23};
 
  for(p= &c1; p != NULL; p = p -> next)
     printf("%d\n", p -> data);

  return 0;
}