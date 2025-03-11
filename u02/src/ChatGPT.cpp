#include <iostream>
#include <regex>
#include <string>
#include <random>
using namespace std;

const regex INVALID("[.&%^$£@!)({}\";|/+=!`~<>,?]");

string retrieveName(string msg)
{
    cout << msg << endl;
    string ans;
    cin >> ans;
    if (regex_match(ans, INVALID))
    {
        return retrieveName("Please enter a valid name.");
    }
    return ans;
}

int retrieveInt(string msg)
{
    cout << msg << endl;
    string ans;
    cin >> ans;
    try
    {
        int i = stoi(ans);
        if (i <= 0)
            throw new exception();
        else
            return i;
    }
    catch (exception e)
    {
        return retrieveInt("Please enter a valid integer.");
    }
}

int main()
{
    string name = retrieveName("Guten Tag! Ich bin ChatGPT, der beste Chatbot, den es gibt. Wie heissen Sie?");
    cout << "Sehr erfreut " << name << "! ";
    int age = retrieveInt("Wie alt sind Sie?");

    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> distr(0, age * 2 - 1);

    int random = distr(gen);

    cout << "Mittels dieser Informationen habe ich Ihre Glückszahl gefunden! Die Glückszahl lautet " << random << endl;

    return 0;
}
