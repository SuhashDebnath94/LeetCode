package strings;

import java.util.*;

public class N11_GroupAnagrams {
//    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static void main(String[] args) {
        String[] str= {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }

    private static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>>s=new ArrayList<>();
        Map<String,List<String>> map=new LinkedHashMap<>();

        for(String e:strs){
            char ch[]=e.toCharArray();
            Arrays.sort(ch);
            String str=new String(ch);

            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(e);
        }
        s.addAll(map.values());
        return s;
    }
}
