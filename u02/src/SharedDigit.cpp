#include <iostream>
using namespace std;

int retrieveInt(string msg) {
    cout << msg << endl;
    string answer;
    cin >> answer;
    try {
        int a = stoi(answer);
        if (a < 0 || a > 99) return retrieveInt("Please enter a valid integer between 0 (inclusive) and 99 (inclusive).");
        else return a;
    } catch (exception e) {
        return retrieveInt("Please enter a valid integer between 0 (inclusive) and 99 (inclusive).");
    }
}

int main() 
{
    int a = retrieveInt("Please enter a number between 0 and 99.");
    int b = retrieveInt("Please enter a number between 0 and 99.");

    int a1 = a / 10;
    int a2 = a % 10;
    int b1 = b / 10;
    int b2 = b % 10;

    int r = -1;
    if (a1 == b1 || a1 == b2) {
        r = a1;
    } else if (a2 == b1 || a2 == b2) {
        r = a2;
    }

    cout << "a: " << a << ", b: " << b << " --> r: " << r << endl;

    return 0;
}