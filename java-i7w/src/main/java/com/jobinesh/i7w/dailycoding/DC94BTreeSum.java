package com.jobinesh.i7w.dailycoding;

public class DC94BTreeSum {
    static class TreeNode {
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
    static class  Sum{
        int value;
    }
    public int calculateSum(TreeNode root, int[] max) {
        if (root == null)
            return 0;

        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);

        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));

        max[0] = Math.max(max[0], Math.max(current, left + root.val + right));

        return current;
    }
    private int sum(TreeNode node, Sum sumSoFar){
        if(node==null){
            return 0;
        }
        int nodeVal = node.val;
        int sumLeft = sum(node.left, sumSoFar);
        int sumRight = sum(node.right, sumSoFar);
        int currentMax =Math.max(sumLeft , sumRight ) + nodeVal;
        sumSoFar.value=Math.max(Math.max(currentMax, sumLeft+sumRight+nodeVal ),sumSoFar.value) ;

          return currentMax;
    }
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left == null && root.right == null ){
            return root.val;
        }
        Sum sumSoFar = new Sum();
        sumSoFar.value = Integer.MIN_VALUE;
        sum(root, sumSoFar);
        return sumSoFar.value;
    }
    public static void main(String[] args){
        TreeNode tree = new TreeNode(-15);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(-8);
        tree.left.right = new TreeNode(1);
        tree.left.left.left = new TreeNode(2);
        tree.left.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(9);
        tree.right.right.right = new TreeNode(0);
        tree.right.right.right.left = new TreeNode(4);
        tree.right.right.right.right = new TreeNode(-1);
        tree.right.right.right.right.left = new TreeNode(10);
        System.out.println("Max pathSum of the given binary tree is "
                + new DC94BTreeSum().maxPathSum(tree));
    }
    public static void main1(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        System.out.println("Max pathSum of the given binary tree is "
                + new DC94BTreeSum().maxPathSum(tree));
    }
}
