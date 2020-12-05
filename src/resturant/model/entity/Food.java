package resturant.model.entity;

import javax.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Menu menu;

    public Food(Menu menu) {
        this.menu = menu;
    }

    public Food(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Food(String name, String type, double price, Menu menu) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", menu=" + menu +
                '}';
    }

    public Food (){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
