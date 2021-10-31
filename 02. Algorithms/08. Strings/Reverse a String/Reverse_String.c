#include <stdio.h>  
#include <string.h>  
// using recursion function   
void revstr(char *str1)  
{  
    // declare static variable  
    static int i, len, temp;  
    len = strlen(str1); // use strlen() to get the length of str string  
      if (i < len/2){  
        // temp variable use to temporary hold the string  
        temp = str1[i];  
        str1[i] = str1[len - i - 1];  
        str1[len - i - 1] = temp;  
        i++;  
        revstr(str1); // recusively calls the revstr() function  
    }  
}  
      int main()  
    {  
        char str1[50]; // size of char string  
        printf (" Enter the string: ");  
        gets(str1); // use gets() function to take string  
        printf (" \n Before reversing the string: %s \n", str1);  
        // call revstr() function   
        revstr(str1);  
        printf (" After reversing the string: %s", str1);  
    }  
