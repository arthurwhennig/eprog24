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

int add(int a, int b)
{
    return a + b;
}

int main()
{
    // retrieve two integers a and b
    int a = retrieveInt("Enter a: ");
    int b = retrieveInt("Enter b: ");

    // print their sum
    cout << a << " + " << b << " = " << add(a, b) << endl;

    return 0;
}