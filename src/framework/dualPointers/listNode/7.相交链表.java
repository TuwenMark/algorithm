package framework.dualPointers.listNode;

/**
 * @author: Mr. Ye
 * @description: 160. 相交链表
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
   * 链表AB是否相交，相交返回第一个相交结点，否则返回null
   * 
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // 两个指针初始化指向两个头节点
    ListNode p1 = headA;
    ListNode p2 = headB;
    // p1和p2一直前进，直到相遇
    while (p1 != p2) {
      // 连接headA和headB，这样总长度固定
      if (p1 == null) {
        p1 = headB;
      } else {
        p1 = p1.next;
      }
      if (p2 == null) {
        p2 = headA;
      } else {
        p2 = p2.next;
      }
    }
    return p1;
  }
}
