def first_fit_decreasing(items, bin_capacity):
    # Sort items in decreasing order
    items.sort(reverse=True)
    bins = []
    
    for item in items:
        placed = False
        # Try to place the item in an existing bin
        for i in range(len(bins)):
            if bins[i] + item <= bin_capacity:
                bins[i] += item
                placed = True
                break
        # If not placed, create a new bin
        if not placed:
            bins.append(item)
    
    return len(bins)

def bin_packing(T, test_cases):
    results = []
    for i in range(T):
        N, M = test_cases[i][0]
        items = test_cases[i][1]
        
        # Separate odd and even items
        odd_items = [item for item in items if item % 2 != 0]
        even_items = [item for item in items if item % 2 == 0]
        
        
        # Use FFD for odd and even items separately
        bins_odd = first_fit_decreasing(odd_items, M)
        bins_even = first_fit_decreasing(even_items, M)
        
        # Total bins required
        total_bins = bins_odd + bins_even
        results.append(total_bins)
    
    return results

# Read input
import sys
input = sys.stdin.read
data = input().split()

T = int(data[0])
index = 1
test_cases = []

for _ in range(T):
    N = int(data[index])
    M = int(data[index + 1])
    items = list(map(int, data[index + 2 : index + 2 + N]))
    test_cases.append(((N, M), items))
    index += 2 + N

# Get the results
results = bin_packing(T, test_cases)

# Print results
for result in results:
    print(result)
