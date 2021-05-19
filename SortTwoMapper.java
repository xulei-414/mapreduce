package SortTwo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortTwoMapper extends Mapper<LongWritable, Text, IntPair,IntWritable> {
    public IntPair outk=new IntPair();
    public IntWritable outv=new IntWritable();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\t");
        outk.setFirst(Integer.parseInt(split[1]));
        outk.setSecond(Integer.parseInt(split[0]));
        outv.set(Integer.parseInt(split[0]));
        context.write(outk,outv);
    }
}
