def is_palindrome(s):
    return s == s[::-1]

def find_partitions(s, start, current_partition, result):
    if start == len(s):
        result.append(current_partition[:])
        return
    for i in range(start, len(s)):
        substring = s[start:i+1]
        if is_palindrome(substring):
            current_partition.append(substring)
            find_partitions(s, i+1, current_partition, result)
            current_partition.pop()

def palindrome_partitions(s):
    result = []
    find_partitions(s, 0, [], result)
    result.sort()
    return result


T = int(input())
for _ in range(T):
    s = input().strip()
    partitions = palindrome_partitions(s)
    
    print(len(partitions))
    for partition in partitions:
        print(" ".join(partition))

