#include <bits/stdc++.h>
using namespace std;

void uniqueCombinationsSum(vector<int> &arr, int sum, int n, set<vector<int>> &allCombinations, vector<int> &currentCombination){
    if(sum==0){
        allCombinations.insert(currentCombination);
    }
    
    if(sum>=arr[n])
    {
        currentCombination.push_back(arr[n]);
        uniqueCombinationsSum(arr, sum-arr[n], n, allCombinations, currentCombination);
        currentCombination.pop_back();
    }
    if(n+1<arr.size() && sum>=arr[n+1]){
        uniqueCombinationsSum(arr, sum, n+1, allCombinations, currentCombination);
    }
}

int main() {
    int t;
    cin>>t;
    while(t--){
        int n, sum;
        cin>>n>>sum;
        vector<int> arr;
        for(int i=0; i<n; i++){
            int temp;
            cin>>temp;
            arr.push_back(temp);
        }
        vector<int> currentCombination;
        set<vector<int>> allCombinations;
        sort(arr.begin(), arr.end());
        uniqueCombinationsSum(arr, sum, 0, allCombinations, currentCombination);
        cout<<allCombinations.size()<<endl;
        for(auto i: allCombinations){
            for(auto j: i){
                cout<<j<<" ";
            }
            cout<<endl;
        }
    }
}