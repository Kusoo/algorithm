package traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by l81022078 on 2017/7/31.
 */
public class PreOrder {
    public List<Integer> preOrder(TreeNode root){
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();

        if(root != null)
            stack.push(root);

        while(!stack.empty()){
            TreeNode p = stack.pop();
            result.add(p.value);

            if(p.right != null)
                stack.push(p.right);
            if(p.left != null)
                stack.push(p.left);
        }
        return result;
    }
}
