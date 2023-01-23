package axon.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceLevel {

    public List<String> getDifferencePriceLevels(String[][] firstArray, String[][] secondArray, String size) {
        Map<String, String> map = new HashMap<>();
        for (String[] item : secondArray) {
            map.put(item[0] , item[1]);
        }

        List<String> returnList = new ArrayList<>();
        for (String[] value : firstArray) {
            if (map.containsKey(value[0]) && map.get(value[0]).equals(value[1])) {
                map.remove(value[0], value[1]);
            } else if (map.containsKey(value[0])) {
                returnList.add("update [" + size + "] (" + value[0] + ", "
                        + (new BigDecimal(value[1]).subtract(new BigDecimal(map.get(value[0])))) + ")");
                map.remove(value[0], map.get(value[0]));
            } else {
                returnList.add("new [" + size + "] (" + value[0] + ", " + value[1] + ")");
            }
        }

        if(!map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                returnList.add("new [" + size + "] (" + entry.getKey() + ", " + entry.getValue() + ")");
            }
        }

        return returnList;
    }
}
