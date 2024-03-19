package framwork.dual_pointers.list_node;

/**
 * @author: Mr. Ye
 * @description: Leetcode86 分隔链表
 * @createDate: 2024/03/19
 */
class ListNode {
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

class Solution {
  public ListNode partition(ListNode head, int x) {
    // 创建大小两个虚拟节点
    ListNode dummy1 = new ListNode(-1);
    ListNode dummy2 = new ListNode(-1);
    ListNode p1 = dummy1;
    ListNode p2 = dummy2;
    while (head != null) {
      // 根据条件构建两个链表
      if (head.val < x) {
        p1.next = head;
        p1 = p1.next;
      } else {
        p2.next = head;
        p2 = p2.next;
      }
      // 断开原链表
      ListNode temp = head.next;
      head.next = null;
      head = temp;
    }
    // 拼接两个链表
    p1.next = dummy2.next;
    return dummy1.next;
  }
}