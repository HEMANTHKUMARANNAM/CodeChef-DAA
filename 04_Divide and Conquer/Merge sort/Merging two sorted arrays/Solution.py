def merge_and_sort(arr1, arr2):
    # Get the lengths of the arrays
    n = len(arr1)
    m = len(arr2)

    # Initialize pointers for both arrays and the combined array
    i = 0
    j = 0
    combined_array = []

    # Merge the arrays using two pointers
    while i < n and j < m:
        if arr1[i] < arr2[j]:
            combined_array.append(arr1[i])
            i += 1
        else:
            combined_array.append(arr2[j])
            j += 1

    # Add remaining elements from arr1
    while i < n:
        combined_array.append(arr1[i])
        i += 1

    # Add remaining elements from arr2
    while j < m:
        combined_array.append(arr2[j])
        j += 1

    return combined_array

# Input sizes and arrays
size1 = int(input())
arr1 = list(map(int, input().split()))

size2 = int(input())
arr2 = list(map(int, input().split()))

# Call the function and print the result
result = merge_and_sort(arr1, arr2)
print(*result)
