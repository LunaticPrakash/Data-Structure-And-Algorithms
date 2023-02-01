import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        root.left = bstFromPreorderHelper(preorder, start + 1, i - 1);
        root.right = bstFromPreorderHelper(preorder, i, end);
        return root;
    }

    // Check if BT is BST: Recursive - Time: O(N) Space: O(N)
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (root.val >= maxValue || root.val <= minValue)
            return false;
        return isValidBSTHelper(root.left, minValue, root.val) && isValidBSTHelper(root.right, root.val, maxValue);
    }

    // LCA: Recursive - Time: O(N) Space: O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        int curr = root.val;

        if (curr > p.val && curr > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (curr < p.val && curr < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    // Floor in BST: Interative - Time:O(H) Space:O(1)
    public int floorInBST(TreeNode root, int X) {
        int floor = -1;
        while (root != null) {
            if (root.val == X) {
                floor = X;
                return floor;
            }
            if (X > root.val) {
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }

    // Ceil in BST: Interative - Time:O(H) Space:O(1)
    public static int findCeil(TreeNode root, int X) {
        int ceil = -1;
        while (root != null) {
            if (root.val == X) {
                ceil = X;
                return ceil;
            }
            if (X < root.val) {
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }

    // kth Smallest element in BST: Recursive - Time:O(N) Space:O(N)
    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> in = inorder(root, new ArrayList<>());
        return in.get(k - 1);
    }

    // kth Smallest element in BST: Recursive - Time:O(N) Space:O(N)
    public int kthSmallest2(TreeNode root, int k) {
        int[] count = new int[1];
        int[] ans = new int[1];
        kthSmallest2Helper(root, k, count, ans);
        return ans[0];
    }

    private void kthSmallest2Helper(TreeNode root, int k, int[] count, int[] ans) {
        if (root == null)
            return;
        kthSmallest2Helper(root.left, k, count, ans);
        count[0] += 1;
        if (count[0] == k) {
            ans[0] = root.val;
            return;
        }
        kthSmallest2Helper(root.right, k, count, ans);
    }

    // kth Largest element in BST: Recursive - Time:O(N+N) Space:O(N)
    public int kthLargest(TreeNode root, int k) {
        int[] count = new int[1];
        int[] ans = new int[1];
        int nElem = countTreeNodes(root);
        kthLargestHelper(root, k, nElem, count, ans);
        return ans[0];
    }

    private void kthLargestHelper(TreeNode root, int k, int nElem, int[] count, int[] ans) {
        if (root == null)
            return;
        kthLargestHelper(root.left, k, nElem, count, ans);
        count[0] += 1;
        if (count[0] == nElem - k) {
            ans[0] = root.val;
            return;
        }
        kthLargestHelper(root.right, k, nElem, count, ans);
    }

    // Number of TreeNodes in tree: Recursive - Time: O(N) Space: O(N)
    public int countTreeNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countTreeNodes(root.left) + countTreeNodes(root.right);
    }

    // BST Iterator: Iterative - Time: O(1){for next() & hasNext()} Space: O(N)
    class BSTIterator1 {

        private List<Integer> in = new ArrayList<>();
        private int count;
    
        public List<Integer> inorder(TreeNode root, List<Integer> ans) {
            if (root == null)
                return ans;
            inorder(root.left, ans);
            ans.add(root.val);
            inorder(root.right, ans);
            return ans;
        }
    
        public BSTIterator1(TreeNode root) {
            this.in = inorder(root, new ArrayList<>());
            this.count = 0;
        }
        
        public int next() {
            return this.in.get(count++);
        }
        
        public boolean hasNext() {
            return this.in.size() > count;
        }
    }

    // BST Iterator: Iterative - Time: O(1){for next() & hasNext()} Space: O(H)
    class BSTIterator2 {

        private Stack<TreeNode> stack = new Stack<>();
    
        public BSTIterator2(TreeNode root) {
            pushAllLeftNodes(root);
        }
        
        public int next() {
            TreeNode temp = stack.pop();
            pushAllLeftNodes(temp.right);
            return temp.val;
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    
        public void pushAllLeftNodes(TreeNode node){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
    }

    // Encodes a tree to a single string: Iterative - Time: O(N) Space: O(N)
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                res.append("#");
            }
            else{
                res.append(curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
            res.append(",");
        }
        return res.toString();
    }

    // Decodes your encoded data to tree: Iterative - Time: O(N) Space: O(N)
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        for(int i=1; i<nodes.length; i++){
            TreeNode curr = queue.poll();
            if(!nodes[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = left;
                queue.offer(left);
            }
            if(!nodes[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = right;
                queue.offer(right);
            }
        }
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
