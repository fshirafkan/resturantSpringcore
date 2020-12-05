package resturant.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Resturant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer region;
    private double serviceprice;//delivery amount
    @OneToMany( cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    public Resturant(String name, Integer region, double serviceprice, List<Menu> menus) {
        this.name = name;
        this.region = region;
        this.serviceprice = serviceprice;
        this.menus = menus;
    }
    public Resturant(){}

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

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

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public double getServiceprice() {
        return serviceprice;
    }

    public void setServiceprice(double serviceprice) {
        this.serviceprice = serviceprice;
    }

    @Override
    public String toString() {
        return "Resturant{" +
                "name='" + name + '\'' +
                ", region=" + region +
                ", serviceprice=" + serviceprice +

                '}';
    }
}
