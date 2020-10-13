package flight;

import org.apache.hadoop.mapreduce.Job;

public class FlightJob {
    public static void main(String[] args){
        if(args.length != 3){
            System.exit(-1);
        }

        Job job = Job.getInstance();
    }
}