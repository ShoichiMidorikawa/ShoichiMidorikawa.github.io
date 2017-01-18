/*
	pi.c by —ÎìÍˆê(Shoichi Midorikawa) Jan. 20, 2010
	‰~ü—¦‚ğ”CˆÓ¸“x‚Å‹‚ß‚éB
	Machin‚ÌŒö®‚ğ—p‚¢‚éB
	5Œ…‚¸‚Â‚Ü‚Æ‚ß‚ÄŒvZ‚·‚éB
	
*/
#include<stdio.h>
#include<math.h>
#include<time.h>

#define max_n 10010


/* Š„‚èZi®”€®”j */
void diff(int a, int b, int ary[], int num)
{
  int i;
	int q;
	int q1, q0;

		q = a/b;
		ary[0] = q; 
		for(i = 1; i < num; i++){
		if( b < 21272){
			a = (a%b)*100000;
			q = a/b;
			ary[i] = q;
		}
		else{
		  a = (a%b)*1000;
			q1 = a/b; 
			a = (a%b)*100;
			q0 = a/b;
			q = q1*100+q0;
			ary[i] = q;
		} 
	}
}


/* Š„‚èZiÀ”€®”j */
void diff_a(int ary1[], int b, int ary2[], int num)
{
	int i;
	int q, r0, r;
  r = 0;
	for(i = 0; i < num; i++){
			q = (r+ary1[i])/b;
			r0 = (r+ary1[i])%b;
			r = r0*100000L;
			ary2[i] = q;
	}
}
 

/* ‘«‚µZ */
void add(int ary1[], int ary2[], int ary3[], int num)
{
	int i;
	int q = 0;
	int r;
	for(i = num-1; i >= 0; i--){
		r=(q+ary1[i]+ary2[i])%100000;
		q = (q+ary1[i]+ary2[i])/100000;
		ary3[i] = r;
	}
}

/* ˆø‚«Z (‘å‚«‚¢”|¬‚³‚¢”)*/
void sub(int ary1[], int ary2[], int ary3[], int num)
{
	int i;
	int q = 0;
	
	for(i = num-1; i >= 0; i--){
		if(ary2[i] > (ary1[i]-q)){
			ary3[i]=100000L+ary1[i]-q-ary2[i];
 			q = 1;}
		else{
			ary3[i] = ary1[i]-q-ary2[i];
			q = 0;
		}
	}				
}
			
			
			
int main(void)
{
	unsigned long int t0, t1;

	/* ŒvZ‚ÌŒ…”=number*5=num5 */
	int number= 2000; 
	int num = number+2;
	int num5 = num*5;
	
	int a1[max_n]={0};
  	int at1[max_n]={0}; 
	int a2[max_n]={0};
	int at2[max_n]={0};

        int pi5[max_n]={0}; 
	int pi[max_n*5]={0};

	int i, j, k;
	int p, q, r;

	int n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, nt;

	t0 = clock();

	/* 16*Arctan(1/5)  */
	i = 0;
	do{		
		q = (2*i+1); 
		diff(16, q, a1, num);		
		for(k = 0; k < i/3; k++)
			diff_a(a1, 15625, a1, num);
		if(i%3 == 0)
			diff_a(a1, 5, a1, num);
		if(i%3 == 1)
			diff_a(a1, 125, a1, num);
		if(i%3 == 2)
			diff_a(a1, 3125, a1, num);
		
				
		if(i%2==0)
			add(at1, a1, at1, num); 
		 else
			sub(at1, a1, at1, num);
		
		i++;	 		
	}while(log10(q)+1.39*i <num5 + 1);


	/* 4*Arctan(1/239)  */
	i = 0;
	do{
		q = (2*i+1); 
	  	diff(4, q, a2, num);		
		for(k = 0; k <= 2*i; k++)
			diff_a(a2, 239, a2, num);	
						
		if(i%2==0)
			add(at2, a2, at2, num); 
		else
			sub(at2, a2, at2, num);
		
		i++;			 		
	}while(log10(q)+4.7*i <num5 + 0.6);



	
	sub(at1, at2, pi5, num);

			pi[0] = pi5[0];
		for(j = 1; j < num; j++){
			pi[1+5*(j-1)] = pi5[j]/10000;
			pi[2+5*(j-1)] = (pi5[j]/1000)%10;
			pi[3+5*(j-1)]  = (pi5[j]/100)%10;
			pi[4+5*(j-1)]  = (pi5[j]/10)%10;
			pi[5+5*(j-1)]  = pi5[j]%10;
		}

		printf("%d.\n", pi[0]);
		for(j = 1; j < number*5+1; j++){
			printf("%d", pi[j]);
			if(j%50==0)			
				putchar('\n');
			if(j%1000==0)
				putchar('\n');					
		}



	n0=n1=n2=n3=n4=n5=n6=n7=n8=n9=0;
	 
	for(i = 0; i < number*5; i++){
		switch(pi[i]){
			case 0: n0++; break;	
			case 1: n1++; break; 
			case 2: n2++; break; 
			case 3: n3++; break; 
			case 4: n4++; break; 
			case 5: n5++; break; 
			case 6: n6++; break; 
			case 7: n7++; break; 
			case 8: n8++; break; 
			case 9: n9++; break; 
		}
	}

	putchar('\n');
	putchar('\n');
	
	printf("0 : %d\n", n0);
	printf("1 : %d\n", n1);
	printf("2 : %d\n", n2);
	printf("3 : %d\n", n3);
	printf("4 : %d\n", n4);
	printf("5 : %d\n", n5);
	printf("6 : %d\n", n6);
	printf("7 : %d\n", n7);
	printf("8 : %d\n", n8);
	printf("9 : %d\n", n9);
	
	printf("------------\n");
	
	nt = n0+n1+n2+n3+n4+n5+n6+n7+n8+n9;
	
	printf("total = %d\n", nt);



	t1 = clock();
	putchar('\n');
	printf("time = %f[s]\n", (t1-t0)/1000.0 );


	return (0);
}
