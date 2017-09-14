package leetcode.merge_k_sorted_list;

/**
 * Created by l81022078 on 2017/8/1.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0) return null;
        return mergeKLists(lists, 0, len - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start == end)
            return lists[start];
        if(start + 1 == end)
            return mergeTwoLists(lists[start], lists[end]);
        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

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