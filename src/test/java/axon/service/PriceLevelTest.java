package axon.service;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceLevelTest {

    @Test
    public void getDifferencePriceLevels_ok() {
        String[][] prevArray = {{"5.64", "2"}, {"5.65", "3"}};
        String[][] currentArray = {{"5.64", "3"}, {"5.66", "1"}};
        PriceLevel priceLevel = new PriceLevel();

        assertEquals(List.of("update [asks] (5.64, 1)", "new [asks] (5.66, 1)", "delete [asks] (5.65, 3)"),
                priceLevel.getDifferencePriceLevels(currentArray, prevArray, "asks"));
    }

}