package axon.repository;

import axon.model.OrderBook;
import java.util.ArrayList;
import java.util.List;

public class OrderBookRepository {
    private List<OrderBook> orderBookList = new ArrayList<>();

    public void add(OrderBook orderBook) {
        orderBookList.add(orderBook);
    }

    public OrderBook get(int index) {
        return orderBookList.get(index);
    }

    public int getSize() {
        return orderBookList.size();
    }
}
