package org.example.nixnoughtnothing.order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrderList() {
        return orderRepository.getOrderList();
    }

    @Transactional
    public Order createOrder(Order order) {
        if (order == null || order.reference() == null || order.reference().isBlank()) {
            throw new IllegalArgumentException("Order reference must not be blank");
        }

        var orderEntity = new OrderEntity();
        orderEntity.setReference(order.reference());

        var savedOrder = orderRepository.save(orderEntity);

        return Order.builder()
                .reference(savedOrder.getReference())
                .build();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(u -> Order.builder().reference(u.getReference()).build());
    }
}
