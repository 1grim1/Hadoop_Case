package flight;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;

public class FlightJob  {
    public static void main(String[] args) throws Exception{
        if(args.length != 3){
            System.exit(-1);
        }

        //init
        Job job = Job.getInstance();
        job.setJarByClass(FlightJob.class);
        job.setJobName("");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, NameMapper.class);

        //setters
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(FlightPartitioner.class);
        job.setGroupingComparatorClass(GComparator.class);
        job.setReducerClass(Reduce.class);
        job.setMapOutputKeyClass(WComparable.class);
        job.setMapOutputValueClass(Text.class);

        //
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }
}