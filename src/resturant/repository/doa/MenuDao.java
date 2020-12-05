package resturant.repository.doa;

import org.springframework.stereotype.Component;
import resturant.model.entity.Menu;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.MenuType;

import java.util.List;
@Component
public class MenuDao extends GenericDaoImpl<Menu, Integer>{
    Session session = DatabaseConnection.getSessionFactory().openSession();

    public List<Menu> findManuByType(String menuType) {
        session.beginTransaction();
        String queryString = "from Menu where menuType=:mType";
        Query query = session.createQuery(queryString);
        query.setParameter("mType", MenuType.valueOf(menuType));
        List<Menu> menus = query.list();
        session.getTransaction().commit();
        session.close();
        return menus;
    }

    public Menu findByName(String menuName) {
        session.beginTransaction();
        String queryString = "from Menu where menuName=:mName";
        Query query = session.createQuery(queryString);
        query.setParameter("mName", menuName);
        List<Menu> menus =  query.list();
        Menu menu=menus.get(0);
        session.getTransaction().commit();
        session.close();

        return menu;
    }
}
