import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class HeapSortTest<E> {

    @Test
    public void sort() {
        ArrayList<Integer> listToSort = new ArrayList<>();
        listToSort.add(2);
        listToSort.add(1);
        listToSort.add(3);
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);

        assertNotEquals(listToSort,sortedList);
        HeapSort.sort(listToSort);
        assertEquals(listToSort,sortedList);
    }
    @Test
    public void sortRandom(){
        ArrayList<Integer> listToSort = new ArrayList<>();
        Random rand = new Random();
        for(long i=0;i<20;i++){
            listToSort.add(rand.nextInt(20));
        }
        System.out.println(listToSort.toString());
        HeapSort.sort(listToSort);
        System.out.println(listToSort);
    }
    @Test
    public void sort1() {
    }
}