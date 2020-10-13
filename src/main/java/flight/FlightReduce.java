package flight;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlightReduce extends Reducer<WComparable, Text, Text, Text>{
    private final int COUNT = 0;

    @Override
    protected void reduce(WComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        super.reduce(key, values, context);
    }
}
