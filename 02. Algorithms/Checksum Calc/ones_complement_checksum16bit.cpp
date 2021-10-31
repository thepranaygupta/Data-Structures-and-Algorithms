//16bit binary adder with carry
#include<iostream>
using namespace std;

uint16_t b16_adder(uint16_t a,uint16_t b)
{
 uint32_t total32=0;
 total32=a+b;
 uint16_t rem=(total32>>16);
 uint16_t total16=(total32);
 uint16_t real_total=(total16+rem);
 
 return real_total;
}

//pointer to data array and array size
uint16_t checksum_ans16(uint16_t *arr,uint data_size)
{
 uint sz=((data_size%2)>0?data_size+1:data_size);
 uint16_t current_ans=0;
 int x=0;
 while(x<(sz/2))
 {
  uint16_t temp_ans=0;
  uint16_t no=(arr[x]);
  temp_ans=b16_adder(current_ans,no);
  current_ans=(uint16_t)temp_ans;
  }
  x++;
return (uint16_t)(~current_ans);
}
