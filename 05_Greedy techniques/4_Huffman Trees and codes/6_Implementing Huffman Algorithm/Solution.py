import heapq
from collections import defaultdict

class Node:
    def __init__(self, data, frequency):
        self.data = data
        self.frequency = frequency
        self.left = None
        self.right = None

    # Define comparison operators for nodes
    def __lt__(self, other):
        return self.frequency < other.frequency

def build(s):
    frequency_map = defaultdict(int)
    for char in s:
        frequency_map[char] += 1

    min_heap = [Node(char, frequency) for char, frequency in frequency_map.items()]
    heapq.heapify(min_heap)

    while len(min_heap) > 1:
        node1 = heapq.heappop(min_heap)
        node2 = heapq.heappop(min_heap)

        internal_node = Node('$', node1.frequency + node2.frequency)
        internal_node.left = node1
        internal_node.right = node2

        heapq.heappush(min_heap, internal_node)

    return min_heap[0]

def generate_codes(root, code, codes):
    if root:
        if root.data != '$':
            codes[root.data] = code
        generate_codes(root.left, code + '0', codes)
        generate_codes(root.right, code + '1', codes)

def dictionary(root):
    codes = {}
    generate_codes(root, '', codes)


def encode(s):
    codes = {}
    generate_codes(build(s), '', codes)

    encoded = ''.join(codes[char] for char in s)
    return encoded

def decode(encoded, root):
    current = root
    decoded = ""

    for bit in encoded:
        if bit == '0':
            current = current.left
        else:
            current = current.right

        if current.left is None and current.right is None:
            decoded += current.data
            current = root

    return decoded

if __name__ == "__main__":
    s = "Hello! This message will be encoded"

    root = build(s)
    dictionary(root)

    encoded = encode(s)
    # print("The encoded string is:", encoded)
    decoded = decode(encoded, root)
    print("The decoded string is:", decoded)
