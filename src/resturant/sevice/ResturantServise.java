package resturant.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import resturant.repository.doa.ResturantDoa;
import resturant.model.entity.Resturant;

import java.util.List;

@Component
public class ResturantServise {
    private ResturantDoa resturantDoa;
    private MenuService menuService;

    public ResturantServise() {
    }

    @Autowired
    public ResturantServise(ResturantDoa resturantDoa, MenuService menuService) {
        this.resturantDoa = resturantDoa;
        this.menuService = menuService;
    }

    private int maxCodeArea = 22;

    public boolean addNewRestaurant(Resturant restaurant) {
        if (restaurant != null) {
            if (restaurant.getName() != null
                    && restaurant.getName() != ""
                    && restaurant.getRegion() > 0
                    && restaurant.getRegion() <= maxCodeArea
                    && restaurant.getServiceprice() > 0) {
                resturantDoa.create(restaurant);
                return true;
            }
        }
        return false;
    }

    public boolean deleteRestaurantByName(String restaurantName) {
        if (restaurantName != null && restaurantName != "" && restaurantName != " ") {
            resturantDoa.delete(findRestaurantByName(restaurantName).get(0));
            return true;
        }
        return false;
    }

    public List<Resturant> findRestaurantByName(String restaurantName) {
        if (restaurantName != null && restaurantName != "" && restaurantName != " ") {
            return resturantDoa.findByName(restaurantName);
        }
        return null;
    }

    public List<Resturant> findRestaurantByMenuType(String menuType) {

        if (menuService.containsMenuType(menuType)) {
            return resturantDoa.findByType(menuType);
        }
        return null;
    }

    public List<Resturant> findRestaurantByCodeArea(int restaurantCodeArea) {
        if (restaurantCodeArea > 0 && restaurantCodeArea <= maxCodeArea) {
            return resturantDoa.findByRegion(restaurantCodeArea);
        }
        return null;
    }

    public List<Resturant> findAllRestaurants() {
        return resturantDoa.selectAll();
    }

    public void showRestaurantByCodeArea(int restaurantCodeArea) {
        List<Resturant> restaurants = findRestaurantByCodeArea(restaurantCodeArea);
        for (Resturant r : restaurants) {
            System.out.println("RestaurantName: " + r.getName() +
                    "  CodeArea: " + r.getRegion() +
                    "  SendCost: " + r.getServiceprice());
        }
    }

    public void showRestaurantByMenuType(String menuType) {
        List<Resturant> restaurants = findRestaurantByMenuType(menuType);
        for (Resturant r : restaurants) {
            System.out.println("RestaurantName: " + r.getName() +
                    "  CodeArea: " + r.getRegion() +
                    "  SendCost: " + r.getServiceprice());
        }
    }

    public void showAllRestaurants() {
        List<Resturant> restaurants = findAllRestaurants();
        for (Resturant r : restaurants) {
            System.out.println("RestaurantName: " + r.getName() +
                    "  CodeArea: " + r.getRegion() +
                    "  SendCost: " + r.getServiceprice());
        }
    }

    public boolean restaurantIsExist(String restaurantName) {
        Resturant restaurant = resturantDoa.findByName(restaurantName).get(0);
        if (restaurant != null) {
            return true;
        }
        return false;
    }
}
