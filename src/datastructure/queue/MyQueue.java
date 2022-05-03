package datastructure.queue;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyQueue <T>{
    ArrayList<T>  queue = new ArrayList<T>();

    public T dequeue(){
        if(!queue.isEmpty()){
            return queue.remove(0);
        }
        return null;
    }

    public boolean enqueue(T item){
        return queue.add(item);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}
