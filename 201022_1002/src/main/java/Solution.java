import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] A) {
        HashMap<Character, Integer> current = new HashMap<Character, Integer>();
        HashMap<Character, Integer> collect = new HashMap<Character, Integer>();
        for(char c:A[0].toCharArray()){
            collect.put(c, collect.getOrDefault(c, 0)+1);
        }
        for(int i=1; i<A.length; i++){
            current.clear();
            for(char c:A[i].toCharArray()){
                current.put(c, current.getOrDefault(c, 0)+1);
            }
            for(char k = 'a'; k <= 'z'; k++){
                collect.put(k, Math.min(
                        collect.getOrDefault(k, 0),
                        current.getOrDefault(k, 0)));
            }
        }
        List<String> result = new ArrayList<>();
        for(char k = 'a'; k <= 'z'; k++){
            for(int i=0; i<collect.get(k); i++){
                result.add(String.valueOf(k));
            }
        }
        return result;
    }
    public List<String> commonChars2(String[] A) {
        int[] current;
        int[] collect = new int[26];

        for(char c:A[0].toCharArray()){
            collect[c-'a'] += 1;
        }
        for(int i=1; i<A.length; i++){
            current = new int[26];
            for(char c:A[i].toCharArray()){
                current[c-'a'] += 1;
            }
            for(char k = 'a'; k <= 'z'; k++){
                collect[k-'a'] = Math.min(collect[k-'a'], current[k-'a']);
            }
        }
        List<String> result = new ArrayList<>();
        for(char k = 'a'; k <= 'z'; k++){
            for(int i=0; i<collect[k-'a']; i++){
                result.add(String.valueOf(k));
            }
        }
        System.out.println(result);
        return result;
    }
}