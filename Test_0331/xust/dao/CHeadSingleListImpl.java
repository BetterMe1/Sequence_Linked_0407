package Test_0331.xust.dao;

import Test_0331.xust.impl.IClinked;

public class CHeadSingleListImpl implements IClinked {
    class Node{
        private int data;
        CHeadSingleListImpl.Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    public  CHeadSingleListImpl(){
        this.head = new Node(-1);
        this.head.next = this.head;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next.next;
        this.head.next = node;
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next != this.head){
            cur = cur.next;
        }
        cur.next = node;
        node.next = this.head;
    }

    @Override
    public boolean addindex(int index, int data) {
        checkIndex(index);
        Node node = new Node(data);
        Node cur = this.head.next;
        for(int i=0; i<index; i++){
            cur.next = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        return true;
    }
    private void checkIndex(int index){
        if(index <0 || index >=getLength()){
            throw new IndexOutOfBoundsException("传入参数不合法");
        }
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head.next;
        while(cur != this.head){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        int temp = 0;
        Node cur = searchPre(key);
        if(cur == null){
            throw new UnsupportedOperationException(key+"不存在");
        }
        temp = cur.next.data;
        cur.next =cur.next.next;
        return temp;
    }
    private Node searchPre(int key){
        Node cur = this.head;
        while(cur.next != this.head){
            if(cur.next.data == key){
               return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    @Override
    public void removeAllKey(int key) {
        Node cur = this.head;
        while(cur.next != this.head){
            if(cur.next.data == key){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head.next;
        while(cur != this.head){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        while (cur != head){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head.next != this.head){
            Node cur = this.head.next;
            this.head.next = cur.next;
            cur = null;
        }
        this.head = null;
    }
}
