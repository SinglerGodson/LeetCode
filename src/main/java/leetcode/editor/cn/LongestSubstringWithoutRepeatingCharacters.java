//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
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
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5382 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ll = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(ll.lengthOfLongestSubstring(""));
        System.out.println(ll.lengthOfLongestSubstring(" "));
        System.out.println(ll.lengthOfLongestSubstring("pwwkew"));
        System.out.println(ll.lengthOfLongestSubstring("bbbbb"));
        System.out.println(ll.lengthOfLongestSubstring("abcabcbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public int lengthOfLongestSubstring(String str) {
        if (str.length() <= 1) {
            return str.length();
        }

        int f = 0; // for first
        int l = f; // for last

        char[] chars = str.toCharArray();
        int[] pos = new int[128];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = -1;
        }
        int pre = -1;
        int s = 0; // for size;
        while (l++ < chars.length - 1) {
            char charL = chars[l];
            if (pos[charL] != -1) {
                f = pos[charL];
            } else {
                pos[charL] = l;
            }
            int t = l - f + 1;
            s = Math.max(t, s);
        }

        return s;
    }
//leetcode submit region end(Prohibit modification and deletion)
//class Solution {
//        // 执行用时：
//        //3 ms
//        //, 在所有 Java 提交中击败了
//        //94.45%
//        //的用户
//        //内存消耗：
//        //38.4 MB
//        //, 在所有 Java 提交中击败了
//        //85.28%
//        //的用户
//    public int lengthOfLongestSubstring(String str) {
//        if (str.length() <= 1) {
//            return str.length();
//        }
//
//        int f = 0; // for first
//        int l = f; // for last
//
//        int s = 0; // for size
//        char[] chars = str.toCharArray();
//        // 每次循环将窗口右边缘向右滑动
//        while (l++ < chars.length - 1) {
//            int i = charAt(chars, f, l, chars[l]);
//            // 窗口左边缘滑动至不重复的字符
//            f = i >= 0 ? i : f;
//            s = Math.max(l - f + 1, s);
//        }
//
//        return s;
//    }
//    private int charAt(char[] chars, int f, int l, char t) {
//        do {
//            if (chars[f++] == t) {
//                return f;
//            }
//        } while (f < l);
//        return -1;
//    }
//}

}