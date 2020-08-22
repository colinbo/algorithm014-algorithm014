import java.util.HashMap;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()){
            if (!map.containsKey(c)){
                return false;
            }
            int count = map.get(c) - 1;
            if (count < 0)
                return false;

            map.put(c, count);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Anagram().isAnagram("aacc", "ccac"));
    }
}
