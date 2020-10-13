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
    public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
        return super.compare(b1, s1, l1, b2, s2, l2);
    }
}
