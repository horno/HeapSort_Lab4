import org.junit.Test;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Comparator;

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

        System.out.println(listToSort.toString());
//        System.out.println(sortedList.toString());
        HeapSort.sort(listToSort);
        System.out.println(listToSort.toString());
    }

    @Test
    public void sort1() {
    }
}