package flight;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NameMapper extends Mapper<LongWritable, Text, WComparable, Text> {

    public NameMapper() {
        super();
    }
}
