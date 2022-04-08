# [344]Reverse String
1. ^=, exclusive or(异或), transform numbers into binary system, compare each of their
bit with each other and see whether the same or not. The same bit is 1,the different 
bit is 0
2. Two variety to exchange their value:
>a^=b; b^=a; a^=b;<br/>
> some of the formula:<br/>
1.x^x=0; <br/>2.x^0=x;<br/> 3.(x^y)^z=x^(y^z);<br/> 4.x^y=y^x<br/>

for instance:
`
a=110, b=001. then a^=b(a=111), b^=a(b=110), a^=b(a=001)
`