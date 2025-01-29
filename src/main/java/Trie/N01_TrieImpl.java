package Trie;

public class N01_TrieImpl {
    private Node root;

    //Initialize your data structure here

    N01_TrieImpl() {
        root = new Node();
    }


    //Inserts a word into the trie

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }


    //Returns if the word is in the trie

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        if (node.isEnd()) {
            return true;
        }
        return false;
    }


    //Returns if there is any word in the trie that starts with the given prefix

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    public void main(String args[]) {
        int n = 5;
        int type[] = {1, 1, 2, 3, 2};
        String value[] = {"hello", "help", "help", "hel", "hel"};
        N01_TrieImpl trie = new N01_TrieImpl();
        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);
            } else if (type[i] == 2) {
                if (trie.search(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else {
                if (trie.startsWith(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }
}
