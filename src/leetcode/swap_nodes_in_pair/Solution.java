package leetcode.swap_nodes_in_pair;

/**
 * Created by l81022078 on 2017/8/1.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode prev = head.next;
        ListNode tmp = null;
        while (prev.next != null && (tmp = prev.next.next) != null) {
            prev.next.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
            prev = prev.next.next;
        }
        tmp = head.next;
        head.next = tmp.next;
        tmp.next = head;
        head = tmp;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}