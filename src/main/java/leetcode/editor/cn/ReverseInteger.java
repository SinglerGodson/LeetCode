//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 3247 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public static void main(String[] args) {
        int res = 0;

    }


    private static Integer[] split(int x) {
        List<Integer> l = new ArrayList<>();
        if (x == 0) {
            return new Integer[]{0};
        }
        while (x != 0) {
            l.add(x % 10);
            x /= 10;
        }
        return l.toArray(new Integer[l.size()]);
    }

    private static int join(Integer[] x) {
        int t = x[0];
        for (int i = 1; i < x.length; i++) {
            if (i >= 9) {
                int t0 = t;
                t *= 10;
                if (t / t0 != 10) {
                    return 0;
                }
            } else {
                t *= 10;
            }
            t += x[i];
        }
        return t;
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {



        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                    return 0;
                }
                res = res * 10 + x % 10;
                x /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}