using namespace std;
int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        int N,D,i;
        cin >> N;
        cin >> D;
        int a[N],b[N];
        for(i=0;i<N;i++)
            cin >> a[i];
        for(i=0;i<N;i++)
        {
            if((i+D)<N)
                b[i] = a[i+D];
            else
                b[i] = a[i+D-N];
        }
        for(i=0;i<N;i++)
            cout << b[i] << " ";
        cout << endl;
    }
    return 0;
}