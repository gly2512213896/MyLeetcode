# Method 1: Twice reverse
## Procedure:
1. Remove all extra spaces.
2. Reverse the whole string.
3. Reverse every reversed word by recognizing the single spaces
ideas:

##Steps of remove extra spaces:<br/>
**1. Didn't create a new array, just overwrite it.** (C++)
1. The case that one index is fast but the other is slow: `fastindex is in a for loop
while slowindex is inside it and be surrounded by an if statement`
2. An element of an array can't be easily **removed**, but can be easily **overwritten**. 
3. Make *fastIndex* start from non-space character and skip continuous extra space(s), and use
*slowIndex* to overwrite the normal array, so we can remove extra spaces without 
creating a new array. 
4. (C++)Resize the array to remove the last (few) space(s) in the string if exist(s).

**2. Create a new array, and add what we need** (Java)
## Steps of reverse each words:
**1. Use *entry* flag to remind us where we meet a space and need to reverse a word. True
when it is a space, and False when completing reversing a word.**(troublesome)<br/>
**2. Use while loop and two pointer *i* and *j*, *j* to find spaces and *i* to reverse words.
Make *i*=*j* when completing reversing a word.**(simple)

code:
```java
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=removeSpaces(s);
        reverseString(sb,0,sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }
    private StringBuilder removeSpaces(String s){
        int start=0;
        int end=s.length()-1;
        while(s.charAt(start)==' ') start++;
        while(s.charAt(end)==' ') end--;
        StringBuilder sb=new StringBuilder();
        while(start<=end){
            char c=s.charAt(start);
            /*
               It is difficult to indicate the subscripts of extra spaces(with the number
               of spaces encountered, the subscripts to be added are also different),
               instead of judging whether there is a space at the end of the new string(word),
               there is no need to add it if space exists.
             */
            if(c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            //*start* is an index of *s*, so it has to be put outside the "if" to traverse
            //the *s*
            start++;
        }
        return sb;
    }
    public void reverseString(StringBuilder sb,int start,int end){
        while(start<end){
            char temp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
    public void reverseEachWord(StringBuilder sb){
        int start=0;
        int end=0;
        int n=sb.length();
        while(start<n){
            while(end<n&&sb.charAt(end)!=' ') end++;
            //Notice function below will change the value of start and
            reverseString(sb,start,end-1);
            start=end+1;
            end =start+1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```
# Method 2: Create a new String to receive words from original String's backward by using two pointer
```java

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
            /*
                *i* may not change(if there are continuous spaces), 
                so we need to judge whether it equals to *j*
            */
            if(i!=j){
                sb.append(s.substring(i+1,j+1));
                //add a space after every word appended before start
                if(i>start)
                    sb.append(' ');
            }
        }
        return sb.toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
```