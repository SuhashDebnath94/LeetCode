package Trie;

public class N03_CompleteString {
    /*
        You are given a Array of strings of size n.
        Find the longest complete string in the array. If there are multiple strings of the same length,
        return the lexicographically smallest one.
        If no string exist return none.
     */

    //TC: O(n) x O(len) len being average length of all the strings
    //SC: Its is difficult to predict, since each reference trie may have 26 references and those might have 26 more and so on.
    private static Node root;


    N03_CompleteString() {
        root = new Node();
    }


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

    public String checkCompleteString(int n, String[] arr) {
        N03_CompleteString trie = new N03_CompleteString();

        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }

        String longest = "";
        for (int i = 0; i < n; i++) {
            if (trie.checkIfPrefixExists(arr[i])) {
                if (arr[i].length() > longest.length()) {
                    longest = arr[i];
                } else if (arr[i].length() == longest.length() && arr[i].compareTo(longest) > 0) {
                    longest = arr[i];
                }
            }
        }

        if (longest.equals("")) return "None";
        return longest;
    }

    private boolean checkIfPrefixExists(String s) {
        Node node = root;
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            if (node.containsKey(s.charAt(i))) {
                node = node.get(s.charAt(i));
                flag = flag & node.isEnd();
            } else {
                return false;
            }
        }

        return flag;
    }

}
