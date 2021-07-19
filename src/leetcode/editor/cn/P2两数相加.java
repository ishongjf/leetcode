package leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6469 👎 0


public class P2两数相加 {
    public static void main(String[] args) {
        P2两数相加 p2两数相加 = new P2两数相加();
        /*ListNode l1 = getListNode(new int[]{9, 9, 9, 9, 9, 9, 9}, 0);
        ListNode l2 = getListNode(new int[]{9, 9, 9, 9}, 0);
        l1 = Solution.addTwoNumbers(l1, l2);
        System.out.println("");*/
    }

    public static ListNode getListNode(int[] value, int index) {
        ListNode listNode = new ListNode();
        listNode.val = value[index];
        if (index < value.length - 1) {
            index++;
            listNode.next = getListNode(value, index);
        }
        return listNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l2 == null && l1 == null) {
                return null;
            }
            if (l1 == null || l2 == null) {
                l1 = l1 == null ? l2 : l1;
                if (l1.val > 9) {
                    l1.val = l1.val % 10;
                    ListNode next = l1.next;
                    if (next == null) {
                        next = new ListNode();
                        l1.next = next;
                        next.val = 1;
                    } else {
                        next.val += 1;
                        while (next.val > 9) {
                            next.val = next.val % 10;
                            if (next.next == null) {
                                next.next = new ListNode();
                                next.next.val = 1;
                            } else {
                                next.next.val += 1;
                            }
                            next = next.next;
                        }
                    }
                }
                return l1;
            }
            int val = l1.val + l2.val;
            if (val > 9) {
                l1.val = val % 10;
                l1.next = l1.next == null ? new ListNode(0) : l1.next;
                l1.next.val += 1;
            } else {
                l1.val = val;
            }

            l1.next = addTwoNumbers(l1.next, l2.next);
            return l1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}