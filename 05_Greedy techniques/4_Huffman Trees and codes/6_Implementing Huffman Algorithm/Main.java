import java.util.*;

class Node {
    char c;
    boolean isLeaf;
    Node left;
    Node right;

    Node(Node l, Node r) { // To build internal node
        left = l;
        right = r;
        isLeaf = false;
    }

    Node(char d) { // To build leaf node
        left = null;
        right = null;
        isLeaf = true;
        c = d;
    }
}

class Main {
    static class Pair {
        int first;
        Node second;

        Pair(int f, Node s) {
            first = f;
            second = s;
        }
    }

    // Custom comparator function
    static class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p1.first, p2.first);
        }
    }

    static Node build(String s) {
        Map<Character, Integer> freq = new HashMap<>(); // To store frequency of each character

        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        // Priority queue to build tree, based on custom comparator function
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            Node leaf = new Node(entry.getKey());
            pq.add(new Pair(entry.getValue(), leaf));
        }

        while (pq.size() != 1) {
            int sum_of_freq = 0;

            sum_of_freq += pq.peek().first;
            Node left_child = pq.peek().second;
            pq.poll();

            sum_of_freq += pq.peek().first;
            Node right_child = pq.peek().second;
            pq.poll();

            // Build internal node as the parent of these two nodes
            Node internal_node = new Node(left_child, right_child);

            pq.add(new Pair(sum_of_freq, internal_node));
        }

        // Return the root of the tree
        return pq.peek().second;
    }

    static Map<Character, String> dict = new HashMap<>(); // To store dictionary to encode data
    static StringBuilder buffer = new StringBuilder(); // Stores the encoding

    static void dictionary(Node root) {
        if (root.isLeaf) {
            dict.put(root.c, buffer.toString());
            return;
        }

        buffer.append('0'); // Left edge is 0
        dictionary(root.left);
        buffer.deleteCharAt(buffer.length() - 1);

        buffer.append('1'); // Right edge is 1
        dictionary(root.right);
        buffer.deleteCharAt(buffer.length() - 1);
    }

    static String encode(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res.append(dict.get(s.charAt(i)));
        }
        return res.toString();
    }

    static String decode(int idx, String s, Node root, Node current) {
        if (current.isLeaf) {
            return current.c + decode(idx, s, root, root);
        }
        if (idx == s.length()) { // end of encoded sequence
            return "";
        }
        if (s.charAt(idx) == '0') {
            return decode(idx + 1, s, root, current.left);
        }
        return decode(idx + 1, s, root, current.right);
    }

    public static void main(String[] args) {
        String s = "Hello! This message will be encoded";

        Node root = build(s);
        dictionary(root);

        String encoded = encode(s);
        // System.out.println("The encoded string is: " + encoded);

        String decoded = decode(0, encoded, root, root);
        System.out.println("The decoded string is: " + decoded);
    }
}
