package ds.stackAndqueue;

import java.util.Stack;

public class QueueUsingTwoStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int i) {
        stack1.push(i);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        QueueUsingTwoStack queueUsingTwoStack = new QueueUsingTwoStack();
        queueUsingTwoStack.push(1);
        queueUsingTwoStack.push(2);
        queueUsingTwoStack.push(3);
        queueUsingTwoStack.push(4);
        System.out.println(queueUsingTwoStack.pop());
        System.out.println(queueUsingTwoStack.pop());
        System.out.println(queueUsingTwoStack.pop());
        System.out.println(queueUsingTwoStack.pop());

    }

}
