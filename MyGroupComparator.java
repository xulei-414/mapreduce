package SortTwo;

import org.apache.hadoop.io.WritableComparator;

public class MyGroupComparator extends WritableComparator {
    protected MyGroupComparator(){
        super(IntPair.class,true);
    }
    public int compare(IntPair a,IntPair b){
        int first,second;
        first=a.getFirst();
        second=b.getSecond();
        return first==second ? 0:(first<second?-1:1);
    }
}