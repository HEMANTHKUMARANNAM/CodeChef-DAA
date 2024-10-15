#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// update your function below
void find_unique_recursive(int arr[], int n, int index, int* unique, int* unique_count) {
    
    if( index ==n )
    {
        return ;
    }
    
    bool test = true;
    
    for(int i =0 ; i< *unique_count ; i++)
    {
        if( arr[index] == unique[i] )
        {
            test = false;
        }
    }
    
    if(test)
    {
        unique[*unique_count] = arr[index];
        (*unique_count)++;
    }
    
    find_unique_recursive(arr,n,index+1,unique,unique_count);
    
    
}

int main() {
    int t;
    scanf("%d", &t);
    
    while (t--) {
        int n;
        scanf("%d", &n);
        
        int* arr = (int*)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++) {
            scanf("%d", &arr[i]);
        }
        
        int* unique = (int*)malloc(n * sizeof(int));
        int unique_count = 0;
        
        find_unique_recursive(arr, n, 0, unique, &unique_count);
        
        for (int i = 0; i < unique_count; i++) {
            printf("%d ", unique[i]);
        }
        printf("\n");
        
        free(arr);
        free(unique);
    }
    
    return 0;
}