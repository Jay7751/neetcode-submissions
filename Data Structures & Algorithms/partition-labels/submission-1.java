class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for(int i=0;i<n;i++){
            hm.put(chars[i],i);//value will the last index of the character
        }
        List<Integer> res = new ArrayList<>();
        int end = 0;
        int j=0;
        int size=0;
        while(j!=n){
            size++;
            end = Math.max(hm.get(chars[j]),end);//the max of last index of the char in the substring
            if(j==end){
                res.add(size);//substring is obtained
                size = 0;//for the next substring
            }
            j++;
        }
        return res;
    }
}
