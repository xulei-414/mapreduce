package SortTwo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<IntPair, IntWritable> {

    @Override
    public int getPartition(IntPair intPair, IntWritable intWritable, int i) {
        return (intPair.hashCode(intPair.getFirst(),intPair.getSecond())&Integer.MAX_VALUE) % i;
    }
}
