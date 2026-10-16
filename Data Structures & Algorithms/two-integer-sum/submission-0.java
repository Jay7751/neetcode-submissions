class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int idx=0; idx<nums.length; idx++){
            if(map.containsKey(target-nums[idx])){
                res[0] = map.get(target-nums[idx]);
                res[1] = idx;
            }
            map.put(nums[idx],idx);
        }
        return res;
    }
}