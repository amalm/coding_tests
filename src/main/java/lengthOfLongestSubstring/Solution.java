package lengthOfLongestSubstring;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
class Solution {
    public int lengthOfLongestSubstring(String s) {
        String[] chars = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = Character.toString(s.charAt(i));
        }
        Map<String, Boolean> map = new HashMap<>();
        int longest = 0;
        int thisSubString = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (thisSubString > longest)
                    longest = thisSubString;
                thisSubString = 1;
                map.clear();
            }
            else {
                thisSubString++;
            }
            map.put(chars[i], Boolean.TRUE);
        }
        return thisSubString > longest ? thisSubString : longest;
    }
    public static void main(String[] args){
        log.info("{}", new Solution().lengthOfLongestSubstring(" "));
    }
}