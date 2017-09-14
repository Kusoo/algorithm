package leetcode.merge_two_sorted_list;

/**
 * Created by l81022078 on 2017/8/1.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        while(l1 != null && l2 != null){
            ListNode cur = null;
            if(l1.val <= l2.val){
                cur = l1;
                l1 = l1.next;
            }else{
                cur = l2;
                l2 = l2.next;
            }
            if(last == null)
                head = last = cur;
            else
                last = last.next = cur;
        }
        if(l1 != null){
            if(last == null)
                head = l1;
            else
                last.next = l1;
        }
        if(l2 != null){
            if(last == null)
                head = l2;
            else
                last.next = l2;
        }
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