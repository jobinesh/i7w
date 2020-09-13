package com.jobinesh.i7w.dailycoding;

import java.util.Stack;

/*
Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out)
data structure with the following methods: enqueue, which inserts an element into the queue,
and dequeue, which removes it.
 */
public class QueueByStack {
    Stack inbox = new Stack();
    Stack outbox = new Stack();

    public void enqueue(Object obj) {
        inbox.push(obj);

    }

    public Object dequeue() {
        while (inbox.size() > 0) {
            outbox.push(inbox.pop());
        }
        return outbox.pop();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inbox.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (inbox.size() > 0) {
            outbox.push(inbox.pop());
        }
        return (int) outbox.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outbox.size() == 0) {
            while (inbox.size() > 0) {
                outbox.push(inbox.pop());
            }
        }
        return (int) outbox.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inbox.size() == 0 && outbox.size() == 0;
    }

    public static void main(String[] args) {
        QueueByStack queueByStack = new QueueByStack();
        queueByStack.enqueue(1);
        queueByStack.enqueue(2);
        queueByStack.enqueue(3);
        System.out.println(queueByStack.dequeue());
        System.out.println(queueByStack.dequeue());
        System.out.println(queueByStack.dequeue());
    }
}
