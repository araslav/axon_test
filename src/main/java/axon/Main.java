package axon;

import axon.repository.OrderBookRepository;
import axon.service.Calculator;
import axon.service.mapper.OrderBookMapper;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    private static OrderBookRepository orderBookRepository;

    public static void main(String[] args) {
        orderBookRepository = new OrderBookRepository();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> future = executor.scheduleWithFixedDelay(() -> {
            someMethod();
        }, 0, 10, TimeUnit.SECONDS);
    }

    private static void someMethod() {
        OrderBookMapper orderBookMapper = new OrderBookMapper();
        orderBookRepository.add(orderBookMapper.getOrderBookObj());

        if (orderBookRepository.getSize() != 1) {
            Calculator calculator = new Calculator(orderBookRepository.get(orderBookRepository.getSize() - 1),
                    orderBookRepository.get(orderBookRepository.getSize() - 2));
            calculator.writeCumulativeChangeByBids();
            calculator.writeCumulativeChangeByAsks();
            calculator.writePriceLevelForBids();
            calculator.writePriceLevelForAsks();
        }
    }
}
