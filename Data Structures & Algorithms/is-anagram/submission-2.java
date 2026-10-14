class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        boolean[] exists = new boolean[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
            exists[ch-'a'] = true;
        }
        for(char ch: t.toCharArray()){
            if(!exists[ch-'a'] || freq[ch-'a']==0) return false;
            freq[ch-'a']--;
        }
        return true;
    }
}