/*
   —v‘f‚Ì‘}“ü
*/

#include <stdio.h>
#include <stdlib.h>

/* ƒZƒ‹‚Ì’è‹` */
typedef struct cell{
    struct cell *next;
    int data;
}cell;

cell c1, c2, c3, ct;

int main(void){
 
  cell *p;
  cell *pt;

  c1.next =  &c2;  c1.data = 23;
  c2.next =  &c3;  c2.data = 31;
  c3.next = NULL;  c3.data = 97;
 
  ct.data = 123; 

  p =  &c2;
  pt = &ct;
  pt -> next = p -> next;
  p -> next = pt;

  for(p= &c1; p != NULL; p = p -> next)
     printf("%3d\n", p -> data);


  return 0;
}