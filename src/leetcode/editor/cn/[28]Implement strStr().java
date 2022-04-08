//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        int j=-1;
        int[] next=new int[needle.length()];
        getNext(next,needle);
        //Where to jump depend on type of the next array
        for (int i = 0; i < haystack.length(); i++) {
           while(j>=0&&haystack.charAt(i)!=needle.charAt(j+1))
               j=next[j];
           if(haystack.charAt(i)==needle.charAt(j+1))
               j++;
           if(j==needle.length()-1)
               return (i-needle.length()+1);
        }
        return -1;
    }
    //next数组的值为最大前缀的小标，而非其后一位
    public void getNext(int[] next,String s){
        int j=-1;
        next[0]=j;
        for (int i = 1; i < s.length(); i++) {
            while(j>=0&&s.charAt(i)!=s.charAt(j+1))
                j=next[j];
            if(s.charAt(i)==s.charAt(j+1))
                j++;
            next[i]=j;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
