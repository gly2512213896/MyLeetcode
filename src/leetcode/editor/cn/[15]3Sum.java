package leetcode.editor.cn;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0)
                    return result;
                if (i > 1 && nums[i] == nums[i - 1])
                    continue;
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] > 0)
                        right--;
                    else if (nums[i] + nums[left] + nums[right] < 0)
                        left++;
                    else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        right--;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


