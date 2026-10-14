class Solution {
    public int numDecodings(String s) {
        Map<Integer,Integer> dp = new HashMap<>();
        dp.put(s.length(),1);
        return dfs(dp,0,s);
    }
    public int dfs(Map<Integer,Integer> dp, int i, String s){
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        if(s.charAt(i) == '0') return 0;
        int res = dfs(dp,i+1,s);
        if(i+1<s.length() && (s.charAt(i) == '1' || s.charAt(i)=='2' && s.charAt(i+1)<'7')){
            res+=dfs(dp,i+2,s);
        }
        dp.put(i,res);
        return res;
    }
}
