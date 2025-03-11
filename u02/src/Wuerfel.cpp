#include <iostream>
#include <random>
using namespace std;

int retrievePositiveInt(string msg)
{
    cout << msg << endl;
    string ans;
    cin >> ans;
    try
    {
        int num = stoi(ans);
        if (num <= 0)
            throw new exception();
        else
            return num;
    }
    catch (exception e)
    {
        return retrievePositiveInt("Please enter a valid positive integer.");
    }
}

int main()
{
    int N = retrievePositiveInt("Enter the number of sides: ");
    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> distr(1, N);

    int choice = distr(gen);
    cout << "The dice rolled a " << choice << "." << endl;

    return 0;
}