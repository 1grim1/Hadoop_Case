package flight;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WComparable implements WritableComparable {

    private int airportID;

    private int group;

    WComparable(int airportID, int group){
        this.airportID = airportID;
        this.group = group;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }

    @Override
    public int compareTo(WritableComparable elem) {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
