package leetcode.editor.cn.nodebugger;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return result;
        }
        String[] numStr={"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits,numStr,0);
        return result;
    }
    StringBuilder tmp=new StringBuilder();
    private void backTracking(String digits,String[] numStr,int num){
        // num为当前判断到digits的第几个了；num从0开始
        if(num==digits.length()){
            result.add(tmp.toString());
            return ;
        }
        // '2'并不是第二个，'2'-'0'才是数字2
        String str=numStr[digits.charAt(num)-'0'];
        // 要拼凑（digit对应的字母集.length）次
        for (int i=0;i<str.length();i++){
            tmp.append(str.charAt(i));
            // 需要理解num和i的含义，才能判断哪个进回溯
            // 此题需要组合digits的每个数字对应的字母集，所以用num进递归判断到第几个数字了
            backTracking(digits,numStr,num+1);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
