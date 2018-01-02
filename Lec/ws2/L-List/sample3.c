/*
   リストの削除
*/

#include <stdio.h>
#include <stdlib.h>

/* セルの定義 */
typedef struct cell{
    struct cell *next;
    int data;
}cell;

cell c1, c2, c3;

int main(void){
 
  cell *p, *pt;


  c1.next =  &c2;  c1.data = 23;
  c2.next =  &c3;  c2.data = 31;
  c3.next = NULL;  c3.data = 97;
 

  pt =  &c1;

  p = pt -> next;
  pt -> next = p ->next;

  for(p= &c1; p != NULL; p = p -> next)
     printf("%3d\n", p -> data);


  return 0;
}