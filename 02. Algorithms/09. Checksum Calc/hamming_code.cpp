#include <iostream>
#include <vector>

using namespace std;

vector<int> generate(const vector<int> &dataBits, bool evenParity)
{
    int r = 0;
    while ((static_cast<unsigned long long>(1) << r) < dataBits.size() + r + 1)
        r++;
    vector<int> hammingCode(r + dataBits.size());
    vector<int> parityIndex(r);
    int exp = 0;
    int index = dataBits.size() - 1;
    for (int i = 0; i < hammingCode.size(); i++)
    {
        if (i + 1 == (1 << exp))
            parityIndex[exp++] = hammingCode.size() - 1 - i;
        else
            hammingCode[hammingCode.size() - 1 - i] = dataBits[index--];
    }
    for (int i = 0; i < r; i++)
    {
        int isEven = 0;
        int mask = 1 << i;
        for (int j = 0; j < hammingCode.size(); j++)
            if (((j + 1) & mask) != 0)
                isEven = isEven ^ hammingCode[hammingCode.size() - 1 - j];
        if (isEven == (evenParity ? 1 : 0))
            hammingCode[parityIndex[i]] = 1;
    }
    return hammingCode;
}

vector<int> correctError(const vector<int>& hammingCode, bool evenParity)
{
    int errorPosition = 0;
    int exp = 0;
    while (static_cast<unsigned long long>(1) << exp <= hammingCode.size())
        exp++;
    while (exp--)
    {
        int parityCheck = evenParity?0:1;
        int mask = 1 << exp;
        for (int i = hammingCode.size() - 1; i >= 0; i--)
        {
            if (((hammingCode.size() - i) & mask) != 0)
                parityCheck ^= hammingCode[i];
        }
        errorPosition = (errorPosition << 1) | parityCheck;
    }
    vector<int> correctedCode(hammingCode);
    correctedCode[correctedCode.size() - errorPosition] ^= 1;
    return correctedCode;
}

vector<int> extract(const vector<int>& hammingCode, bool evenParity)
{
    int exp = 0;
    vector<int> extracted;
    for (int i = 1; i <= hammingCode.size(); i++)
    {
        if (i == (1 << exp))
        {
            exp++;
            continue;
        }
        extracted.push_back(hammingCode[hammingCode.size() - i]);
    }
    vector<int> dataBits(extracted.size());
    for (int i = 0; i < dataBits.size(); i++)
        dataBits[i] = extracted[extracted.size() - 1 - i];
    return dataBits;
}

void driverFunction(bool evenParity)
{
    cout << (evenParity ? "Even" : "Odd") << " Parity - " << endl;

    cout << "Original Data:\t\t\t";
    vector<int> dataBits = { 1, 0, 1, 1, 0, 0, 1};
    for (int i = 0; i < dataBits.size(); i++)
        cout << dataBits[i] << " ";

    cout << endl;

    cout << "Hamming Code Generated:\t\t";
    vector<int> hammingCode = generate(dataBits, evenParity);
    for (int i = 0; i < hammingCode.size(); i++)
        cout << hammingCode[i] << " ";

    cout << endl;

    cout << "Hamming Code With Error:\t";
    hammingCode[5] ^= 1;
    for (int i = 0; i < hammingCode.size(); i++)
        cout << hammingCode[i] << " ";

    cout << endl;

    cout << "Hamming Code Corrected:\t\t";
    vector<int> correctedCode = correctError(hammingCode, evenParity);
    for (int i = 0; i < correctedCode.size(); i++)
        cout << correctedCode[i] << " ";

    cout << endl;

    cout << "Data Extracted:\t\t\t";
    vector<int> decodedBits = extract(correctedCode, evenParity);
    for (int i = 0; i < decodedBits.size(); i++)
        cout << decodedBits[i] << " ";

    cout << endl;
}

int main()
{
    driverFunction(true);
    cout << endl;
    driverFunction(false);
}