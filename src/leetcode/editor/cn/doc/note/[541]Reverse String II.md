# [541]Reverse String II
## method 1:Transform `String` into `character array`
ideas:
1. Every *2k* means that *i*+=(2*k)
2. `String` *s* is as an integral whole(作为整体）, and it can't be reversed until we split it 
into character array. 
3. Notice that there is no reverse function of `String` in java, but `StringBuffer` does.
4. So we have to write a function of reversing char array by ourselves if we only want to
use `String`


code:
```java

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        int n=s.length();
        char[] chars=s.toCharArray();
        for (int i = 0; i < n; i+=(2*k)) {
            reverse(chars,i,Math.min(i+k,n)-1);
        }
        /* no need to write it like:
           for(int i=0;i<n;i+=(2*k)){
                if(i+k-1<n){
                    reverse(chars,i,i+k-1);
                }
                reverse(chars,i,n-1);
            }
         */
        return new String(chars);
    }
    public void reverse(char[] chars, int left, int right){
        while(left<right){
            chars[left]^=chars[right];
            chars[right]^=chars[left];
            chars[left]^=chars[right];
            left++;
            right--;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
```
# method 2: Use `while` loop and two pointer
ideas:
1. Judge whether it needs reverse for every *k* characters <br/>
code:
```java
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder res=new StringBuilder();
        int start=0;
        int n=s.length();
        while(start<n){
            /*
                1. The interval of substring function is close left open right
                2. start=0, so the next start should be start+k, namely the value of 
                current end
                3. In other words, k=end-start-1 due to CLOR, the value of the 
                current end is the actual start of next loop
            */
            int end=Math.min(start+k,n);
            StringBuilder temp=new StringBuilder(s.substring(start,end));
            /*
                Illustrate by an example:
                start=0,reverse; start=k,not; start=2k,reverse; start=3k,not...
                It means that odd(奇数） segment which start from even(偶数)*k should reverse,
                vice versa(反之则反）
             */
            if((start/k)%2==0)res.append(temp.reverse());
            else res.append(temp);
            start=end;//the first character of next loop is start+k(or n)
        }
        return res.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

```

