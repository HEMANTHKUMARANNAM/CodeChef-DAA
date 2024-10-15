#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Helper function to compare integers for qsort
int compare(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

// Helper function to print a single subset
void printSubset(int* subset, int size) {
    printf("[");
    for (int i = 0; i < size; ++i) {
        printf("%d", subset[i]);
        if (i < size - 1) {
            printf(" ");
        }
    }
    printf("]\n");
}

// Helper function to perform backtracking and generate unique subsets
void backtrack(int* multiset, int start, int* path, int pathSize, int** subsets, int* subsetSizes, int* subsetCount, int n) {
    // Add the current subset (path) to the list of subsets
    subsets[*subsetCount] = (int*)malloc(pathSize * sizeof(int));
    if (subsets[*subsetCount] == NULL) {
        fprintf(stderr, "Memory allocation failed.\n");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < pathSize; ++i) {
        subsets[*subsetCount][i] = path[i];
    }
    subsetSizes[*subsetCount] = pathSize;
    (*subsetCount)++;
    
    // Iterate over the elements starting from 'start' index
    for (int i = start; i < n; ++i) {
        // Skip duplicate elements to avoid duplicate subsets
        if (i > start && multiset[i] == multiset[i - 1]) continue;
        
        // Include the current element in the path (current subset)
        path[pathSize] = multiset[i];
        
        // Recurse with the next index
        backtrack(multiset, i + 1, path, pathSize + 1, subsets, subsetSizes, subsetCount, n);
    }
}

// Main function to generate all unique subsets
void uniqueSubsets(int* multiset, int n, int*** subsets, int** subsetSizes, int* subsetCount) {
    // Sort the multiset to handle duplicates easily
    qsort(multiset, n, sizeof(int), compare);
    
    // Resultant list of subsets
    *subsets = (int**)malloc(1000 * sizeof(int*));
    if (*subsets == NULL) {
        fprintf(stderr, "Memory allocation failed.\n");
        exit(EXIT_FAILURE);
    }
    *subsetSizes = (int*)malloc(1000 * sizeof(int));
    if (*subsetSizes == NULL) {
        fprintf(stderr, "Memory allocation failed.\n");
        exit(EXIT_FAILURE);
    }
    
    // Temporary list to store the current subset
    int* path = (int*)malloc(n * sizeof(int));
    if (path == NULL) {
        fprintf(stderr, "Memory allocation failed.\n");
        exit(EXIT_FAILURE);
    }
    
    *subsetCount = 0;
    
    // Start backtracking from index 0
    backtrack(multiset, 0, path, 0, *subsets, *subsetSizes, subsetCount, n);
    
    free(path);  // Free temporary path array after backtracking
}

// Function to print the unique subsets
void printSubsets(int** subsets, int* subsetSizes, int subsetCount) {
    for (int i = 0; i < subsetCount; ++i) {
        printSubset(subsets[i], subsetSizes[i]);
        free(subsets[i]);  // Free each subset array
    }
    free(subsets);  // Free the array of subset arrays
    free(subsetSizes);  // Free the array of subset sizes
}

int main() {
    int n;
    // Take the size of the multiset as input
    scanf("%d", &n);
    
    int* multiset = (int*)malloc(n * sizeof(int));
    if (multiset == NULL) {
        fprintf(stderr, "Memory allocation failed.\n");
        return EXIT_FAILURE;
    }
    
    // Take the multiset elements as input
    for (int i = 0; i < n; ++i) {
        scanf("%d", &multiset[i]);
    }
    
    // Get the unique subsets
    int** subsets;
    int* subsetSizes;
    int subsetCount;
    uniqueSubsets(multiset, n, &subsets, &subsetSizes, &subsetCount);
    
    // Print the unique subsets
    printSubsets(subsets, subsetSizes, subsetCount);
    
    // Free allocated memory
    free(multiset);
    
    return EXIT_SUCCESS;
}
