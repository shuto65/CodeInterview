package Datastructure.MyQueue;

/**
 * Queue using circular bounded array.
 * Note that queue is allocated with size of (size+1).
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private Object[] queue;
    private int head=0;
    private int tail=0;

    public ArrayQueue(int size){
        queue = new Object[size+1];
    }

    //The three methods are for Unit tests. Ignore them.
    /*
    public E get(int index){
        return (E)queue[index];
    }

    public int getHead(){
        return head;
    }

    public int getTail(){
        return tail;
    }
    */

    /**
     * Add an element to the tail of the queue and increment the tail.
     * Note that tail points to an index AFTER the end of the queue.
     * @param data
     */
    @Override
    public void enqueue(E data) {
        if(isFull()) throw new FullQueueException("queue is full");

        queue[tail] = data;
        tail = (tail + 1) % queue.length;
    }

    /**
     * Acquire an element from the head of the queue and increment the head
     * @return
     */
    @Override
    public E dequeue() {
        if(isEmpty()) throw new EmptyQueueException("queue is empty");

        E ret = (E)queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        return ret;
    }

    /**
     * determines if the queue is empty or not
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * determines if the queue is full or not
     * @return
     */
    @Override
    public boolean isFull() {
        return size() == queue.length - 1;
    }

    /**
     * return the amount of elements the queue contains.
     * Note that the maximum size possible is queue.length - 1
     * @return
     */
    @Override
    public int size() {
        return (tail - head + queue.length) % queue.length;
    }
}
