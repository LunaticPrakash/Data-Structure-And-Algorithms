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

    // Search a TreeNode: Recursive - Time: O(H) Space: O(H)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        if (root.val < val)
            return searchBST(root.right, val);
        return searchBST(root.left, val);
    }

    // Sorted Array to BST: Recursive - Time: O(N) Space: O(N)
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int nums[], int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, l, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, r);
        return root;
    }

    // BST from Preorder: Recursive - Time: O(N) Space: O(N)
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorderHelper(int[] preorder, int start, int end) {
        if (start > end)
            return null;
        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);
        int i = start + 1;
        while (i <= end && preorder[i] < rootVal) {
            i++;
        }
        root.left = bstFromPreorderHelper(preorder, start+1, i-1);
        root.right = bstFromPreorderHelper(preorder, i, end);
        return root;
    }

    // Check if BT is BST: Recursive - Time: O(N) Space: O(N)
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long minValue, long maxValue) {
        if(root == null) return true;
        if(root.val >= maxValue || root.val <= minValue )
            return false;
        return isValidBSTHelper(root.left, minValue, root.val) && isValidBSTHelper(root.right, root.val, maxValue);
    }

    // LCA: Recursive - Time: O(N) Space: O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        int curr = root.val;

        if(curr > p.val && curr > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if(curr < p.val && curr < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
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
