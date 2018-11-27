import java.util.Comparator;

/* Integer comparator for which any even number is inferior to any odd number so
 * that, for example, 3 is greater than 4. If an integer array is sorted increasingly
 *  using this comparator, it will show first all the even numbers, and then the odd ones.
 * */
public class ParityComparator<Integer> implements Comparator<Integer> {
    @Override
    public int compare(Object o1, Object o2) {
        int i1 = (int) o1;
        int i2 = (int) o2;
        if((i1%2 == 0 && (i1<i2 || i2%2 != 0)) || (i1%2 != 0 && i2%2!=0 && i1<i2)){
            return -1;
        }else if(i1 == i2){
            return 0;
        }else{
            return 1;
        }
    }
}
