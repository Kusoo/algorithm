package leetcode.swap_nodes_in_k_groups;

/**
 * Created by l81022078 on 2017/8/1.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) return head;
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            if(cur == null)
                return head;
            cur = cur.next;
        }
        cur = head;
        for(int i = 0; i < k - 1; i++){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        cur.next = reverseKGroup(cur.next, k);
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