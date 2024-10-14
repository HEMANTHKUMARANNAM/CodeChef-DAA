import random

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
        
    rand_num = random.choice( range( 0 , len(arr) ) )
    
    pivot = arr[rand_num]
    
    left = []
    right = []
    
    for element in arr[:rand_num] + arr[rand_num+1 :] :
        if element < pivot:
            left.append(element)
        else:
            right.append(element)
    
    return quick_sort(left) + [pivot] + quick_sort(right)


t = int(input())
for _ in range(t):
    N = int(input())
    A = list(map(int, input().split()))
    sorted_array = quick_sort(A)
    print(*sorted_array)