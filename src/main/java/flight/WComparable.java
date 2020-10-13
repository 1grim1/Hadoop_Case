package flight;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.IOException;

public class WComparable implements WritableComparable {


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
