package ds.stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue1 = new LinkedList();
    Queue<Integer> queue2 = new LinkedList();

    public void push(int i) {
        queue1.add(i);
    }

    public int pop() {
        if(queue1.isEmpty()){
            return -1;
        }
        int size = 0;
        while (size < queue1.size() - 1) {
            queue2.add(queue1.poll());
            size++;
        }
        int output = queue1.poll();
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return output;

    }

    public static void main(String[] args) {
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        stackUsingQueue.push(3);
        stackUsingQueue.push(4);
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.pop());


    }
}
