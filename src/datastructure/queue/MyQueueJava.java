package datastructure.queue;

import java.util.ArrayList;

public class MyQueueJava<T>{
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
        MyQueueJava<Integer> mq = new MyQueueJava<Integer>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}
