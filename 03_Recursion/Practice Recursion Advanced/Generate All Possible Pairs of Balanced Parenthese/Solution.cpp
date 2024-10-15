#include<bits/stdc++.h>
using namespace std;

void generateParenthesis(int n, int open, int close, string str, vector<string> &result) {
    if(open == n && close == n) {
        result.push_back(str);
        return;
    }
    if(open < n) {
        generateParenthesis(n, open + 1, close, str + "(", result);
    }
    if(close < open) {
        generateParenthesis(n, open, close + 1, str + ")", result);
    }
}

vector<string> generateParenthesis(int n) {
    vector<string> result;
    generateParenthesis(n, 0, 0, "", result);
    return result;
}

int main() {
    int n;
    cin >> n;
    vector<string> result = generateParenthesis(n);
    sort(result.begin(), result.end()); // Sorting the result vector
    for(const string &s : result) {
        cout << s << endl;
    }
    return 0;
}