package com.jobinesh.i7w.dailycoding;

public class BinaryTreeDeserializer {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int index=0;
        int start=0;
        int end = preorder.length-1;
        TreeNode node = buildTree(index,preorder,inorder,start, end );
        return node;
    }
    public TreeNode buildTree(int index, int[] preorder, int[] inorder, int start, int end) {

        if (index > preorder.length - 1 || start > end)
            return null;

        int rootVal = preorder[index];
        TreeNode node = new TreeNode();
        node.val=rootVal;
        int rootValIndex = getIndexOfValue( inorder, rootVal );
        TreeNode left = buildTree(index+1,preorder, inorder,start, rootValIndex-1  );
        TreeNode right = buildTree(index + rootValIndex - start +1,preorder, inorder,rootValIndex+1, end );
        node.right= right;
        node.left=left;
        return node;
    }
    private int getIndexOfValue( int[] inorder, int value){
        int index=-1;
        for(int i=0;i<inorder.length;i++){
            if( inorder[i]==value ){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args){
        System.out.println( new BinaryTreeDeserializer().buildTree( new int[]{3,9,20,15,7}, new int[]{ 9,3,15,20,7}) );
    }
}
