#include <stdio.h>

int main()
{
    int a, b, c;
    // printf("Values: ");
    scanf("%d%d%d", &a, &b, &c);
    if(a>b && a>c)
    {
        if(b>c)
            printf("%d", b);
        else
            printf("%d", c);
    }
    else if(b>c && b>a)
    {
        if(c>a)
            printf("%d", c);
        else
            printf("%d", a);
    }
    else if(a>b)
            printf("%d", a);
        else
            printf("%d", b);
    return 0;
}