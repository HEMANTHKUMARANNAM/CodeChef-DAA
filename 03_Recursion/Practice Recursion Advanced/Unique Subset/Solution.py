from typing import List

def backtrack(multiset: List[int], start: int, path: List[int], subsets: List[List[int]]):
    subsets.append(path.copy())
    
    for i in range(start, len(multiset)):
        if i > start and multiset[i] == multiset[i - 1]:
            continue
        
        path.append(multiset[i])
        backtrack(multiset, i + 1, path, subsets)
        path.pop()

def unique_subsets(multiset: List[int]) -> List[List[int]]:
    multiset.sort()
    subsets = []
    path = []
    backtrack(multiset, 0, path, subsets)
    return subsets

def print_subsets(subsets: List[List[int]]):
    subsets.sort()
    for subset in subsets:
        print(f"[{' '.join(map(str, subset))}]")

def main():
    try:
        n = int(input())
        multiset = list(map(int, input().split()))
    except ValueError as e:
        print(f"Invalid input: {e}")
        return

    result = unique_subsets(multiset)
    print_subsets(result)

if __name__ == "__main__":
    main()
