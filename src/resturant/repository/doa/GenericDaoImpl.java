package resturant.repository.doa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private SessionFactory sf;
    private Class<T> entityType;
    private String entityName;


    public GenericDaoImpl() {
        this.sf = DatabaseConnection.getSessionFactory();
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.entityType = (Class) pt.getActualTypeArguments()[0];

        String name = entityType.getName();
        entityName = name.substring(name.lastIndexOf('.')+1);
    }

    @Override
    public void create(T t) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.persist(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public T read(PK id) {
        Session session = sf.openSession();
        session.beginTransaction();
        T t = session.get(entityType, id);
        session.getTransaction().commit();
        session.close();
        return t;
    }

    @Override
    public void update(T t) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(T t) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.remove(t);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<T> selectAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from " + entityName);
        List list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
