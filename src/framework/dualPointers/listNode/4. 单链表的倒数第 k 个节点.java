package framework.dualPointers.listNode;

/**
 * @author: Mr. Ye
 * @description: 19. 删除链表的倒数第 N 个结点
 * @createDate: 2024/03/20
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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    // 找到倒数第n+1个节点
    ListNode fromEnd = findFromEnd(dummy, n+1);
    // 将倒数第n+1个节点连接到倒数第n-1个节点
    fromEnd.next = fromEnd.next.next;
    return dummy.next;
  }

  /**
   * 返回链表的倒数第 k 个节点
   * 
   * @param head 链表头节点
   * @param k    链表倒数第k
   * @return 链表倒数第k个节点
   */
  private ListNode findFromEnd(ListNode head, int k) {
    if (head == null || k <= 0) {
      return null;
    }
    ListNode p1 = head;
    ListNode p2 = head;
    // p1先走k步
    for (int i = 0; i < k; i++) {
      p1 = p1.next;
    }
    // p1,p2一起走n-k步
    while (p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    // p2现在处于n-k+1个节点，即倒数第k个节点
    return p2;
  }
}