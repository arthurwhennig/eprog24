#include <iostream>
using namespace std;

int magic7(int a, int b)
{
    return (a + b) == 7 || a > b && a - b == 7 || b > a && b - a == 7;
}

int fast12(int z)
{
    int r = z % 12;
    return r <= 2 || r >= 10;
}

int main()
{
    cout << magic7(56, 34) << endl;
    cout << fast12(12) << endl;

    return 0;
}