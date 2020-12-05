package resturant.repository.doa;


import org.springframework.stereotype.Component;
import resturant.model.entity.Resturant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import repository.MenuType;
import java.util.List;
@Component
public class ResturantDoa extends GenericDaoImpl<Resturant,Integer>{
    Session session = DatabaseConnection.getSessionFactory().openSession();

    public List<Resturant> findByName(String name){

        Criteria criteria = session.createCriteria(Resturant.class);
        criteria.add(Restrictions.eq("name", name));
        List<Resturant> list = criteria.list();
        session.close();
        return list;
    }

    public List<Resturant> findByType(String menuType) {

        Criteria criteria = session.createCriteria(Resturant.class, "restaurant");
        criteria.createAlias("restaurant.menus", "menus");
        criteria.createAlias("menus.menuType", "menuType");
        criteria.add(Restrictions.eq("menuType", MenuType.valueOf(menuType)));
        criteria.setResultTransformer(Transformers.aliasToBean(Resturant.class));
        List<Resturant> restaurants = criteria.list();
        session.getTransaction().commit();
        session.close();
        return restaurants;
    }

    public List<Resturant> findByRegion(Integer region){

        Criteria criteria = session.createCriteria(Resturant.class);
        criteria.add(Restrictions.eq("region", region));
        List<Resturant> list = criteria.list();
        session.close();
        return list;
    }
}
