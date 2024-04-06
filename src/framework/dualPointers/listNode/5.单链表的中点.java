package framework.dualPointers.listNode;

/**
 * @author: Mr. Ye
 * @description: 876. 链表的中间结点
 * @createDate: 2024/04/06
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
  public ListNode middleNode(ListNode head) {
    if (head == null) {
      return head;
    }
    // 快慢指针初始化指向head
    ListNode slow = head;
    ListNode fast = head;
    // 快指针走到末尾时停止
    while (fast != null && fast.next != null) {
      // 慢指针走一步，快指针走两步
      slow = slow.next;
      fast = fast.next.next;
    }
    // 返回慢指针的位置
    return slow;
  }
}
