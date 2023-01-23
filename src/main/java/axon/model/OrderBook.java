package axon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

public class OrderBook {
    @JsonProperty("lastUpdateId")
    private long lastUpdateId;
    @JsonProperty("bids")
    private String[][] bids;
    @JsonProperty("asks")
    private String[][] asks;

    public long getLastUpdateId() {
        return lastUpdateId;
    }

    public String[][] getBids() {
        return bids;
    }

    public String[][] getAsks() {
        return asks;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "lastUpdateId=" + lastUpdateId
                + ", bids=" + Arrays.toString(bids)
                + ", asks=" + Arrays.toString(asks)
                + '}';
    }
}
