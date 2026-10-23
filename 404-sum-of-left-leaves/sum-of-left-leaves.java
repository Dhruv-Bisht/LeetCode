/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            // check the left child
            if(curr.left != null){
                // If it a leaf, add to sum
                if(curr.left.left == null && curr.left.right == null){
                    sum += curr.left.val;
                }
                else{
                    queue.offer(curr.left);
                }
            }

            // Always process the right child
            if(curr.right != null){
                queue.offer(curr.right);
            }
        }  
        return sum;
    }

}