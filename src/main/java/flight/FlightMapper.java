package flight;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, WComparable,  Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String SEPARATOR = ",";
        if(key.get() != 0){
            String[] table = value.toString().split(SEPARATOR);
            int DEST_AIRPORT_ID_LEN = 14;

            int airportID = Integer.parseInt(table[DEST_AIRPORT_ID_LEN]);
            int ARR_DELAY_LEN = 17;
            double airportDelay = getDelay(table[ARR_DELAY_LEN]);
            if(airportDelay > 0.0){
                WComparable comparable = new WComparable(airportID, 1);
                context.write(comparable, new  Text(Double.toString(airportDelay)));
            }
       }
    }

    private double getDelay(String value) { return value.equals("") ? 0.0 : Double.parseDouble(value);}


}
