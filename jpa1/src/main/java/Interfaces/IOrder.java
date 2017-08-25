package Interfaces;

import Entity.Orders;

public interface IOrder {
    public Orders createOrder(Orders os);
    public Orders addOrderToCustomer(Orders o);
    public Orders getOrders(Long id);
}
