package SortTwo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class SortTwoDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setJarByClass(SortTwoDriver.class);
        job.setMapperClass(SortTwoMapper.class);
        job.setPartitionerClass(MyPartitioner.class);
        job.setNumReduceTasks(6);
        job.setGroupingComparatorClass(MyGroupComparator.class);
        job.setReducerClass(SortTwoReducer.class);
        job.setMapOutputKeyClass(IntPair.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.setInputPaths(job,new Path("F:\\IDEA\\intput\\goods_visit2"));
        FileOutputFormat.setOutputPath(job,new Path("F:\\IDEA\\output_sorttwo"));
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
