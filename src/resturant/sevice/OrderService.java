package resturant.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import resturant.repository.doa.OrdersDoa;
import resturant.model.entity.Orders;
@Component
public class OrderService {
    private OrdersDoa ordersDoa;
    @Autowired
    public OrderService(OrdersDoa ordersDoa) {
        this.ordersDoa = ordersDoa;
    }


    public boolean addNewOrder(Orders order) {
        if (order != null && order.getOrderedFood() != null) {
            ordersDoa.create(order);
            return true;
        }
        return false;
    }

    public Orders findOrderByTrackingCode(int trackingCode) {
        if (trackingCode > 0) {
            return ordersDoa.findByTrackingCode(trackingCode);
        }
        return null;
    }
}
