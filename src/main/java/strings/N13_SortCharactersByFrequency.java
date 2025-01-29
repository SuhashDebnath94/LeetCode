package strings;

import java.util.*;

public class N13_SortCharactersByFrequency {
    /**
     * Given a string s, sort it in decreasing order based on the frequency of the characters.
     * The frequency of a character is the number of times it appears in the string.
     *
     * Return the sorted string. If there are multiple answers, return any of them.
     *
     * Example 1:
     *
     * Input: s = "tree"
     * Output: "eert"
     * Explanation: 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cccaaa"
     * Output: "aaaccc"
     * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     */

    public static void main(String[] args) {
        String input= "cccaaa";
        System.out.println(sortCharactersByFrequency(input));
    }

    private static String sortCharactersByFrequency(String input) {
        String[] chars=input.split("");
        Map<String, Integer> frequencyMap=new HashMap<>();

        for(String s:chars){
            if(frequencyMap.containsKey(s)){
                frequencyMap.put(s, frequencyMap.get(s)+1);
            }
            else {
                frequencyMap.put(s, 1);
            }
        }
        List<Map.Entry<String, Integer>> resultList=new ArrayList<>();
        resultList.addAll(frequencyMap.entrySet());
        resultList.sort((x, y) -> {
            if(x.getValue()> y.getValue()) return -1;
            else if (y.getValue()>x.getValue()) {
                return 1;
            }
            return 0;
        });
        StringBuffer result=new StringBuffer();
        for (Map.Entry<String,Integer> entry:resultList){
            for(int i=0;i<entry.getValue();i++){
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }
}
