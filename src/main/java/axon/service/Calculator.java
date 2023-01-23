package axon.service;

import axon.model.OrderBook;
import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    private OrderBook firstData;
    private OrderBook secondData;
    private PriceLevel priceLevel;
    private CumulativeChange cumulativeChange;

    public Calculator(OrderBook firstData, OrderBook secondData) {
        if (firstData == null || secondData == null) {
            throw new NullPointerException();
        }
        this.firstData = firstData;
        this.secondData = secondData;
        priceLevel = new PriceLevel();
        cumulativeChange = new CumulativeChange();
    }

    public void writePriceLevelForBids() {
        writeToFile(priceLevel.getDifferencePriceLevels(firstData.getBids(), secondData.getBids(), "bids"),
                "bidsDiff" + firstData.getLastUpdateId() + "_" + secondData.getLastUpdateId() + ".txt");
    }

        public void writePriceLevelForAsks() {
        writeToFile(priceLevel.getDifferencePriceLevels(firstData.getAsks(), secondData.getAsks(), "asks"),
                "asksDiff" + firstData.getLastUpdateId() + "_" + secondData.getLastUpdateId() + ".txt");
    }

    public void writeCumulativeChangeByBids() {
        BigDecimal subtract = cumulativeChange.getCumulativeChange(firstData.getBids(), secondData.getBids());
        writeToFile(List.of("Cumulative change by bids: " + subtract.toString()),
                "cumulativeChangeByBids" + firstData.getLastUpdateId() + "_" + secondData.getLastUpdateId() + ".txt");
    }

    public void writeCumulativeChangeByAsks() {
        BigDecimal subtract = cumulativeChange.getCumulativeChange(firstData.getAsks(), secondData.getAsks());
        writeToFile(List.of("Cumulative change by asks: " + subtract.toString()),
                "cumulativeChangeByAsks" + firstData.getLastUpdateId() + "_" + secondData.getLastUpdateId() + ".txt");
    }

    private void writeToFile(List<String> data, String fileName) {
        LogWriter logWriter = new LogWriter(fileName);
        for (String datum : data) {
            logWriter.writeData(datum + "\n");
        }
        logWriter.closeBuffered();
    }
}
