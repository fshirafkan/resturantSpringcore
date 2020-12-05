package resturant.repository.doa;

import org.springframework.stereotype.Component;
import resturant.model.entity.Food;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import repository.MenuType;

import java.util.List;
@Component
public class FoodDoa extends GenericDaoImpl<Food, Integer> {
    Session session = DatabaseConnection.getSessionFactory().openSession();

    public Food findByName(String foodName) {
        session.beginTransaction();
        String queryString = "from Food where name=:fName";
        Query query = session.createQuery(queryString);
        query.setParameter("fName", foodName);
        List<Food> foods = query.list();
        Food food = foods.get(0);
        session.getTransaction().commit();
        session.close();
        return food;
    }

    public List<Food> findByPrice(long foodPrice) {
        session.beginTransaction();
        String queryString = "from Food where price>=:fPrice";
        Query query = session.createQuery(queryString);
        query.setParameter("fPrice", foodPrice);
        List<Food> foods = query.list();
        session.getTransaction().commit();
        session.close();
        return foods;
    }

    public List<Food> searchFoodsByMenuType(String menuType) {
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Food.class, "food");
        criteria.createAlias("food.menu", "menu");
        criteria.createAlias("menu.menuType", "menuType");
        criteria.add(Restrictions.eq("menuType", MenuType.valueOf(menuType)));
        criteria.setResultTransformer(Transformers.aliasToBean(Food.class));
        List<Food> foods = criteria.list();
        session.getTransaction().commit();
        session.close();
        return foods;

    }

    public List<Food> searchFoodsByMenuName(String menuName) {
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Food.class, "food");
        criteria.createAlias("food.menu", "menu");
        criteria.createAlias("menu.menuName", "menuName");
        criteria.add(Restrictions.eq("menuName", MenuType.valueOf(menuName)));
        criteria.setResultTransformer(Transformers.aliasToBean(Food.class));
        List<Food> foods = criteria.list();
        session.getTransaction().commit();
        session.close();
        return foods;

    }


}
