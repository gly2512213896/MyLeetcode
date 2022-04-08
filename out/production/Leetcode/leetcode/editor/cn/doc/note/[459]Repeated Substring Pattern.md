# Method 1: One by one move chars from the back to the front, checking if the string are reformed(BF)
ideas:
1. If it can be constructed by one of its substring, we move the characters one by one
from the back to the front, and the string must be re-formed after a certain movement
2. If we really use rotation, it will time out. So we changed to characters splicing(字符串拼接)
3. A string can be rotated at most `s.length()-1` times, the last time is meaningless.
4. Existence of `s` need to be checked, so we should have a copy.

code:
```java
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()==0)
            return false;
        int len=s.length();
        String str=s;
        while(len>1){
            str=s.charAt(len-1)+str.substring(0,str.length()-1);
            if(str.contains(s)) return true;
            len--;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```

# Method 2: Concatenate two strings themselves, checking if the new string contains the original string after removing head and tail
ideas:
1. The key point of method 1 is *re-formed*, which means we need to find whether the original
string **show up again**.
2. That is, if the original string consists of repeated substring, then provided that we can
find the repeated substring, moving the first such substring to the last, the resulting 
string is still the original string.
3. It is difficult to find the repeated substring out, but it is easy to splice the 
*first* substring to the last. Yes, you may have an idea that concatenating two strings 
themselves. 
4. In this way, if we focus only on the middle of the new string, it can be seen 
that the front substring is moved to the back(and is the same as the original string).
Of course, there are some extra strings in the front and back).
5. We don't know how much we should omit from the front and the back, but it's OK as long
as it is shorter than the spliced string, longer than the original string and does not 
contain the first and the last characters.
6. The reason why we have to remove the first and the last character is to avoid they are 
the same. In this case,if we only remove one of them, the character that not be removed 
will be added to the character after splicing. In this way, even if the original string 
can't be composed of itself, it can be found in the new string.

code:
```java
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str=s+s;
        return str.substring(1,str.length()-1).contains(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```

# Method 3: KMP
ideas:
1. If a string consists of one of its substring, length of this substring equals to
*length of the string* - *length of **its** longest equal prefix and suffix*.
2. We can split the original string into two parts, one is the (first or last) *substring*, 
the other is *LEPS*.
3. The longest equal prefix and suffix also consists of such substring.
4. Check whether these lengths of a string meet the rules above through `next` array.
5. The values of `next` array is subscripts, and it is inconvenience to represent the length,
so we initialize `next[0]` to a space(" ") as a placeholder. This way, the values(subscripts)
of `next` array are changed to length.
6. According to 1. and 2. , the length of the entire string is a multiple of the length of 
the repeated substring, that is, the length of the entire string can be evenly divided by
the length of the repeated substring

code:
```java
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.equals(""))
            return false;
        //len is the string length before adding " ", otherwise the length won't be the
        //subscript
        int len=s.length();
        s=" "+s;
        char[] chars=s.toCharArray();
        //Constructing `next` array, value is length
        int[] next=new int[len+1];
        //j+1 is prefix's subscript
        for (int i = 2,j=0; i <= len; i++) {
            //backtracking until getting to the foremost
            while(j>0&&chars[i]!=chars[j+1]) j=next[j];
            if(chars[i]==chars[j+1]) j++;
            next[i]=j;
        }
        //" " have be added, so the length is just the subscript
        if(next[len]>0&&len%(len-next[len])==0)
            return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```