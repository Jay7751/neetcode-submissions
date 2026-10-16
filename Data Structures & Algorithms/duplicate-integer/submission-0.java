class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums){
            if(set.contains(ele)) return true;
            set.add(ele);
        }
        return false;
    }
}