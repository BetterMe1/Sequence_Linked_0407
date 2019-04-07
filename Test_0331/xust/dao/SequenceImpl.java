package Test_0331.xust.dao;
import Test_0331.xust.impl.ISequence;
import java.util.Arrays;

public class SequenceImpl implements ISequence {
    private int usedSize = 0;
    public static final int DEFULT_C = 10;
    private Object[] ele  = new Object[DEFULT_C];
    @Override
    public boolean add(int pos, Object data) {
        //1.判断
        //如果满了扩容
        if(isFull()){
            this.ele = Arrays.copyOf(this.ele,this.ele.length*2);
        }
        if(pos >=0 && pos<this.ele.length ){
            //2.挪数据
            System.arraycopy(this.ele,pos,this.ele,pos+1,this.usedSize-pos);
            //3.放入数据
            this.ele[pos] = data;
            this.usedSize++;
            return true;
        }
        return false;
    }
    private boolean isFull(){
        return this.usedSize == this.ele.length;
    }
    @Override
    public int search(Object key) {
        if(key == null){
            throw new UnsupportedOperationException("不支持null作为参数");
        }
        if(!isEmpty()) {
            for(int i=0; i<usedSize; i++){
                if(this.ele[i].equals(key)){
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean isEmpty(){
        if(this.usedSize == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object key) {
        if(key == null){
            throw new UnsupportedOperationException("不支持null作为参数");
        }
        if(!isEmpty()) {
            for(int i=0; i<usedSize; i++){
                if(this.ele[i].equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos >=0 && pos <this.usedSize){
            return this.ele[pos];
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        int pos = search(key);
        if(pos != -1){
            Object oldData = this.ele[pos];
            System.arraycopy(this.ele,pos+1,this.ele,pos,usedSize-pos-1);
            this.ele[usedSize-1] = null;
            usedSize--;
            return oldData;
        }
        return null;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for(int i=0; i<this.usedSize; i++) {
            System.out.print(this.ele[i]+" ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for(int i=0; i<this.usedSize; i++){
            this.ele[i] = null;
        }
        this.usedSize = 0;
    }
}
