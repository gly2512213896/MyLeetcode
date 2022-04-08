//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
       StringBuilder sb=new StringBuilder();
       
       int n=s.length();
       int start=0;
       while(start<n&&s.charAt(start)==' ') start++;
        for (int i =n-1 ; i >=start ; i--) {
            int j=i;
            while(i>=start&&s.charAt(i)!=' ')
                i--;
            //i may not change(if there are continuous spaces), so we need to
            // judge whether it equals to j
            if(i!=j){
                sb.append(s.substring(i+1,j+1));
                if(i>start)
                    sb.append(' ');
            }
        }
        return sb.toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
