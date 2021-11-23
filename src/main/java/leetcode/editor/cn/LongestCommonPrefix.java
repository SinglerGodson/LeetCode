//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1877 👎 0

package leetcode.editor.cn;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = new String[]{
                "dog","racecar","car"
        };
        System.out.println(solution.longestCommonPrefix(strs));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String t = null;
            int minLength = Integer.MAX_VALUE;
            for (String s : strs) {
                if (minLength > s.length()) {
                    minLength = s.length();
                    t = s;
                }
            }

            for (int i = 0 ; i < t.length(); i++) {
                char a = t.charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    String s = strs[j];
                    if (a != s.charAt(i)) {
                        return t.substring(0, i);
                    }
                }
            }
            return t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}