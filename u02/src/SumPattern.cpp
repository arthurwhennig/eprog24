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

    // check if two integers sum up to the third one
    if (a + b == c)
        cout << "Possible. " << a << " + " << b << " = " << c << endl;
    else if (a + c == b)
        cout << "Possible. " << a << " + " << c << " = " << b << endl;
    else if (b + c == a)
        cout << "Possible. " << b << " + " << c << " = " << a << endl;
    else
        cout << "Impossible.";

    return 0;
}