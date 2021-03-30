package eg.edu.alexu.csd.filestructure.sort;


public interface INode<T extends Comparable<T>> {
    INode<T> getLeftChild();

    eg.edu.alexu.csd.filestructure.sort.INode<T> getRightChild();

    eg.edu.alexu.csd.filestructure.sort.INode<T> getParent();

    T getValue();

    void setValue(T var1);
}
