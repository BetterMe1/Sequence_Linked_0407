package Test_0331.xust.main;
import Test_0331.xust.dao.CHeadSingleListImpl;
import Test_0331.xust.dao.DoubleLinkedListImpl;
import Test_0331.xust.dao.MySingleListImpl;
import Test_0331.xust.dao.SequenceImpl;

import java.sql.SQLOutput;

/*
public class TestMain extends SequenceImpl {
    public static void main(String[] args) {
        MySingleListImpl mySingleList = new MySingleListImpl();
        mySingleList.addFirst(5);
        mySingleList.addLast(10);
        mySingleList.addIndex(1,30);
        mySingleList.addLast(30);
        mySingleList.display();//5 30 10 30
        System.out.println(mySingleList.contains(30));//true
        System.out.println(mySingleList.getLength());//4
        mySingleList.remove(10);
        mySingleList.removeAllKey(30);
        mySingleList.display();//5

    }
    public static void main1(String[] args) {
        SequenceImpl sequence = new SequenceImpl();
        for(int i=0; i<10; i++) {
            sequence.add(i, i);
        }
        sequence.display();//0 1 2 3 4 5 6 7 8 9
        sequence.add(10,"java");
        sequence.display();//0 1 2 3 4 5 6 7 8 9 java
        System.out.println(sequence.search("java"));//10
        System.out.println(sequence.contains(5));//true
        System.out.println(sequence.getPos(3));//3
        sequence.remove("java");//0 1 2 3 4 5 6 7 8 9
        sequence.display();
        sequence.clear();
        sequence.display();
    }
}
*/

/*public class TestMain extends CHeadSingleListImpl {
    public static void main(String[] args) {
        CHeadSingleListImpl cHeadSingleList = new CHeadSingleListImpl();
        cHeadSingleList.addFirst(5);
        cHeadSingleList.addLast(10);
        cHeadSingleList.addindex(1,30);
        cHeadSingleList.addLast(30);
        cHeadSingleList.display();//5 30 10 30
        System.out.println(cHeadSingleList.contains(30));//true
        System.out.println(cHeadSingleList.getLength());//4
        cHeadSingleList.remove(10);
        cHeadSingleList.display();//5 10 30
        cHeadSingleList.removeAllKey(30);
        cHeadSingleList.display();//5
    }
}*/
public class TestMain extends DoubleLinkedListImpl {
    public static void main(String[] args) throws InterruptedException {
        DoubleLinkedListImpl doubleLinkedList = new DoubleLinkedListImpl();
        doubleLinkedList.addFirst(5);
        doubleLinkedList.addLast(10);
        doubleLinkedList.addindex(1,30);
        doubleLinkedList.addLast(30);
        doubleLinkedList.display();//5 30 10 30
        System.out.println(doubleLinkedList.contains(30));//true
        System.out.println(doubleLinkedList.getLength());//4
        doubleLinkedList.remove(10);
        doubleLinkedList.display();//5 10 30
        doubleLinkedList.clear();
        doubleLinkedList.display();
       // Thread.sleep(1000);
        //System.out.println("mmm");
        // doubleLinkedList.removeAllKey(30);
        //doubleLinkedList.display();//5
    }
}