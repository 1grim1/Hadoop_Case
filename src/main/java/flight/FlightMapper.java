package flight;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, WritableComparable,  Text> {

    private static final String SEPARATOR = ",";

    private static final int AIRPORT_ID_LEN = 14;

    private static final int AIRPORT_DELAY_LEN = 17;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] table = value.toString().split(SEPARATOR);
        int airportID = Integer.parseInt(table[AIRPORT_ID_LEN]);
        double airportDelay = getDelay(table[AIRPORT_DELAY_LEN]);
        if(airportDelay > 0.0){
            WritableComparable comparable = new WritableComparable(airportID, 1);
            context.write(comparable, new  Text(Double.toString(airportDelay)));
        }

    }

    private double getDelay(String value) { return value.equals("") ? 0.0 : Double.parseDouble(value);}


}
