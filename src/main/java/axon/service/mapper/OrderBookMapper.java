package axon.service.mapper;

import axon.model.OrderBook;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class OrderBookMapper {
    private static final String URL_STRING = "https://api.binance.com/api/v3/depth?symbol=LINKUSDT&limit=5000";
    private ObjectMapper objectMapper;
    private URL url;

    public OrderBookMapper() {
        this.objectMapper = new ObjectMapper();
        try {
            this.url = new URL(URL_STRING);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Can't parse url " + URL_STRING, e);
        }
    }

    public OrderBook getOrderBookObj() {
        OrderBook orderBook;
        try {
            orderBook = objectMapper.readValue(url, OrderBook.class);
        } catch (IOException e) {
            throw new RuntimeException("Can't parse data!", e);
        }
        return orderBook;
    }
}
