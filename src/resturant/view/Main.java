package resturant.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import resturant.configuration.SpringContext;

public class Main {


    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringContext.class);
        CustomerView customerView= (CustomerView) applicationContext.getBean("customerView");
        customerView.customerPanel();

    }
}
