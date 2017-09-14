package leetcode.flatten_binary_tree_to_linked_list;

/**
 * Created by l81022078 on 2017/8/8.
 */
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != null) {
            flatten(left);
            root.right = left;
            while(cur.right != null)
                cur = cur.right;
        }
        if(right != null) {
            flatten(right);
            cur.right = right;
        }
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
