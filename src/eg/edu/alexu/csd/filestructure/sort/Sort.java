package eg.edu.alexu.csd.filestructure.sort;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Sort<T extends Comparable<T>> implements ISort<T> {
    private List list;

    @Override
    public IHeap<T> heapSort(ArrayList<T> arrayList) {
        try {
            Heap<T> heap = new Heap<>();

            heap.build(arrayList);

            if(arrayList != null){
                int size = arrayList.size();
                int s = size;
                while (heap.size()!=0){
                    arrayList.set(--size,heap.extract());
                }
                heap.setSize(s);
            }


            return heap;
        } catch (Exception e) {
            return null ;
        }
    }

    @Override



    public void sortSlow(ArrayList<T> var1) {
        try{
            for (int i = 0; i < var1.size(); i++) {
                int Min = i;
                for (int j = i + 1; j < var1.size(); j++) {
                    int c = var1.get(Min).compareTo(var1.get(j));
                    if (c > 0) Min = j;
                }
                T temp = var1.get(i);
                var1.set(i, var1.get(Min));
                var1.set(Min, temp);
            }}catch (NullPointerException e){

        }
    }
    private void Swap(ArrayList<T> arr ,int i , int j){
        T temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    @Override
    public void sortFast(ArrayList unordered) {
        // TODO Auto-generated method stub
        if(unordered ==null)
            return;

        list = unordered;

        // div(0,unordered.size()-1);

        part(0,unordered.size()-1);

    }


    public void part(int l,int r) {
        if(l<r) {
            part(l,(l+r)/2);
            part((l+r)/2+1,r);
            mergesort(l,r);
        }


    }
    public void mergesort(int l,int r)  {

        int mid=(l+r)/2+1,i=l,j=mid;
        Vector<Object> temp=new Vector();
        while(i<mid&&j<=r) {

            Comparable<T> x=(Comparable<T>)list.get(i);
            Comparable<T> y=(Comparable<T>)list.get(j);
            if(x.compareTo((T)y)<0) {
                temp.add(list.get(i++));
            }
            else {
                temp.add(list.get(j++));
            }

        }
        while(i<mid) {
            temp.add(list.get(i++));
        }
        while(j<=r) {
            temp.add(list.get(j++));
        }
        j=0;
        for(i=l;i<=r;i++) {
            list.set(i, temp.get(j++));
        }

    }

}