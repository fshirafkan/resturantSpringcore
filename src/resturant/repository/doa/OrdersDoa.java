package resturant.repository.doa;

import org.springframework.stereotype.Component;
import resturant.model.entity.Food;
import resturant.model.entity.Orders;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;
@Component
public class OrdersDoa extends GenericDaoImpl<Orders, Integer> {

    Session session = DatabaseConnection.getSessionFactory().openSession();

    public boolean findFoodInOrder(Orders order, Food food) {
        for (Map.Entry<Food, Integer> orderedFood : order.getOrderedFood().entrySet()) {
            if (orderedFood.getKey().equals(food)) {
                return true;
            }
        }
        return false;
    }
    public Orders findByTrackingCode(int trackingCode) {
        session.beginTransaction();
        String queryString = "from Orders where ordercode=:tCode";
        Query query = session.createQuery(queryString);
        query.setParameter("tCode", trackingCode);
        List<Orders> orders= query.list();
        Orders order = orders.get(0);
        session.getTransaction().commit();
        session.close();
        return order;
    }

}
