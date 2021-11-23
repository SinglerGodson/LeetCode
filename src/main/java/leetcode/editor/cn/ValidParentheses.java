//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2367 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */



    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        // 放置未配对的字符
        char[] chars = new char[s.length() / 2 + 1];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            chars[count] = s.charAt(i);
            //编码差为2 或者 1 累计数量--
            if (count != 0 && isValid(chars[count], chars[count - 1])) {
                count--;
            } else {
                count++;
            }
            if (count > s.length() / 2) {
                return false;
            }
        }
        return count == 0 ;
    }

    private boolean isValid(char c1 , char c2) {
        int r = c1 - c2;
        return r == 1 || r == 2;
    }


//    public static void main(String[] args) {
//        long s = System.currentTimeMillis();
//        System.out.println(new ValidParentheses().isValid("()")); ;
//        System.out.println(System.currentTimeMillis() - s);
//    }
//    //leetcode submit region begin(Prohibit modification and deletion)
//
//    public boolean isValid(String s) {
//        if (s.length() % 2 == 1) {
//            return false;
//        }
//        Deque<Character> leftDeque = new LinkedList<>();
//        int half = s.length() / 2 + 1;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            char left = getLeft(c);
//            if (left == 'a') {
//                leftDeque.push(c);
//                if (leftDeque.size() > half) {
//                    return false;
//                }
//            } else {
//                if (!leftDeque.isEmpty()) {
//                    char l = leftDeque.pop();
//                    if (!isMatch(c, l)) {
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//            }
//        }
//        return leftDeque.isEmpty();
//    }
//
//
//    public Character getLeft(char right) {
//        switch (right) {
//            case '}': return '{';
//            case ']': return '[';
//            case ')': return '(';
//            default: return 'a';
//        }
//    }
//
//    public boolean isMatch(char r, char l) {
//        return (l == '{' && r == '}')
//                || (l == '[' && r == ']')
//                || (l == '(' && r == ')');
//    }


    // 执行用时：1 ms, 在所有 Java 提交中击败了99.14%的用户
    // 内存消耗：36.4 MB, 在所有 Java 提交中击败了92.38%的用户


//leetcode submit region end(Prohibit modification and deletion)

}