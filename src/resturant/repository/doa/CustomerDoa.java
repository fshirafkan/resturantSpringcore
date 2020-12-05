package resturant.repository.doa;

import org.springframework.stereotype.Component;
import resturant.model.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
@Component
public class CustomerDoa extends GenericDaoImpl<Customer, Integer> {
    Session session = DatabaseConnection.getSessionFactory().openSession();

    public boolean customerExisteance(String phonenumber) {
        boolean result = false;
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("select c.phonenumber from Customer  c where c.phonenumber=:phonenumber");
        q.setParameter("phonenumber", phonenumber);
        List<Customer> customers = q.getResultList();
        if (customers.size() != 0) {
            result = true;
        }
        transaction.commit();
        return result;


    }
}
