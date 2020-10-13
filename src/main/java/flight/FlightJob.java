package flight;

import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;

public class FlightJob  {
    public static void main(String[] args) throws Exception{
        if(args.length != 3){
            System.exit(-1);
        }

        Job job = Job.getInstance();
        job.setJarByClass(FlightJob.class);
        job.setJobName("Job");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
    }
}