//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1684 👎 0

package leetcode.editor.cn;
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode t = mergeTwoLists(l1, l2);
        do {
            System.out.println(t.val);
            t = t.next;
        } while (t.next != null);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
//        ListNode bigger = l1;
//        ListNode smaller = l2;
//        if (l1.val < l2.val) {
//            bigger = l2;
//            smaller = l1;
//        }
//        ListNode result = smaller;
//        result.next = mergeTwoLists(result.next, bigger);
//
        boolean l2Bigger = l1.val < l2.val;
        ListNode result = l2Bigger ? l1 : l2;
        result.next = mergeTwoLists(result.next, l2Bigger ? l2 : l1);

        return result;
    }




    public static class ListNode {
        int val;
        ListNode next;

        ListNode(){}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }



}
//leetcode submit region end(Prohibit modification and deletion)