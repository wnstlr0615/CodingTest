package datastructure.linkedlist;

public class DoubleLinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;
    public void addNode(T data){
        if(head == null){
            head = new Node<T>(data);
            tail = head;
        }else{
            Node<T> node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            tail = node.next;
        }
    }

    public void printAll(){
        if(head != null){
            System.out.println(head.data);
            Node<T> node = head;
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData){
        if(head != null){
            Node<T> node = head;
            while(node != null){
                if(node.data == isData){
                    return node.data;
                }else{
                    node = node.next;
                }
            }
        }
        return null;
    }

    public T searchFromTail(T isData){
        if(tail != null){
            Node<T> node = tail;
            while(node != null){
                if(node.data == isData){
                    return node.data;
                }else{
                    node = node.prev;
                }
            }
        }
        return null;
    }


    public class Node<T>{
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);

        MyLinkedList.printAll();

        System.out.println(MyLinkedList.searchFromHead(1));
        System.out.println(MyLinkedList.searchFromTail(1));
    }
}
