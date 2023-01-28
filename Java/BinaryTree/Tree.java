import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

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

class BinaryTreeDS {

    // Insert a TreeNode: Iterative - Time: O(N) Space: O(N)
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left == null) {
                temp.left = new TreeNode(val);
                break;
            } else
                q.add(temp.left);
            if (temp.right == null) {
                temp.right = new TreeNode(val);
                break;
            } else
                q.add(temp.right);
        }
        return root;
    }

    // Inorder traversal: Recursive - Time: O(N) Space: O(N+N)
    public List<Integer> inorder1(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;
        inorder1(root.left, ans);
        ans.add(root.val);
        inorder1(root.right, ans);
        return ans;
    }

    // Inorder traversal: Iterative - Time: O(N) Space: O(N)
    public List<Integer> inorder2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (true) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty())
                    break;
                curr = stack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }

    // Preorder traversal: Recursive - Time: O(N) Space: O(N+N)
    public List<Integer> preorder1(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;
        ans.add(root.val);
        preorder1(root.left, ans);
        preorder1(root.right, ans);
        return ans;
    }

    // Preorder traversal: Iterative - Time: O(N) Space: O(N)
    public List<Integer> preorder2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (true) {
            if (curr != null) {
                ans.add(curr.val);
                stack.add(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty())
                    break;
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return ans;
    }

    // Postorder traversal: Recursive - Time: O(N) Space: O(N+N)
    public List<Integer> postorder1(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;
        postorder1(root.left, ans);
        postorder1(root.right, ans);
        ans.add(root.val);
        return ans;
    }

    // Postorder traversal: Iterative - Time: O(N) Space: O(N)
    public List<Integer> postorder2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (true) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty())
                    break;
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

    // Sum of all TreeNodes: Recursive - Time: O(N) Space: O(N)
    public int sum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    // All even level TreeNodes: Recursive - Time: O(N) Space: O(N+N)
    public List<Integer> even(TreeNode root) {
        return evenHelper(root, true, new ArrayList<>());
    }

    public List<Integer> evenHelper(TreeNode root, boolean isEven, List<Integer> ans) {
        if (root == null)
            return ans;
        if (isEven == true)
            ans.add(root.val);
        evenHelper(root.left, !isEven, ans);
        evenHelper(root.right, !isEven, ans);
        return ans;
    }

    // All odd level TreeNodes: Recursive - Time: O(N) Space: O(N+N)
    public List<Integer> odd(TreeNode root) {
        return oddHelper(root, false, new ArrayList<>());
    }

    public List<Integer> oddHelper(TreeNode root, boolean isOdd, List<Integer> ans) {
        if (root == null)
            return ans;
        if (isOdd == true)
            ans.add(root.val);
        oddHelper(root.left, !isOdd, ans);
        oddHelper(root.right, !isOdd, ans);
        return ans;
    }

    // Get difference of values at Even & Odd level: Recursive - Time: O(N) Space:
    // O(N)
    public int getDiffEvenOdd(TreeNode root) {
        if (root == null)
            return 0;
        return root.val - getDiffEvenOdd(root.left) - getDiffEvenOdd(root.right);
    }

    // Number of TreeNodes in tree: Recursive - Time: O(N) Space: O(N)
    public int countTreeNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countTreeNodes(root.left) + countTreeNodes(root.right);
    }

    // Number of leaf TreeNodes in tree: Recursive - Time: O(N) Space: O(N)
    public int countLeafTreeNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null || root.right != null)
            return countLeafTreeNodes(root.left) + countLeafTreeNodes(root.right);
        else
            return 1;
    }

    // Get height of tree: Recursive - Time: O(N) Space: O(N)
    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        if (lheight > rheight)
            return lheight + 1;
        return rheight + 1;
    }

    // TreeNodes at kth level: Iterative - Time: O(N) Space: O(N)
    public ArrayList<Integer> kthLevelIter(TreeNode root, int level) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int k = 0, flag = 0;
        if (root == null || level < 0)
            return ans;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (k == level) {
                    flag = 1;
                    ans.add(temp.val);
                } else {
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                }
            }
            k++;
            if (flag == 1)
                break;
        }
        return ans;
    }

    // TreeNodes at kth level: Recursive - Time: O(N) Space: O(N+N)
    public List<Integer> kthLevel(TreeNode root, int level) {
        return kthLevelHelper(root, level, new ArrayList<>());
    }

    public List<Integer> kthLevelHelper(TreeNode root, int level, List<Integer> ans) {
        if (root == null || level < 0)
            return ans;
        if (level == 0)
            ans.add(root.val);
        level--;
        kthLevelHelper(root.left, level, ans);
        kthLevelHelper(root.right, level, ans);
        return ans;
    }

    // Level Order Traversal: Iterative - Time: O(N) Space: O(N)
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return ans;
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            ans.add(temp);
        }
        return ans;
    }

    // Level Order Traversal: Recursive - Time: O(N) Space: O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int h = height(root);
        for (int i = 0; i <= h; i++) {
            ans.add(kthLevel(root, i));
        }
        return ans;
    }

    // Reverse Level Order Traversal: Recursive - Time: O(N) Space: O(N)
    public List<List<Integer>> reverseLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int h = height(root);
        for (int i = h; i >= 0; i--) {
            ans.add(kthLevel(root, i));
        }
        return ans;
    }

    // Left view of tree: Iterative - Time: O(N) Space: O(N)
    public ArrayList<Integer> leftView1(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (i == 0)
                    ans.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return ans;
    }

    // Left view of tree: Recursive - Time: O(N) Space: O(N)
    public List<Integer> leftView2(TreeNode root) {
        return leftViewHelper(root, 0, new ArrayList<>());
    }

    private List<Integer> leftViewHelper(TreeNode root, int currDepth, ArrayList<Integer> ans) {
        if (root == null)
            return ans;
        if (ans.size() == currDepth)
            ans.add(root.val);
        leftViewHelper(root.left, currDepth + 1, ans);
        leftViewHelper(root.right, currDepth + 1, ans);
        return ans;
    }

    // Right view of tree: Iterative - Time: O(N) Space: O(N)
    public List<Integer> rightView1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (i == n - 1)
                    ans.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return ans;
    }

    // Right view of tree: Recursive - Time: O(N) Space: O(N)
    public List<Integer> rightView2(TreeNode root) {
        return rightViewHelper(root, 0, new ArrayList<>());
    }

    private List<Integer> rightViewHelper(TreeNode root, int currDepth, ArrayList<Integer> ans) {
        if (root == null)
            return ans;
        if (ans.size() == currDepth)
            ans.add(root.val);
        rightViewHelper(root.right, currDepth + 1, ans);
        rightViewHelper(root.left, currDepth + 1, ans);
        return ans;
    }

    class Pair<T, U> {
        T first;
        U second;

        Pair() {
        };

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    // Top view: Iterative - Time: O(N) Space: O(N)
    public ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>(); // hd, TreeNode
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>(); // (TreeNode, hd)

        if (root == null)
            return ans;
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            TreeNode temp = queue.peek().first;
            int h = queue.peek().second;
            queue.poll();
            if (!map.containsKey(h))
                map.put(h, temp.val);
            if (temp.left != null)
                queue.add(new Pair<>(temp.left, h - 1));
            if (temp.right != null)
                queue.add(new Pair<>(temp.right, h + 1));
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet())
            ans.add(m.getValue());
        return ans;
    }

    // Bottom view: Iterative - Time: O(N) Space: O(N)
    public ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        if (root == null)
            return ans;
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            TreeNode temp = queue.peek().first;
            int h = queue.peek().second;
            queue.poll();
            map.put(h, temp.val);
            if (temp.left != null)
                queue.add(new Pair<>(temp.left, h - 1));
            if (temp.right != null)
                queue.add(new Pair<>(temp.right, h + 1));
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet())
            ans.add(m.getValue());
        return ans;
    }

    // Zig-Zag Traversal: Iterative - Time: O(N) Space: O(N)
    public List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();

        if (root == null)
            return ans;
        int h = height(root);

        for (int i = 0; i < h; i++) {
            temp = kthLevel(root, i);
            if (i % 2 == 0)
                ans.add(temp);
            else {
                Collections.reverse(temp);
                ans.add(temp);
            }
        }
        return ans;
    }

    // Diagonal Traversal: Iterative - Time: O(N) Space: O(N)
    public ArrayList<Integer> diagonal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return ans;

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            while (temp != null) {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                ans.add(temp.val);
                temp = temp.right;
            }
        }
        return ans;
    }

    public void leftBoundary(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (root.left != null) {
            ans.add(root.val);
            leftBoundary(root.left, ans);
        } else if (root.right != null) {
            ans.add(root.val);
            leftBoundary(root.right, ans);
        }
    }

    public void rightBoundary(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (root.right != null) {
            ans.add(root.val);
            rightBoundary(root.right, ans);
        } else if (root.left != null) {
            ans.add(root.val);
            rightBoundary(root.left, ans);
        }
    }

    public void leaves(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            ans.add(root.val);
        else {
            if (root.left != null)
                leaves(root.left, ans);
            if (root.right != null)
                leaves(root.right, ans);
        }
    }

    // Boundary Traversal: Time: O(N) Space: O(N)
    public ArrayList<Integer> boundary(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;
        ans.add(root.val);
        leftBoundary(root.left, ans);
        leaves(root, ans);
        rightBoundary(root.right, ans);
        return ans;
    }

    // Diameter of tree: Recursive - Time: O(N2) Space: O(N)
    public int diameter(TreeNode root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    // Mirror of tree: Recursive - Time: O(N) Space: O(N)
    public TreeNode mirrorify(TreeNode root) {
        if (root == null)
            return null;
        TreeNode mirror = new TreeNode(root.val);
        mirror.right = mirrorify(root.left);
        mirror.left = mirrorify(root.right);
        return mirror;
    }

    // Check if tree is balanced: Recursive - Time*: O(N) Space: O(N)
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    // Root to Node path: Recursive - Time: O(N) Space: O(H)
    public List<Integer> getPathFromRoot(TreeNode root, int x) {
        List<Integer> ans = new ArrayList<>();
        getPathFromRootHelper(root, x, ans);
        return ans;
    }

    private boolean getPathFromRootHelper(TreeNode root, int x, List<Integer> ans) {
        if (root == null)
            return false;

        ans.add(root.val);
        if (root.val == x)
            return true;
        if (getPathFromRootHelper(root.left, x, ans) || getPathFromRootHelper(root.right, x, ans))
            return true;
        ans.remove(ans.size() - 1);
        return false;
    }

    // Check if two trees are identical: Recursive - Time: O(min(M,N)) Space:
    // O(min(H1, H2))
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Max-Path Sum: Recursive - Time: O(N) Space: O(N)
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, res);
        return res[0];
    }

    private int maxPathSumHelper(TreeNode root, int[] res) {
        if(root == null) return 0;
        int leftSum = Math.max(0, maxPathSumHelper(root.left, res));
        int rightSum = Math.max(0, maxPathSumHelper(root.right, res));
        res[0] = Math.max(res[0], leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }

}

