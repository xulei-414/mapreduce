package SortTwo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortTwoReducer extends Reducer<IntPair, IntWritable,IntWritable,IntWritable> {
    public IntWritable outk=new IntWritable();
    @Override
    protected void reduce(IntPair key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        for (IntWritable value : values) {
            outk.set(key.getFirst());
            context.write(outk,value);
        }
    }
}
