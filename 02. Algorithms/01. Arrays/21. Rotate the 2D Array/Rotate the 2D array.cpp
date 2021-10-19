#include <iostream>

using namespace std;

int main()
{
    int a[3][3]={1,2,3,4,5,6,7,8,9};
    int i,j;
    cout<<("Original Array\n");
    for(i=0;i<3;i++)
    {
        for(j=0;j<3;j++)
        {
            cout<<("%d ",a[i][j]);
        }
        cout<<("\n");
    }
    cout<<("Rotate Matrix by 90 degrees\n");
    for(i=0;i<3;i++)
    {
        for(j=2;j>=0;j--)
        {
            cout<<("%d ",a[j][i]);
        }
        cout<<("\n");
    }
    return 0;
}
