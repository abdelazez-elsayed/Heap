package eg.edu.alexu.csd.filestructure.sort;

public class Node<T extends Comparable<T>> implements INode<T>{
    private  T value;
    private int index;
    Heap heap;
    public Node(int i,Heap heap){
        index = i;
        this.heap=heap;
    }
    public Node(int i,Heap heap,T value){
        index = i;
        this.heap=heap;
        this.value=value;
    }

    @Override
    public INode getLeftChild() {
        try {
            if (2 * index + 1 < heap.size())
                return (INode) heap.MyHeapArray.get(2 * index + 1);
        }catch (NullPointerException e) {
            return  null;
        }
        return  null;
    }

    @Override
    public INode getRightChild() {
        try {
            if (2 * index + 2 < heap.size())
                return (INode) heap.MyHeapArray.get(2 * index + 2);
        }
        catch (NullPointerException e) {
            return  null;
        }
        return  null;
    }

    @Override
    public INode getParent() {
        try {
            if (index != 0) {
                if (index - 1 / 2 >= 0)
                    return (INode) heap.MyHeapArray.get((index - 1) / 2);
            }
        }
        catch (NullPointerException e) {
            return  null;
        }
        return  null;
    }

    @Override
    public T getValue() {
        return value;
    }


    public void setValue(T var1) {
        this.value=var1;
    }

}