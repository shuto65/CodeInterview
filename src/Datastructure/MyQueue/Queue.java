package Datastructure.MyQueue;

/**
 * Created by inoueshuto on 2014/07/22.
 */
public interface Queue<E> {

    public void enqueue(E data);

    public E dequeue();

    public boolean isEmpty();

    public boolean isFull();

    public int size();
}
