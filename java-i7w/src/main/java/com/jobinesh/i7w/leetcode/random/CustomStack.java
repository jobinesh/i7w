package com.jobinesh.i7w.leetcode.random;

import java.util.Arrays;

public class CustomStack {
    private int[] stack;
    int top=-1;
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize ];
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "stack=" + Arrays.toString(stack) +
                ", top=" + top +
                '}';
    }

    public void push(int x) {
        if(top == stack.length-1 ){
            return;
        }
        top++;
        stack[ top]=x;
    }

    public int pop() {
       if(top==-1){
           return -1;
       }
       int value = stack[top];
       stack[top]=0;
       top--;
       return value;
    }

    public void increment(int k, int val) {
        int upper = (k>top+1) ? top+1: k;
       for(int i=0;i<upper;i++){
           stack[ i] =  stack[ i]+ val;
       }
    }


    public static void main(String[] args){
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println( stack );
        stack.push(4);
        stack.push(5);
        System.out.println( stack );
        System.out.println(stack.pop());
        stack.increment(5,100);
        System.out.println( stack );
        stack.increment(2,100);
        System.out.println( stack );
        System.out.println( stack.pop());
    }
}
