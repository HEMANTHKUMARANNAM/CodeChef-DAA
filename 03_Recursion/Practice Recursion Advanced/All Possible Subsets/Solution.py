def all_possible_subsets(arr, cur_index,  cur_subset, all_subsets):
    #Write your code here
    if( cur_index == len(arr) ):
        newset = [x for x in cur_subset]
        all_subsets.append(newset)
        return
    
    cur_subset.append(arr[cur_index])
    
    all_possible_subsets(arr, cur_index+1,  cur_subset, all_subsets)
    
    cur_subset.pop()
    
    all_possible_subsets(arr, cur_index+1,  cur_subset, all_subsets)

    
n = int(input())
arr = list(map(int, input().split()))
cur_subset = []
all_subsets = []
all_possible_subsets(arr, 0, cur_subset, all_subsets)
all_subsets = sorted(all_subsets)
for subset in all_subsets:
    print(*subset)