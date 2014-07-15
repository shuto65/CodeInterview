package Datastructure;

import java.util.EmptyStackException;
import java.util.Stack;

public class myQueue {
    Stack enqueue_stack;
    Stack dequeue_stack;

    public myQueue(){
        enqueue_stack = new Stack();
        dequeue_stack = new Stack();
    }

    public void enqueue(int d){
        enqueue_stack.add(new Integer(d));
    }

    public Object dequeue(){
        if(dequeue_stack.empty()){
            if(enqueue_stack.empty()) throw new EmptyStackException();
            while(!enqueue_stack.empty())
                dequeue_stack.add(enqueue_stack.pop());
        }
        return dequeue_stack.pop();
    }

    public int size(){
        return enqueue_stack.size() + dequeue_stack.size();
    }
}
