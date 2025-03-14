#include <iostream>
#include <string>
#include <regex>
using namespace std;

const char MATCH[] = "^[abcdefg]+$";

string retrieveSegment(string prompt)
{
    cout << prompt << endl;
    string ans;
    cin >> ans;
    if (regex_match(ans, regex(MATCH)))
    {
        return ans;
    }
    else
    {
        return retrieveSegment("Please enter a valid seven-segment input.");
    }
}

int recognizeNumber(string segment)
{
    bool states[7];
    for (int i = 0; i < segment.length(); i++)
    {
        int idx = segment[i] - 'a';
        states[idx] = true;
    }

    if (states[0] && states[1] && states[2] && states[3] && states[4] && states[5] && !states[6])
        return 0;
    if (states[1] && states[2] && !states[0] && !states[3] && !states[4] && !states[5] && !states[6])
        return 1;
    if (states[0] && states[1] && states[3] && states[4] && states[6] && !states[2] && !states[5])
        return 2;
    if (states[0] && states[1] && states[2] && states[3] && states[6] && !states[4] && !states[5])
        return 3;
    if (states[1] && states[2] && states[5] && states[6] && !states[0] && !states[3] && !states[4])
        return 4;
    if (states[0] && states[2] && states[3] && states[5] && states[6] && !states[1])
        return states[4] ? 6 : 5;
    if (states[0] && states[1] && states[2] && !states[3] && !states[4] && !states[5])
        return 7;
    if (states[0] && states[1] && states[2] && states[3] && states[5] && states[6])
        return states[4] ? 8 : 9;
    return -1;
}

int main()
{
    string segment = retrieveSegment("Enter a seven-segment:");
    int num = recognizeNumber(segment);
    if (num == -1)
    {
        cout << "Could not recognize number." << endl;
    }
    else
    {
        cout << "The number is " << num << "." << endl;
    }

    return 0;
}