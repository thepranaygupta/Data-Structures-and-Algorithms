#include <stdio.h>
#include <stdlib.h> 
int main()
{
    hanoi(3, 'A', 'B', 'C');
    return 0;
} 
void hanoi(int n, char rodFrom, char rodMiddle, char rodTo){
    if(n==1){
        printf("Disk 1 moved from %c to %c \n",rodFrom,rodTo);
        return;
    }
    hanoi(n-1,rodFrom,rodTo,rodMiddle);
    printf("Disk %d moved from %c to %c \n",n,rodFrom,rodTo);
    hanoi(n-1,rodMiddle,rodFrom,rodTo);
 
}
