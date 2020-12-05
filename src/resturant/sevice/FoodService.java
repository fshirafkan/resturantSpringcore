package resturant.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import resturant.repository.doa.FoodDoa;
import resturant.model.entity.Food;

import java.util.List;
@Component
public class FoodService {
    private FoodDoa foodDoa;
    @Autowired
    public FoodService(FoodDoa foodDoa) {
        this.foodDoa = foodDoa;
    }
    public boolean addNewFood(Food food) {
        if (food != null && food.getName() != null && food.getPrice() > 0) {
            foodDoa.create(food);
            return true;
        }
        return false;
    }



    public Food findFoodByName(String foodName) {
        if (foodName != null && foodName != "" && foodName != " ") {
            return foodDoa.findByName(foodName);
        }
        return null;
    }

    public List<Food> findFoodsListByPrice(long foodPrice) {
        if (foodPrice > 0) {
            return foodDoa.findByPrice(foodPrice);
        }
        return null;
    }

}
