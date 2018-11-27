import java.util.ArrayList;
import java.util.Comparator;

public class HeapSort{

    private static class Heap<E>{

        private final ArrayList<E> elements;
        private final Comparator<? super E> comparator;

        private int heapSize = 0;

        private Heap(ArrayList<E> list, Comparator<? super E> cmp){
            this.elements = list;
            this.comparator = cmp;
        }
        private void add(){
            heapSize++;     //array.length must be greater than heapSize
            checkPosition();
        }
        private void remove(){
            swap(0,heapSize-1);
            heapSize--;
            checkRoot();
        }
        private void checkPosition(){
            int index = heapSize - 1;
            while (hasParent(index) && compareElems(index,parent(index)) > 0) {
                swap(index, parent(index));
                index = parent(index);
            }
        }
        private void checkRoot() throws NullPointerException{
            int index = 0;
            int maxChildIndex = maxChild(index);
            while (hasChild(index) && compareElems(index,maxChildIndex) < 0) {
                swap(maxChildIndex, index);
                index = maxChildIndex;
                maxChildIndex = maxChild(index);
            }
        }
        private void swap(int index1, int index2){
            E aux = elements.get(index1);
            elements.set(index1,elements.get(index2));
            elements.set(index2,aux);
        }
        private int compareElems(int index1, int index2){
            return comparator.compare(elements.get(index1),elements.get(index2));
        }
        private int maxChild(int index){
            if((hasRight(index) && hasLeft(index) &&
                    compareElems(left(index),right(index))>0)||
                    hasLeft(index) && !hasRight(index)){
                return left(index);
            }else {
                return right(index);
            }
        }
        private static int parent(int index){
            return (index-1)/2;
        }
        private static int left(int index){
            return (index*2)+1;
        }
        private static int right(int index){
            return (index*2)+2;
        }
        private boolean hasLeft(int index){
            return left(index)< heapSize;
        }
        private boolean hasRight(int index){
            return right(index) < heapSize;
        }
        private boolean hasChild(int index){
            return hasLeft(index) || hasRight(index);
        }
        private boolean hasParent(int index){
            return index != 0;
        }
    }
    public static <E> void sort(ArrayList<E> list,Comparator<? super E> comp){
        Heap<E> heap = new Heap<>(list,comp);
        for(int i=0;i<list.size();i++){
            heap.add();
        }
        for(int i=0;i<list.size();i++){
            heap.remove();
        }
    }
    public static <E extends Comparable<? super E>> void sort(ArrayList<E> list){
            MyComparator<E> comp = new MyComparator<>();
            sort(list,comp);
    }
}