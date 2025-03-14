#include <iostream>
using namespace std;

void drawTop(string name)
{
    int len = name.length();
    for (int i = 0; i < len; i++)
    {
        cout << "+---";
    }
    cout << "+" << endl;
    for (int i = 0; i < len; i++)
    {
        cout << "| " << name[i] << " ";
    }
    cout << "|" << endl;
    for (int i = 0; i < len; i++)
    {
        cout << "+---";
    }
    cout << "+" << endl;
}

void drawVertical(string name)
{
    int len = name.length();
    for (int i = 1; i < len - 1; i++)
    {
        cout << "| " << name[i] << " |";
        for (int j = 0; j < 4 * (len - 2) - 1; j++)
        {
            cout << " ";
        }
        cout << "| " << name[len - 1 - i] << " |" << endl;
        ;
        if (i != len - 2)
        {
            cout << "+---+";
            for (int j = 0; j < 4 * (len - 2) - 1; j++)
            {
                cout << " ";
            }
            cout << "+---+" << endl;
        }
    }
}

void drawBottom(string name)
{
    int len = name.length();
    for (int i = 0; i < len; i++)
    {
        cout << "+---";
    }
    cout << "+" << endl;
    ;
    for (int i = 0; i < len; i++)
    {
        cout << "| " << name[len - 1 - i] << " ";
    }
    cout << "|" << endl;
    for (int i = 0; i < len; i++)
    {
        cout << "+---";
    }
    cout << "+" << endl;
}

void drawNameSquare(string name)
{
    string upper = basic_string<char>(name.length(), ' ');
    for (int i = 0; i < name.length(); i++)
    {
        upper[i] = toupper(name[i]);
    }

    drawTop(upper);

    drawVertical(upper);

    drawBottom(upper);
}

int main()
{
    drawNameSquare("Ben Kracht");

    return 0;
}