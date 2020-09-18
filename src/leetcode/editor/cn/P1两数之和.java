package leetcode.editor.cn;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9114 👎 0


import java.util.HashMap;
import java.util.Map;

public class P1两数之和 {
    public static void main(String[] args) {
        P1两数之和 p1两数之和 = new P1两数之和();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> cache = new HashMap<>(16);
            for (int i = 0; i < nums.length; i++) {
                if (cache.containsKey(target - nums[i])) {
                    return new int[]{cache.get(target - nums[i]), i};
                }
                cache.put(nums[i], i);
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}