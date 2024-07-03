class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        int i = 0;
        int j = 0;
        Map<Integer,Integer> temp = new HashMap<>();
        int out = 0;
        while(i<=j && j < nums.length){
            int a = nums[j];
            temp.put(a, temp.getOrDefault(a,0)+1);

            if(temp.get(a) > k){
                out = Math.max(out, j-i);
                while(temp.get(a) > k){
                    int b = nums[i];
                    temp.put(b, temp.get(b)-1);
                    i++;
                }
            }
            j++;
        }
        return Math.max(out,j-i);
    }
}
