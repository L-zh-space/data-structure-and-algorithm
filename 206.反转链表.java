/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
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

/**
 * 个人思路：temp值存储next，next指向当前, head后移,遍历
 * 思路错误，单个 tempNode 保存下一个节点，但在修改 head.next.next 时，没有提前保存 head.next 的原始值，导致链表断裂。
 */
// class Solution {
//   public ListNode reverseList(ListNode head) {
//     ListNode tempNode = head.next; // temp值存储next

//     while (head.next != null) {
//       head.next.next = head; // next指向当前
//       head = tempNode.next; // next后移
//       tempNode = head.next;
//     }

//     return head;
//   }
// }

/**
 * 优化思路：prev指向前置节点，curr指向当前节点，tempNode作为锚点存储下一节点
 * Solution
 */
class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null; 
    ListNode curr = head;

    while (curr != null) {
      ListNode temp = curr.next; // 锚点后移
      curr.next = prev; // 当前节点反指
      prev = curr; // 前置节点向当前移动，防止丢失
      curr = temp; // 当前节点后移
    }

    return prev;
  }
}
// @lc code=end
