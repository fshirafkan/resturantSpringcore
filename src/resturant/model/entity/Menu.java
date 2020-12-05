package resturant.model.entity;

import repository.MenuType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String menuName;
    @Enumerated(EnumType.STRING)
    private MenuType menuType;
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Food> foods = new ArrayList<>();
    @ManyToOne
    private Resturant resturant;
    public Menu(String menuName, MenuType menuType) {
        this.menuName = menuName;
        this.menuType = menuType;
    }


    public Menu(String menuName, MenuType menuType, List<Food> foods) {
        this.menuName = menuName;
        this.menuType = menuType;
        this.foods = foods;

    }
    public Menu(String menuName, MenuType menuType, List<Food> foods, Resturant resturant) {
        this.menuName = menuName;
        this.menuType = menuType;
        this.foods = foods;
        this.resturant = resturant;
    }
    public Menu(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Resturant getResturant() {
        return resturant;
    }

    public void setResturant(Resturant resturant) {
        this.resturant = resturant;
    }
}

