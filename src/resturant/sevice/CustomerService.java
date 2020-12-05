package resturant.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import resturant.repository.doa.CustomerDoa;
import resturant.model.entity.Customer;
@Component
public class CustomerService {
    private CustomerDoa customerDoa;
public  CustomerService(){}
    @Autowired
    public CustomerService(CustomerDoa customerDoa) {
        this.customerDoa = customerDoa;
    }
    public boolean searchCustomers(String phonenumber) {
        if(phonenumber!=null && phonenumber.length()>10) return customerDoa.customerExisteance(phonenumber);
        return false;
    }
    public boolean addNewCustomer(Customer customer) {
        if (customer != null && customer.getName() != null &&
                customer.getPhonenumber() !=null &&
                customer.getAddress().getCodeArea() > 0 &&
                customer.getAddress().getPostalCode() > 0 &&
                customer.getAddress().getCustomerAddress() != null) {

            if (!customerIsExist(customer.getPhonenumber())) {
                customerDoa.create(customer);
                return true;
            }
        }
        return false;
    }
    public boolean customerIsExist(String mobileNumber) {
        return customerDoa.customerExisteance(mobileNumber);

    }
}
