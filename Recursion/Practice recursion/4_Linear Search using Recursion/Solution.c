#include <stdio.h>
#include <stdlib.h>

int linearSearch(int arr[], int size, int x) {
    //Write your code here
    if(size==0)
    {
        return -1;
    }
    
    if( arr[size-1]== x )
    {
        return size-1;
    }
    
    
    return linearSearch(arr, size-1 , x);
}

int main() {
    int n, x;
    scanf("%d %d", &n, &x);
    int *arr = (int*)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    printf("%d\n", linearSearch(arr, n, x));
    free(arr);
    return 0;
}
