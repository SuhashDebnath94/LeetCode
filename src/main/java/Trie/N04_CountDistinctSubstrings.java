package Trie;

public class N04_CountDistinctSubstrings {
    /**
     * Given a string return all the distinct substrings, use trie
     */

    public static void main(String[] args) {
        String input = "abac";
        N04_CountDistinctSubstrings obj = new N04_CountDistinctSubstrings();
        System.out.println(obj.findDistinctSubstrings(input));
    }

    private int findDistinctSubstrings(String input) {
        if (input.length() == 0) return 1;
        int count = 0;

        Node root = new Node();
        for (int i = 0; i < input.length(); i++) {
            Node node = root;
            for (int j = i; j < input.length(); j++) {
                if (!node.containsKey(input.charAt(j))) {
                    node.put(input.charAt(j), new Node());
                    count++;
                }
                node = node.get(input.charAt(j));
            }
        }
        return count + 1;
    }
}
