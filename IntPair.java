package SortTwo;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class IntPair implements WritableComparable<IntPair> {
    private int first;
    private int second;

    public IntPair() {
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int compareTo(IntPair o) {
        if (first != o.first) {
            return first<o.first? 1:-1;
        }
        else if(second != o.second){
            return second<o.second?-1:1;
        }
        else {
            return 0;
        }
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(first);
        out.writeInt(second);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        first=in.readInt();
        second=in.readInt();
    }
    public int hashCode(int first,int second){
        return first*157+second;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(o instanceof IntPair){
            IntPair intPair = (IntPair) o;
            return first == intPair.first && second == intPair.second;
        }
        else {
            return false;
        }
    }
}
