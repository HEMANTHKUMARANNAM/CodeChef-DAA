def first_fit_decreasing_bin_packing(item_sizes, bin_capacity):
    sorted_item_sizes = sorted(item_sizes, reverse=True)
 
    even =[]
    odd =[]
    
    for ele in sorted_item_sizes:
        if ele%2 ==0:
            even.append(ele)
        else:
            odd.append(ele)
    
    ans =0
    
    ans += pack(even , bin_capacity)
    ans += pack(odd , bin_capacity)
    
    return ans
    
def pack(items , bin_capacity):
    bins = []
    
    for item in items:
        placed = False
        for i in range(len(bins)):
            if bins[i] + item <= bin_capacity:
                bins[i] += item
                placed = True
                break
        if not placed:
            bins.append(item)

    return len(bins)
    

t = int(input())
for _ in range(t):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))
    
    result = first_fit_decreasing_bin_packing(arr, M)
    print(result)
