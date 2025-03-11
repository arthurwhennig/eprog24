#include <iostream>
using namespace std;

const char VERTICAL = '|';
const char HORIZONTAL = '-';
const char PLUS = '+';
const char EMPTY = ' ';

void horizontal(int width) 
{
    for (int i = 0; i < width; i++) {
        cout << HORIZONTAL;
    }
    cout << endl;
}

void vertical(int width, int numPlus) 
{
    if (numPlus <= width - 2) {
        cout << VERTICAL;
        for (int i = 0; i < (width - numPlus - 2) / 2; i++) {
            cout << EMPTY;
        }
        for (int i = 0; i < numPlus; i++) {
            cout << PLUS;
        }
        for (int i = 0; i < (width - numPlus - 1) / 2; i++) {
            cout << EMPTY;
        }
        cout << VERTICAL;
        cout << endl;
    }
}

void swissFlag(int a, int b)
{
    int width = 7 * a - 1;
    horizontal(width);
    for (int i = 0; i < b-1; i++) {
        vertical(width, 0);
    }
    for (int i = 0; i < b; i++) {
        vertical(width, a);
    }
    for (int i = 0; i < b; i++) {
        vertical(width, 3 * a);
    }
    for (int i = 0; i < b; i++) {
        vertical(width, a);
    }
    for (int i = 0; i < b-1; i++) {
        vertical(width, 0);
    }
    horizontal(width);
}

int main()
{
    swissFlag(12, 6);
    return 0;
}