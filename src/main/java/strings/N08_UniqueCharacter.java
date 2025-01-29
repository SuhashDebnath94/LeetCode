package strings;

import java.util.HashMap;

public class N08_UniqueCharacter {
//    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
    public static void main(String[] args) {

        System.out.println(firstNonRepeating("leetcode"));
        
    }

    private static int firstNonRepeating(String str) {
        char[] arr=str.toCharArray();
        HashMap<Character, Integer> hashMap=new HashMap<>();

        for(int i=0;i< arr.length;i++){
            if(hashMap.keySet().contains(arr[i])){
                hashMap.put(arr[i], hashMap.get(arr[i])+1);
            }
            else {
                hashMap.put(arr[i], 1);
            }
        }

        for(int i=0;i<arr.length;i++){
            if(hashMap.get(arr[i])==1){
                return i;
            }
        }
        return -1;
    }
}
