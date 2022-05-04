package leetcode.editor.cn.nodebugger;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder res=new StringBuilder();
        int start=0;
        int n=s.length();
        while(start<n){
            int end=Math.min(start+k,n);
            StringBuilder temp=new StringBuilder(s.substring(start,end));
            if((start/k)%2==0)res.append(temp.reverse());
            else res.append(temp);
            start=end;
        }
        return res.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
