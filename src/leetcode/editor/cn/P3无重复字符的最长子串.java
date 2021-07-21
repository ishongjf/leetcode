package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5779 👎 0


public class P3无重复字符的最长子串 {
    public static void main(String[] args) {
        P3无重复字符的最长子串 p3无重复字符的最长子串 = new P3无重复字符的最长子串();
        int max = Solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(max);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            int[] array = new int[128];
            int len = 0, start = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                start = Math.max(start, array[chars[i]]);
                len = Math.max(len, i - start + 1);
                array[chars[i]] = i + 1;
            }
            return len;
        }

        //myMethod
        /*public int lengthOfLongestSubstring(String s) {
            int max = 0, sum = 0, index = 0;
            Map<Character, Integer> map = new HashMap<>(64);
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i])) {
                    //计算起点，取当前碰撞的字符位置和上一次碰撞的字符位置对比，取最大的
                    index = map.get(chars[i]) > index ? map.get(chars[i]) : index;
                    //计算缩减之后的窗口长度
                    sum = i - index;
                } else {
                    sum++;
                }
                max = Math.max(max, sum);
                map.put(chars[i], i);
            }
            max = Math.max(max, sum);
            return max;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)


}