public class Tree {
    public static void main(String[] args) {
        BinaryTreeDS tree = new BinaryTreeDS();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(13);
        root.left.left.left = new TreeNode(0);

        System.out.print("\n\nInorder :- ");
        System.out.print(tree.inorder2(root).toString());

        System.out.print("\n\nPreorder :- ");
        System.out.print(tree.preorder2(root).toString());

        System.out.print("\n\nPostorder :- ");
        System.out.print(tree.postorder2(root).toString());

        System.out.print("\n\nLevel order :- ");
        tree.levelOrder(root);

        System.out.print("\n\nReverse Level order :- ");
        tree.reverseLevelOrder(root);

        System.out.println("\n\nSum of all TreeNodes = " + tree.sum(root));
        System.out.println("\nDifference between even and odd level TreeNodes = " + tree.getDiffEvenOdd(root));
        System.out.print("\nAll even level TreeNodes = ");
        System.out.print(tree.even(root).toString());
        System.out.print("\n\nAll odd level TreeNodes = ");
        System.out.print(tree.odd(root).toString());
        System.out.println("\n\nNo. of TreeNodes = " + tree.countTreeNodes(root));
        System.out.println("\nNo. of Leaf TreeNodes = " + tree.countLeafTreeNodes(root));
        System.out.println("\nHeight of tree = " + tree.height(root));
        System.out.print("\nAll kth level TreeNodes = " + tree.kthLevelIter(root, 2));
        System.out.print("\n\nLeft View = " + tree.leftView1(root));
        System.out.print("\n\nRight View = " + tree.rightView1(root));
        System.out.print("\n\nTop View = " + tree.topView(root));
        System.out.print("\n\nBottom View = " + tree.bottomView(root));
        System.out.print("\n\nZig Zag Traversal = " + tree.zigzag(root));
        System.out.print("\n\nDiagonal Traversal = " + tree.diagonal(root));
        System.out.print("\n\nBoundary Traversal = " + tree.boundary(root));
        System.out.print("\n\nDiameter = " + tree.diameter(root));
        System.out.print("\n\nInorder of original tree :- ");
        System.out.print(tree.inorder2(root).toString());
        System.out.print("\n\nInorder of mirror tree :- ");
        System.out.print(tree.inorder2(tree.mirrorify(root)).toString());
        System.out.println("\n\nBalanced = " + tree.isBalanced(root));
    }
}