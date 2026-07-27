class Solution {
    public int maxProduct(int[] nums) {
        int l= 0;
        int s= 0;
        for (int num : nums) {
            if (num > l) {
                s= l;
                l = num;
            } else if (num > s) {
                s = num;
            }
        }
        return (l-1)*(s-1);
    }
}