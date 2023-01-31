import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {

    // Insert a TreeNode: Iterative - Time: O(N) Space: O(N)
    public TreeNode insert1(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (val <= curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                } else {
                    queue.offer(curr.left);
                }
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                } else {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

    // Insert a TreeNode: Recursive - Time: O(N) Space: O(N)
    public TreeNode insert2(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val <= root.val)
            root.left = insert2(root.left, val);
        else
            root.right = insert2(root.right, val);
        return root;
    }

    // Inorder traversal: Recursive - Time: O(N) Space: O(N+N)
    public List<Integer> inorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
        return ans;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> inorder = new ArrayList<>();
        System.out.print(tree.inorder(root, inorder));
    }
}
