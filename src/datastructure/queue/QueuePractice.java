package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePractice {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        // queqe에 넣기
        queue.add("a");
        queue.offer("b");
        System.out.println(queue);

        //queqe에서 젤 첫번째 보기
        System.out.println(queue.peek());
        System.out.println(queue);

        //queue에서 꺼내기 1
        System.out.println(queue.poll());
        System.out.println(queue);

        //queue에서 꺼내기 2
        System.out.println(queue.remove());
        System.out.println(queue);
    }
}
