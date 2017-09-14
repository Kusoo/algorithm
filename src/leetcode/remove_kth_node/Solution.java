package leetcode.remove_kth_node;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0)
            return head;
        ListNode right = head;
        for(int i = 0; i < n - 1; i++){
            if(right == null) return head;
            right = right.next;
        }
        ListNode prev = null;
        ListNode left = head;
        while(right.next != null){
            right = right.next;
            prev = left;
            left = left.next;
        }

        if(prev == null) return head.next;

        prev.next = prev.next.next;
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