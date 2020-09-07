package com.jobinesh.i7w.dailycoding;

public class InorderTreeEvaluation {
    static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(String val) {
            this.val = val;
        }

        TreeNode(String val, TreeNode left, TreeNode right) {
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
    public String evaluate(TreeNode node){
        if( node.left == null && node.right == null){
            return node.val;
        }
        String op1 = evaluate( node.left);
        String operator = node.val;
        String op2 = evaluate( node.right);
        return evaluateValue(op1,operator,op2 );
    }
    public String evaluateValue(String opText1, String operator, String opText2){
        int op1 = Integer.valueOf(opText1) ;
        int op2 = Integer.valueOf(opText2) ;
        int result = 0;
        switch(operator){
            case "+": result = op1+ op2;
            break;
            case "-": result = op1 - op2;
                break;
            case "*": result = op1 * op2;
                break;
            case "/": result = op1 / op2;
                break;
        }
        return String.valueOf(result);
    }
    public static void main(String[] args){
        TreeNode nodeMul = new TreeNode();
        nodeMul.val="+";
        TreeNode nodePlus1 = new TreeNode();
        nodePlus1.val="*";
        nodeMul.left=nodePlus1;
        TreeNode nodePlus2 = new TreeNode();
        nodePlus2.val="-";
        nodeMul.right=nodePlus2;
        TreeNode nodeOp1 = new TreeNode();
        nodeOp1.val = "5";
        nodePlus1.left=nodeOp1;
        TreeNode nodeOp2 = new TreeNode();
        nodeOp2.val = "4";
        nodePlus1.right=nodeOp2;
        TreeNode nodeOp3 = new TreeNode();
        nodeOp3.val = "100";
        nodePlus2.left=nodeOp3;
        TreeNode nodeOp4 = new TreeNode();
        nodeOp4.val = "20";
        nodePlus2.right=nodeOp4;
        System.out.println(new InorderTreeEvaluation().evaluate(nodeMul) );
    }
}
