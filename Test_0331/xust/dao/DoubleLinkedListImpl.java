package Test_0331.xust.dao;

import Test_0331.xust.impl.IDoubleLinked;

import java.util.function.DoubleToLongFunction;

public class DoubleLinkedListImpl implements IDoubleLinked {

    class Node{
        private int data;
        private Node prev;
        private Node next;
        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;
    private Node last;
    public DoubleLinkedListImpl(){
        this.head = null;
        this.last = null;
    }
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    @Override
    public boolean addindex(int index, int data) {
        if(index == 0){
            addFirst(data);
        }else if(index == getLength()){
            addLast(data);
        }else{
            Node node = new Node(data);
            Node cur = searchIndex(index);
            cur.prev.next = node;
            node.prev = cur.prev;
            node.next = cur;
            cur.prev = node;
        }
        return true;
    }
    private Node searchIndex(int index){
        checkIndex(index);
        Node cur = this.head;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        return cur;
    }
    private void checkIndex(int index){
        if(index <0 || index >=getLength()){
            throw new IndexOutOfBoundsException("传入参数不合法");
        }
    }
    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        int temp = -1;
        Node cur = this.head.next;
        if(this.head.data == key){
            temp = this.head.data;
            this.head = this.head.next;
            this.head.prev = null;
        }else{
            while(cur != null){
                if(cur.data == key){
                    temp = cur.data;
                    if(cur == last){
                        last = cur.prev;
                        cur.prev.next = null;
                    }else{
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                }
                cur = cur.next;
            }
        }
        return temp;
    }
    @Override
    public void removeAllKey(int key) {
        Node cur = this.head.next;
        if(this.head.data == key){
            this.head.next.prev = null;
            this.head.next = null;
        }else{
            while(cur != null){
                if(cur.data == key){
                    if(cur == last){
                        last = cur.prev;
                        cur.prev.next = null;
                    }else{
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                }
                cur = cur.next;
            }
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head != null){
            Node cur = this.head;
            this.head = cur.next;
            cur.next.prev = null;
            cur.next = null;
        }
    }
}
