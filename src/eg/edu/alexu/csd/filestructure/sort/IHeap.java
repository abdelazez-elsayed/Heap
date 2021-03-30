package eg.edu.alexu.csd.filestructure.sort;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import eg.edu.alexu.csd.filestructure.sort.INode;

import java.util.Collection;

public interface IHeap<T extends Comparable<T>> extends Cloneable {
    INode<T> getRoot();

    int size();

    void heapify(INode<T> var1);

    T extract();

    void insert(T var1);

    void build(Collection<T> var1);
}

