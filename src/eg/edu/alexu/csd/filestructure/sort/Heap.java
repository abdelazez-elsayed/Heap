package eg.edu.alexu.csd.filestructure.sort;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collection;

public class Heap<T extends Comparable<T>> implements IHeap<T> {
    private int size;
    private ArrayList<T> arr = new ArrayList<>();
    ArrayList<INode> MyHeapArray = new ArrayList<INode>();
    @Override
    public INode getRoot() {
        if(size==0)return null;
        try {
            return MyHeapArray.get(0);

        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T extract() {
        try {

            T val = (T) this.getRoot().getValue();
            if(size > 0) {
                INode MaxValue = MyHeapArray.get(size - 1);
                INode Root = MyHeapArray.get(0) ;
                Swap( Root,  MaxValue);
                size--;
                if(!(MaxValue.getValue().equals(Root.getValue()))) {
                    this.heapify(this.getRoot());
                }
                return val;
            }else {
                return null;
            }

        }catch (NullPointerException E ){
            return null ;
        }

    }

    @Override
    public void heapify(INode iNode) {
        int c=-1;

        while (c<=0) {
            try {
                int L;
                if(iNode.getLeftChild()==null){
                    c = iNode.getValue().compareTo(iNode.getRightChild().getValue());
                    if (c <= 0) {
                        Swap(iNode, iNode.getRightChild());
                        iNode = iNode.getRightChild();
                    }
                }
                else if(iNode.getRightChild()==null){
                    c = iNode.getValue().compareTo(iNode.getLeftChild().getValue());
                    if (c <= 0) {
                        Swap(iNode, iNode.getLeftChild());
                        iNode = iNode.getLeftChild();
                    }
                }
                else {
                    L = iNode.getLeftChild().getValue().compareTo(iNode.getRightChild().getValue());
                    if (L <= 0) {
                        c = iNode.getValue().compareTo(iNode.getRightChild().getValue());
                        if (c <= 0) {
                            Swap(iNode, iNode.getRightChild());
                            iNode = iNode.getRightChild();
                        }
                    } else {
                        c = iNode.getValue().compareTo(iNode.getLeftChild().getValue());
                        if (c <= 0) {
                            Swap(iNode, iNode.getLeftChild());
                            iNode = iNode.getLeftChild();
                        }
                    }
                }
            }catch (NullPointerException e ){
                c=1;
            }
        }
    }


    @Override
    public void insert(T value) {
        if ( value != null) {
            Node node = new Node(size, this,value);
            size++;
            MyHeapArray.add(size-1,node);
            try {
                int c = node.getValue().compareTo(node.getParent().getValue());
                while (c > 0) {
                    c = node.getValue().compareTo(node.getParent().getValue());
                    if (c > 0) {

                        Swap(node, node.getParent());
                        node = (Node) node.getParent();
                    }
                }
            } catch (NullPointerException e) {

            }
        }
    }

    @Override
    public void build(Collection collection) {
        try {

            arr.addAll(collection);
            size = arr.size();
            for (int i = 0; i < arr.size(); i++) {
                Node<T> node = new Node<>(i, this, arr.get(i));
                MyHeapArray.add(node);
            }
            for (int i = size/2 -1 ; i >= 0; --i) {
                heapify(MyHeapArray.get(i));
            }
        }catch (NullPointerException e){

        }

    }
    private void Swap(INode first,INode Second){
        T temp = (T) first.getValue();
        first.setValue(Second.getValue());
        Second.setValue(temp);

    }

    public Heap<T> Clone() throws CloneNotSupportedException {
        Heap<T> temp = new Heap<>();
        temp.build(arr);
        return temp;
    }
    public void setSize(int s){
        this.size=s;
    }
    private void setMyHeapArray(ArrayList<INode> arr){
        MyHeapArray = arr;
    }
}