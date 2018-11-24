import java.util.ArrayList;
import java.util.Comparator;

public class HeapSort{

    private static class Heap<E>{

        private final ArrayList<E> elements;
        private final Comparator<? super E> comparator;

        private int heapSize = 0;

        public Heap(ArrayList<E> list){
            this.elements = list;
            this.comparator = null;
        }
        public Heap(ArrayList<E> list, Comparator<? super E> cmp){
            this.elements = list;
            this.comparator = cmp;
        }
        public void add(){
            heapSize++;     //array.length ha de ser major que heapSize
            checkPosition();
        }
        private void checkPosition(){
            int index = heapSize - 1;
            while(hasParent(index) && comparator.compare(elements.get(index),elements.get(parent(index))) > 0){
                    swap(index,parent(index));
                    index = parent(index);
            }
        }
        private void swap(int index1, int index2){
            E aux = elements.get(index1);
            elements.set(index1,elements.get(index2));
            elements.set(index2,aux);
        }
        public void remove(){
            swap(0,heapSize-1);
            heapSize--;
            checkHead();
        }
        public void checkHead(){
            int index = 0;
            int biggestChildIndex = biggestChild(index);
            while(hasChild(index) && comparator.compare(elements.get(index),elements.get(biggestChildIndex))<0){
                swap(biggestChildIndex,index);
                index = biggestChildIndex;
            }
        }
        public int biggestChild(int index){
            if(comparator.compare(elements.get(left(index)),elements.get(right(index)))>0){
                return left(index);
            }else{
                return right(index);
            }
        }

        private static int parent(int index){
            if(index%2 == 0){
                return (index/2) -1;
            }else{
                return ((index+1)/2)-1;
            }
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
        Heap heap = new Heap(list,comp);
        for(int i=0;i<list.size();i++){
            heap.add();
        }
        for(int i=0;i<list.size();i++){
            heap.remove();
        }
    }
    public static <E extends Comparable<? super E>> void sort(ArrayList<E> list){

    }
}
