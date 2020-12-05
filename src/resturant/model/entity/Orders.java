package resturant.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ordercode;// it shouldnot be
    @ManyToOne(cascade = CascadeType.ALL)
    private Resturant resturant;
    private double totalOrderPrice;
    private Date orderDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ElementCollection
    @MapKeyColumn(name="count")
    private Map<Food,Integer> orderedFood= new HashMap<Food,Integer>();

    public Map<Food, Integer> getOrderedFood() {
        return orderedFood;
    }

    public void setOrderedFood(Map<Food, Integer> orderedFood) {
        this.orderedFood = orderedFood;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public Resturant getResturant() {
        return resturant;
    }

    public void setResturant(Resturant resturant) {
        this.resturant = resturant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public double getTotalPrice() {
        if (orderedFood == null || orderedFood.size() == 0)
            return 0;
        double totalPrice = resturant.getServiceprice();
        for (Map.Entry entery : orderedFood.entrySet()) {
            totalPrice += ((Food) entery.getKey()).getPrice() * ((int) entery.getValue());
        }
        this.totalOrderPrice = totalPrice;
        return totalPrice;
    }
    @Override
    public String toString() {
        return "Orders{" +
                ", ordercode='" + ordercode + '\'' +
                ", resturant=" + resturant +
                ", customer=" + customer +
                ", orderedFood=" + orderedFood +
                '}';
    }
}
