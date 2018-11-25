import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.*;

public class HeapSortTest<E>{

    @Test
    public void sort(){
        ArrayList<Integer> toSort = new ArrayList<>();
        toSort.add(23);
        toSort.add(1);
        toSort.add(3);
        toSort.add(9);
        toSort.add(9);
        toSort.add(4);
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(3);
        sortedList.add(4);
        sortedList.add(9);
        sortedList.add(9);
        sortedList.add(23);

        assertNotEquals(sortedList,toSort);
        HeapSort.sort(toSort);
        assertEquals(sortedList,toSort);
    }
    @Test
    public void stringSorter(){
        ArrayList<String> toSort = new ArrayList<>();
        toSort.add("B");
        toSort.add("Z");
        toSort.add("A");
        toSort.add("C");
        toSort.add("Y");

        ArrayList<String> sorted = new ArrayList<>();
        sorted.add("A");
        sorted.add("B");
        sorted.add("C");
        sorted.add("Y");
        sorted.add("Z");
        
        assertNotEquals(sorted,toSort);
        HeapSort.sort(toSort);
        assertEquals(sorted,toSort);
    }
    @Test
    public void sortRandom(){
        ArrayList<Integer> toSort = new ArrayList<>();
        Random rand = new Random();
        for(long i=0;i<20;i++){
            toSort.add(rand.nextInt(20));
        }
        System.out.println(toSort.toString());
        HeapSort.sort(toSort);
        System.out.println(toSort);
    }

    @Test(expected = NullPointerException.class)
    public void nullCase(){
        ArrayList<Integer> toSort = new ArrayList<>();
        toSort.add(1);
        toSort.add(null);
        toSort.add(3);

        HeapSort.sort(toSort);
    }
    private void shuffleArray(){

        
    }
//    private int[] shuffleArray(int iterations){     //This function implements the Fisher Yates algorithm for shuffling
//        int random;                                 //an array
//        int temporal;
//        Random rng = new Random();
//        ArrayList<Integer> sortedArray = new ArrayList<>();
//        for (int i = 0; i < iterations; i++) {
//            random = i + rng.nextInt(sortedArray.size() - i);
//            temporal = sortedArray[random];
//            sortedArray[random] = sortedArray[i];       //swap
//            sortedArray[i] = temporal;
//        }
//        return sortedArray;
//    }
}