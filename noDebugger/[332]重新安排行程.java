package leetcode.editor.cn.nodebugger;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 1. 跟给的测试数据无关，所以我们就把数据整理一下，按城市收集起来，放到一个map中
 * 2. 即key为出发城市，而value为到达城市以及还有没有余量到达次数
 * 3. 先将目的城市排序，然后将上一个目的城市作为出发城市，跟它的所有能到达的目的城市拼一遍，以此类推。
 *      最先把票数组用完的就是答案（不能直接拿最先遍历的答案，因为它有可能走不完全程）
 */
class Solution {
    // 一个城市可以去多个城市，去同一个城市也可以去多次
    Map<String,Map<String,Integer>> map;
    Deque<String> result;
    public List<String> findItinerary(List<List<String>> tickets) {
        // 先初始化成员变量
        map=new HashMap<>();
        result=new ArrayDeque<>();
        // 把tickets组成map
        // 统计目的城市可以去几次
        for(List<String> t : tickets){
            //temp用来装map的value（类型为Map<String,Integer>）
            Map<String, Integer> temp;
            if(!map.containsKey(t.get(0))){
                // map还没放过对应的value，也就没有该key，就新建一个临时value用来之后放值
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1),1);
            }else{
                temp = map.get(t.get(0));
                //否则就把同一个出发地的其他目的地放到tmp中（tmp是一个集合，不止能放一个键值对）
                temp.put(t.get(1), temp.getOrDefault(t.get(1),0) + 1);
            }
            map.put(t.get(0), temp);

        }
        result.add("JFK");
        backtrack(tickets.size());
        return new ArrayList<>(result);
    }
    // 1. 找到一个答案就可以返回
    // 2. 因为已经按照城市字母排序了，所以找到第一个答案就是最优的
    // 回溯中用不到给的票数组，因为已经被整理成map了，所以可以不用传参
    // 原代码：
    // backtrack(List<List<String>> tickets,int ticketNum)

    boolean backtrack(int ticketNum){
        // 一张票对应两个城市，所以终止条件为城市数到达了总票数+1
        // 此处只为终点返回的结果，当前的方法中还得返回
        if(result.size()==ticketNum+1){
            return true;
        }
        String last=result.getLast();
        // 最后一个城市get不到目的地，会爆NPE
        if(map.get(last)!=null){
            for (Map.Entry<String, Integer> dest : map.get(last).entrySet()) {
                int count=dest.getValue();
                // 还有票能去
                if(count>0){
                    result.add(dest.getKey());
                    // 注意还得把去往当前目的城市的航班数-1
                    dest.setValue(count-1);
                    // 当前层的结果由子递归返回
                    // 原代码：
                    // backtrack(ticketNum);
                    if(backtrack(ticketNum)) return true;//或return backtrack(ticketNum);
                    result.removeLast();
                    // 其他航班还可能经过当前目的城市，所以数量得补回来
                    // 原代码：
                    // dest.setValue(count+1),错误，count在当前层没变过
                    dest.setValue(count);
                }
            }
        }
        // 否则return false
        return false;
    }

}

//leetcode submit region end(Prohibit modification and deletion)
