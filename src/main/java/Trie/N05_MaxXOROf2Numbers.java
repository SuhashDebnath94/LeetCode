package Trie;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Statement:
 * You are given two arrays of non-negative integers say ‘arr1’ and ‘arr2’ of sizes N and M respectively.
 * Find the maximum value of ( ‘A’ xor ‘B’ ) where ‘A’ and ‘B’ are any elements from ‘arr1’ and ‘arr2’ respectively and ‘xor’ represents the bitwise xor operation.
 * Maximum XOR of Two Numbers in an Array.
 *
 * Examples:
 *
 * Example 1:
 *
 * Input: N=2, M=3
 *        arr1 = [6, 8]
 *        arr2 = [7, 8, 2]
 *
 * Output: 15
 *
 * Explanation:
 * Possible pairs are (6, 7), (6, 8), (6, 2), (8, 7), (8, 8), (6, 2).
 * And 8 xor 7 will give the maximum result i.e. 15
 *
 * Example 2:
 *
 * Input: N=2, M=2
 *        arr1 = [1, 2
 * ]
 *        arr2 = [1, 1]
 *
 * Output: 3
 *
 * Explanation: 3 is the maximum possible xor among all possible pairs.
 *
 *
 *
 * Soln:
 * Insert the numbers in terms of binary 32 bits in the trie as if they were strings. eg for 9 we will insert 01001
 * Take x and find the max number from the trie where number ^ x is maximum.
 *
 * Suppose the array is 9, 8, 7, 5, 4
 *
 * So we will need the leftmost bit to be set for the number to be maximum
 * if for none of the numbers the leftmost bit is set, check the next bit which is set.
 *
 * so if x is 8 that is 01000 we want the maximum which will give max
 * so since left most is 0 we want the left most bit to be 1 if possible,
 * not possible so we are forced to take 0
 * next bit we want as 0 since it is 1 for 8
 * possible for 7, 5, 4
 * next we would want 1 since for 8 is 0
 * possible for only 7
 *
 * hence the answer is 7^8
 *
 * so using a trie check if 1 is present for root.
 * no
 * then take 0
 * then check if 0 is present for current node
 * yes
 * then take 0
 * then check if 1 is present for current node
 * yes
 * take that
 * and so on
 *
 * now design a function which gives you the maximum for x
 */

class N05_MaxXOROf2Numbers {
    private static Node3 root;

    //Initialize your data structure here
    N05_MaxXOROf2Numbers() {
        root = new Node3();
    }

    //Inserts a word into the trie
    public static void insert(int num) {
        Node3 node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node3());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node3 node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }


    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        N05_MaxXOROf2Numbers trie = new N05_MaxXOROf2Numbers();
        for (int i = 0; i < n; i++) {
            trie.insert(arr1.get(i));
        }
        int maxi = 0;
        for (int i = 0; i < m; i++) {
            maxi = Math.max(maxi, trie.getMax(arr2.get(i)));
        }
        return maxi;
    }


    public static void main(String[] args) {
        int n = 2, m = 3;
        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(new Integer[]
                {6, 8}));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(new Integer[]
                {7, 8, 2}));
        System.out.println(maxXOR(n, m, arr1, arr2));
    }

}

class Node3 {
    Node3 links[] = new Node3[2];

    public Node3() {
    }

    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    Node3 get(int ind) {
        return links[ind];
    }

    void put(int ind, Node3 node) {
        links[ind] = node;
    }
};


