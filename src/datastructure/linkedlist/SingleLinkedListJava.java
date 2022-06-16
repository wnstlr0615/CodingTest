package datastructure.linkedlist;

public class SingleLinkedListJava<T>{
    Node<T> head = null;

    public void addNode(T data){
        if(head == null){
            head = new Node<T>(data);
        }else{
            Node<T> node = this.head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }

    public void printAll(){
        if(head != null){
            System.out.println(head.data);
            Node<T> node = head;
            while(node.next != null){
                System.out.println(node.next.data);
                node = node.next;
            }
        }
    }
    public Node<T> search(T data){
        if(head == null){
            return null;
        } else{
            Node<T> node = head;
            while(node != null){
                if(node.data == data){
                    return node;
                }
                node = node.next;
            }
            return null;
        }
    }

    public void addNodeInside(T data, T isData){
        Node<T> searchNode = this.search(isData);

        if(searchNode == null){
            this.addNode(data);
        }else{
            Node<T> nextNode = searchNode.next;
            searchNode.next = new Node<T>(data);
            searchNode.next.next = nextNode;
        }
    }

    public boolean delNode(T isData){
        if(head == null){
            return false;
        }
        Node<T> node = head;
        if(node.data == isData){
            head = node.next;
            return true;
        }
        while(node.next != null){
            if(node.next.data == isData){
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }
    public class Node<T>{
        T data;
        Node<T> next = null;
        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        SingleLinkedListJava<String> linkedList = new SingleLinkedListJava<>();
        linkedList.addNode("hello");
        linkedList.addNode("hi1");
        linkedList.addNode("hi2");
        linkedList.addNode("hi3");
        linkedList.addNode("hi4");

        linkedList.addNodeInside("hello", "hi2");
        linkedList.delNode("hi4");
        linkedList.printAll();
    }
}
