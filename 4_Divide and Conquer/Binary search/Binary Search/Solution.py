# Replace '_' to solve the problem
def binary_search(arr, target):
    left = 0
    right = len(arr)-1

    while right >= left:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid + 1
        elif arr[mid] > target:
            right = mid-1
        else:
            left = mid+1

    return -1

if __name__ == "__main__":
    t = int(input())
    
    while t > 0:
        n, x = map(int, input().split())
        arr = list(map(int, input().split()))

        result = binary_search(arr, x)
        print(result)

        t -= 1
