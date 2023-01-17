import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class _106PostOrderTraversal {

    // Approach 1 : Recursive Time: O(N) Space: O(N+N)
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return solve(root, ans);
    }

    private List<Integer> solve(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;
        solve(root.left, ans);
        solve(root.right, ans);
        ans.add(root.val);
        return ans;
    }

    // Approach 2 : Iterative Time: O(N) Space: O(N)
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    ans.add(temp.val);

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
