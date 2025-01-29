package Trie;

class Node2 {
    Node2 links[] = new Node2[26];
    int cntEndWith = 0;
    int cntPrefix = 0;

    public Node2() {
    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }
    Node2 get(char ch) {
        return links[ch-'a'];
    }
    void put(char ch, Node2 node) {
        links[ch-'a'] = node;

    }
    void increaseEnd() {
        cntEndWith++;
    }
    void increasePrefix() {
        cntPrefix++;
    }
    void deleteEnd() {
        cntEndWith--;
    }
    void reducePrefix() {
        cntPrefix--;
    }
    int getEnd() {
        return cntEndWith;
    }
    int getPrefix() {
        return cntPrefix;
    }
}