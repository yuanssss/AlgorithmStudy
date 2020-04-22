package leetcode;

import java.util.*;

public class q2_lengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "dvdf";
        q2_lengthOfLongestSubstring q = new q2_lengthOfLongestSubstring();
        int a = q.lengthOfLongestSubstring2(s);
        System.out.println(a);
    }

    public int lengthOfLongestSubstring(String s) {

        int counts = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
              if(allUnique(s,i,j))
                  counts=Math.max(counts,j-i);
            }
        }
        return counts;
    }

    public boolean allUnique(String s, int start, int end) {
        ArrayList<Character> al = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if(al.contains(s.charAt(i)))
                return false;
            al.add(s.charAt(i));
        }
        return true;
    }

    public  int lengthOfLongestSubstring2(String s)
    {
//        Set<Character> set=new HashSet<>();
//        int i=0;int j=0;
//        int n=s.length();
//        int  counts=0;
//        while (i<n&&j<n)
//        {
//            if(!set.contains(s.charAt(j)))
//            {
//                set.add(s.charAt(j));
//                j++;
//                counts=Math.max(counts,j-i);
//            }
//            else
//            {
//                set.remove(s.charAt(i));
//                i++;
//            }
//        }
//        return counts;
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
