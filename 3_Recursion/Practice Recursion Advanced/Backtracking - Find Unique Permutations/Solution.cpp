#include <bits/stdc++.h>
using namespace std;

void uniquePermutations(map<int,int>& elementsFreq, vector<int>& currentPermutation, vector<vector<int>>& allPermutations) {
    if (elementsFreq.empty()) {
        allPermutations.push_back(currentPermutation);
        return;
    }
    for (auto element: elementsFreq) {
        int num = element.first, freq = element.second;
        currentPermutation.push_back(num);
        map<int, int> newElementsFreq = elementsFreq;
        if (freq == 1)
            newElementsFreq.erase(num);
        else
            newElementsFreq[num]--;
        uniquePermutations(newElementsFreq, currentPermutation, allPermutations);
        currentPermutation.pop_back();
    }
}

int main() {
	int t;
	cin>>t;
	while(t--){
	    int N;
	    cin>>N;
	    map<int,int> elementsFreq;
	    for (int i=0; i<N; i++) {
	        int x;
	        cin>>x;
	        elementsFreq[x]++;
	    }
	    vector<vector<int>> allPermutations;
        vector<int> currentPermutation;
        uniquePermutations(elementsFreq, currentPermutation, allPermutations);
        cout<<allPermutations.size()<<endl;
        for (auto& permutation: allPermutations) {
            for (int i: permutation)
                cout<<i<<" ";
            cout<<endl;
        }
	}
	return 0;
}
