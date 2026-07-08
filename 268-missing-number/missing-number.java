class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n= 0;
        for(int i = 0; i<nums.length;i++)
        {
            if(n == nums[i])
            {
                n++;
            }
        }
    return n;
    }
}