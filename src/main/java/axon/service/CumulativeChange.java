package axon.service;

import java.math.BigDecimal;

public class CumulativeChange {

    public BigDecimal getCumulativeChange(String[][] firstArray, String[][] secondArray) {
        return getSum(firstArray).subtract(getSum(secondArray));
    }

    private BigDecimal getSum(String[][] array) {
        BigDecimal returnValue = new BigDecimal(0);
        for (String[] value : array) {
            returnValue = returnValue.add(new BigDecimal(value[1]));
        }
        return returnValue;
    }
}
