package traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by l81022078 on 2017/7/31.
 */
public class InOrder {
    public List<Integer> inOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.empty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                result.add(p.value);
                p = p.right;
            }
        }
        return result;
    }
}
