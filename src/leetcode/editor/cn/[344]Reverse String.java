//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while(left<right){
            s[left]^=s[right];
            s[right]^=s[left];
            s[left]^=s[right];
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
