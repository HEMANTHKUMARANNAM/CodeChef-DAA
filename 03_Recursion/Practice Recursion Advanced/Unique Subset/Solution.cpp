#include <bits/stdc++.h>

using namespace std;

// Helper function to perform backtracking and generate unique subsets
void backtrack(vector<int>& multiset, int start, vector<int>& path, vector<vector<int>>& subsets) {
    // Add the current subset (path) to the list of subsets
    subsets.push_back(path);
    
    // Iterate over the elements starting from 'start' index
    for (int i = start; i < multiset.size(); ++i) {
        // Skip duplicate elements to avoid duplicate subsets
        if (i > start && multiset[i] == multiset[i - 1]) continue;
        
        // Include the current element in the path (current subset)
        path.push_back(multiset[i]);
        
        // Recurse with the next index
        backtrack(multiset, i + 1, path, subsets);
        
        // Backtrack: remove the last element added
        path.pop_back();
    }
}

// Main function to generate all unique subsets
vector<vector<int>> uniqueSubsets(vector<int>& multiset) {
    // Sort the multiset to handle duplicates easily
    sort(multiset.begin(), multiset.end());
    
    // Resultant list of subsets
    vector<vector<int>> subsets;
    
    // Temporary list to store the current subset
    vector<int> path;
    
    // Start backtracking from index 0
    backtrack(multiset, 0, path, subsets);
    
    // Return the list of unique subsets
    return subsets;
}

// Function to print the unique subsets
void printSubsets(vector<vector<int>>& subsets) {
    // Sort subsets based on their size
    sort(subsets.begin(), subsets.end());
    
    for (auto& subset : subsets) {
        cout << "[";
        for (int i = 0; i < subset.size(); ++i) {
            cout << subset[i];
            if (i < subset.size() - 1) {
                cout << " ";
            }
        }
        cout << "]\n";
    }
}

int main() {
    int n;
    // Take the size of the multiset as input
    cin >> n;
    
    vector<int> multiset(n);
    // Take the multiset elements as input
    for (int i = 0; i < n; ++i) {
        cin >> multiset[i];
    }
    
    // Get the unique subsets
    vector<vector<int>> result = uniqueSubsets(multiset);
    
    // Print the unique subsets
    printSubsets(result);

    return 0;
}
