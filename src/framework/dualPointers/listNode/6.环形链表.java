package framework.dualPointers.listNode;

/**
 * @author: Mr. Ye
 * @description: 141 / 142. 环形链表 —— 判断链表是否含有环，计算环的起点
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
  /**
   * 判断链表是否含有环
   * 
   * @param head 头节点
   * @return 是否包含环
   */
  public Boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    // 快慢指针初始化指向头节点
    ListNode slow = head;
    ListNode fast = head;
    // 快指针走到末尾时结束
    while (fast != null && fast.next != null) {
      // 慢指针走一步，快指针走两步
      slow = slow.next;
      fast = fast.next.next;
      // 如果快慢指针相遇，则说明有环
      if (slow == fast) {
        return true;
      }
    }
    // 快指针走到了末尾，说明没有环
    return false;
  }

  /**
   * 判断链表是否含有环，计算环的起点
   * 
   * @param head 头节点
   * @return 环的起点
   */
  public ListNode detectCycle(ListNode head) {
    // 快慢指针初始化指向头节点
    ListNode slow = head;
    ListNode fast = head;
    // 条件一：快指针走到末尾停止
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      // 条件二：快慢指针相遇也停止
      if (slow == fast) {
        break;
      }
    }
    // 快指针走到末尾则没有环
    if (fast == null || fast.next == null) {
      return null;
    }
    // 快慢指针相遇则有环，重置慢指针为head
    slow = head;
    // 同时一步步前进，二次相遇
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    // 相遇点即是环的起点
    return slow;
  }
}
