class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = nums.clone();
        for (int length = 2; length <= n; length++) {
            for (int left = 0; left + length <= n; left++) {
                int right = left + length - 1;
                int takeLeft = nums[left] - dp[left + 1];
                int takeRight = nums[right] - dp[left];
                dp[left] = Math.max(takeLeft, takeRight);
            }
        }
        return dp[0] >= 0;
    }
}