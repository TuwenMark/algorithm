package framework.dualPointers.listNode;

import java.util.PriorityQueue;

/**
 * @author: Mr. Ye
 * @description: 23. 合并 K 个升序链表
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
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    // 创建一个小根堆
    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
    // 将链表头放入小根堆
    for (ListNode head : lists) {
      if (head != null) {
        pq.add(head);
      }
    }
    // 依次弹出小根堆的元素
    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      cur.next = node;
      cur = cur.next;
      // 如果当前节点的下一个节点不为空，则将其放入小根堆
      if (node.next != null) {
        pq.add(node.next);
      }
    }
    return dummy.next;
  }
}
