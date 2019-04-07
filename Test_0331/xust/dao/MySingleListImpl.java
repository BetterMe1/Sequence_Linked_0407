package Test_0331.xust.dao;

import Test_0331.xust.impl.ILinked;

public class MySingleListImpl implements ILinked {
    class Node{
        private int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head;

    public MySingleListImpl(){
        this.head = null;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head != null){
            node.next = this.head;
        }
        this.head = node;
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else {
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if(cur == null){
            node.next = this.head;
            this.head = node;
        }else{
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }
    private Node searchIndex(int index){
        checkIndex(index);
        if(index == 0){
            return null;
        }
        int count = 0;
        Node cur = this.head;
        while(cur.next != null && count <index-1){
            cur = cur.next;
            count++;
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
        while(cur != null ){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        int temp ;
        if(!contains(key)){
            throw new UnsupportedOperationException("链表中不包含"+key+",不支持删除操作");
        }else {
            Node cur = searchKey(key);
            if(cur == null){
                temp = head.data;
                this.head = head.next;
            }else{
                temp = cur.next.data;
                cur.next = cur.next.next;
            }
        }
        return temp;
    }
    //返回上一位
    private Node searchKey(int key) {
        Node cur = this.head;
        while(cur.next != null ){
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    @Override
    public void removeAllKey(int key) {
        Node cur = head;
        while(cur.next != null){
            if(cur.next.data == key){
                cur.next = cur.next.next;
            }else{
                cur.next = cur.next;
            }
        }
        if(head.data == key){
            head = head.next;
        }
        /*while(contains(key)){
            remove(key);
        }*/
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
        Node cur = this.head;
        while(cur != null){
            this.head = cur.next;
            cur = null;
            cur = this.head;
        }
    }
}
