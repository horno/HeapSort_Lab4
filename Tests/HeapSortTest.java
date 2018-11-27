import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class HeapSortTest{

    @Test
    public void integerSort(){
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
    public void comparatorSort(){
        ParityComparator<Integer> comp = new ParityComparator<>();
        ArrayList<Integer> toSort = new ArrayList<>();
        toSort.add(9);
        toSort.add(6);
        toSort.add(7);
        toSort.add(8);
        toSort.add(4);
        toSort.add(1);
        toSort.add(2);
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.add(2);
        sorted.add(4);
        sorted.add(6);
        sorted.add(8);
        sorted.add(1);
        sorted.add(7);
        sorted.add(9);

        HeapSort.sort(toSort,comp);
        assertEquals(sorted,toSort);
    }
    @Test
    public void sortFisherYates(){
        int arrayLength = 10000;
        ArrayList<Integer> toSort = sortedArray(arrayLength);   //Creating 2 sorted arrays from 1
        ArrayList<Integer> sorted = sortedArray(arrayLength);   //to arrayLength (1000)

        shuffleArray(toSort,arrayLength);       //Shuffling array with Fisher Yates algorithm
        HeapSort.sort(toSort);                  //Sorting the array with HeapSort
        assertEquals(sorted,toSort);            //Comparing it with the already sorted array
    }
    @Test(expected = NullPointerException.class)//TODO revisar null
    public void nullCase(){
        ArrayList<Integer> toSort = new ArrayList<>();
        toSort.add(1);
        toSort.add(null);
        toSort.add(3);

        HeapSort.sort(toSort);
    }
    private <E> void shuffleArray(ArrayList<E> array, int l){ //Fisher Yates algorithm to shuffle an array
        Random ran = new Random();
        int random;
        E aux;
        for(int i=1;i<l;i++){
            random = ran.nextInt(i);
            aux = array.get(random);
            array.set(random,array.get(i));
            array.set(i,aux);
        }
    }
    @Test
    public void shuffleTest(){
        int arrayLength = 1000;
        ArrayList<Integer> sortedList = sortedArray(arrayLength);
        ArrayList<Integer> toShuffle = sortedArray(arrayLength);
        shuffleArray(toShuffle,arrayLength);
        assertNotEquals(toShuffle,sortedList);
    }
    private ArrayList<Integer> sortedArray(int length){   //Creates a sorted array from 1 to length (parameter)
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=0;i<length;i++){
            array.add(i+1);
        }
        return array;
    }
    @Test
    public void sortArrayTest(){
        ArrayList<Integer> sortedArray = sortedArray(5);
        ArrayList<Integer> manuallySorted = new ArrayList<>();
        manuallySorted.add(1);
        manuallySorted.add(2);
        manuallySorted.add(3);
        manuallySorted.add(4);
        manuallySorted.add(5);

        assertEquals(sortedArray,manuallySorted);
    }
}