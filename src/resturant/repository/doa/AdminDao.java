package resturant.repository.doa;

import org.springframework.stereotype.Component;
import resturant.model.dto.CustomerReportDto;
import resturant.model.dto.ResturantReportDto;
import resturant.model.entity.Orders;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.time.LocalDate;
import java.util.*;
@Component
public class AdminDao {
    Session session = DatabaseConnection.getSessionFactory().openSession();

    public List<CustomerReportDto> getCustomersReport() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Orders.class, "orders");
        criteria.setProjection(Projections.projectionList()
             //   .add(Projections.groupProperty("customer"))
                .add(Projections.property("customers.name"))
                .add(Projections.property("customers.phonenumber"))
                .add(Projections.alias(Projections.sum("totalOrderPrice"), "totalSum"))
                .add(Projections.alias(Projections.property("orderDate"), "orderDate")));
        criteria.add(Restrictions.between("orderDate", LocalDate.now().minusYears(1), LocalDate.now()));
        criteria.setResultTransformer(Transformers.aliasToBean(CustomerReportDto.class));
        List<CustomerReportDto> reports = criteria.list();
        session.getTransaction().commit();
        session.close();
        return reports;

    }

    public List<ResturantReportDto> getResturantTotalServiceIncome() {
        session.beginTransaction();
        Query query = session.createQuery(
                "Select orders.resturant.name as restaurantName, " +
                        " orders.resturant.serviceprice as serviceprice, " +
                        "sum(orders.resturant.serviceprice) as sumofserviceprice FROM Orders orders " +
                        " group by orders.resturant");
        query.setResultTransformer(Transformers.aliasToBean(ResturantReportDto.class));
        List<ResturantReportDto> restaurants = query.list();
        session.getTransaction().commit();
        session.close();
        return restaurants;
    }



    public List<ResturantReportDto> getTheBestSellingFoodOfEachRestaurant() {

        session.beginTransaction();

      Query q = session.createQuery("select key(orders.orderedFood).name as foodName , sum(value(orders.orderedFood)) as totalamount ,orders.resturant.name as " +
              "resturantName  from Orders orders " +
              "group by resturantName, foodName");

        q.setResultTransformer(Transformers.aliasToBean(ResturantReportDto.class));
        List<ResturantReportDto> or= q.list();


        session.getTransaction().commit();
        session.close();
        return or;
    }

}
