package flight;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.IOException;

public class GComparator extends WritableComparator {

    protected GComparator(){
        super(WComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return super.compare(a, b);
    }
}
