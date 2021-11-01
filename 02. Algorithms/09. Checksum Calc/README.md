## CHECKSUM

check calculation is used to ensure the integrity of data.
The 16bit one's complement checksum is used in tcp/ip network
protocol to measure the integrity of the sent packets.

The ones_complement_checksum16bit.cpp file contains the function
**checksum(pointer to data bytes, length of data)** which calculates the 
16bit one's complement of the data referenced to it by the pointer.
