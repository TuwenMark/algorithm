package framework.dualPointers.listNode;

/**
 * @author: Mr. Ye
 * @description: 83. 删除排序链表中的重复元素
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
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    // 初始化双指针指向头节点
    ListNode slow = head;
    ListNode fast = head;
    // 当fast指针到达末尾时结束
    while (fast != null) {
      // 维护[head...slow]的链表无重复
      if (fast.val != slow.val) {
        slow.next = fast;
        slow = slow.next;
      }
      fast = fast.next;
    }
    // 断开后续可能得重复结点
    slow.next = null;
    return head;
  }
}
