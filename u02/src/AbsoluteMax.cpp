#include <iostream>
using namespace std;

int retrieveInt(string msg)
{
    cout << msg << endl;
    string ans;
    cin >> ans;
    try
    {
        int num = stoi(ans);
        return num;
    }
    catch (exception e)
    {
        return retrieveInt("Please enter a valid integer.");
    }
}

int main()
{
    // retrieve three integers a, b and c
    int a = retrieveInt("Enter a: ");
    int b = retrieveInt("Enter b: ");
    int c = retrieveInt("Enter c: ");

    // take the absolute values of a, b and c
    if (a < -a)
        a = -a;
    if (b < -b)
        b = -b;
    if (c < -c)
        c = -c;

    int r = -1;
    // find the maximum of a, b and c
    if (a > b && a > c)
        r = a;
    else if (b > a && b > c)
        r = b;
    else
        r = c;

    cout << "a: " << a << ", b: " << b << ", c: " << c << " --> r: " << r << endl;

    return 0;
}
