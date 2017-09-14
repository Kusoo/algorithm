package leetcode.level_order;

import java.util.*;

/**
 * Created by l81022078 on 2017/8/10.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> first = new LinkedList<>();
        Queue<TreeNode> second = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) first.offer(root);
        boolean reverse = false;
        while (!first.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!first.isEmpty()) {
                TreeNode node = first.poll();
                list.add(node.val);
                if (node.left != null) second.offer(node.left);
                if (node.right != null) second.offer(node.right);
            }
            Queue<TreeNode> tmp = first;
            first = second;
            second = tmp;
            if (reverse) {
                Collections.reverse(list);
                result.add(list);
            }else
                result.add(list);
            reverse = !reverse;
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}