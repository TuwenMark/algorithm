package framework.dualPointers.listNode;

/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
 * @author: Mr. Ye
 * @description: Leetcode21 合并两个有序链表
 * @createDate: 2024/03/10
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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // 创建虚拟头节点和双指针
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    ListNode node1 = list1;
    ListNode node2 = list2;

    // 双指针开始前进
    while (node1 != null && node2 != null) {
      if (node1.val <= node2.val) {
        cur.next = node1;
        node1 = node1.next;
      } else {
        cur.next = node2;
        node2 = node2.next;
      }
      cur = cur.next;
    }
    if (node1 != null) {
      cur.next = node1;
    }
    if (node2 != null) {
      cur.next = node2;
    }
    // 返回虚拟节点的下个节点
    return dummy.next;
  }
}
