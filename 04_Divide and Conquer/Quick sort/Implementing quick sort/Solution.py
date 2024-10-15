def partition(a, l, r):
    """
    Partition the array into two parts and return the index of the pivot element.
    Args:
    - a: The array to be partitioned
    - l: The leftmost index of the subarray
    - r: The rightmost index of the subarray
    Returns:
    - The index of the pivot element
    """
    pivot = a[r]
    idx = l

    for i in range(l, r):
        if a[i] <= pivot:
            a[idx], a[i] = a[i], a[idx]
            idx += 1

    a[idx], a[r] = a[r], a[idx]

    # Return the final pivot index
    return idx


def sort(a, l, r):
    """
    Recursive function to sort the array using quicksort.
    Args:
    - a: The array to be sorted
    - l: The leftmost index of the subarray
    - r: The rightmost index of the subarray
    """
    if r - l < 1:
        return  # Arrays of size 1 and 0 are already sorted

    pivot = partition(a, l, r)

    # Sorting both halves of the array
    sort(a, l, pivot - 1)
    sort(a, pivot + 1, r)


if __name__ == "__main__":
    n = int(input())

    a = list(map(int, input().split()))

    sort(a, 0, n - 1)

    for i in range(n):
        print(a[i], end=" ")

    print()
