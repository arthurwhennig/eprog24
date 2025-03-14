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
        return retrieveInt("Please enter a valid number:");
    }
}

void printBinary(int num)
{
    int digit = num % 2;
    if (num > 1)
    {
        printBinary(num / 2);
    }
    cout << digit;
}

int main()
{
    int num = retrieveInt("Enter a number:");

    printBinary(num);
    cout << endl;

    return 0;
}