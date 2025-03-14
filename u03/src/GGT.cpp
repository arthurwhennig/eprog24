#include <iostream>
using namespace std;

int retrieveInt(string prompt)
{
    cout << prompt << endl;
    string ans;
    cin >> ans;
    try
    {
        return stoi(ans);
    }
    catch (exception e)
    {
        return retrieveInt("Please enter a valid integer:");
    }
}

int findGCD(int x, int y)
{
    int remainder = x % y;
    if (x >= y && remainder == 0)
    {
        return y;
    }
    return findGCD(y, remainder);
}

int main()
{
    int x = retrieveInt("Enter x:");
    int y = retrieveInt("Enter y:");

    int gcd = findGCD(x, y);

    cout << "The GCD of " << x << " and " << y << " is " << gcd << endl;

    return 0;
}