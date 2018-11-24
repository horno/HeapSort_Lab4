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
            while(hasParent(index) && parent(index)<){

            }
        }
        public void remove(int index){
            /* Remove code ? */
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
        private boolean hasParent(int index){
            return index != 0;
        }
    }
    public static <E extends Comparable<? super E>> void sort(ArrayList<E> list){

    }
}
