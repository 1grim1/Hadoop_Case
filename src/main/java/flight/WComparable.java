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
        dataOutput.writeInt(airportID);
        dataOutput.writeInt(group);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.airportID = dataInput.readInt();
        this.group = dataInput.readInt();
    }

    @Override
    public int compareTo(Object o){
        WComparable elem = (WComparable) o;
        return this.airportID - elem.airportID > 0 ? 1 :
                ((this.airportID - elem.airportID == 0) && (this.group - elem.group > 0 ) ? 1 : -1);
    }
}
