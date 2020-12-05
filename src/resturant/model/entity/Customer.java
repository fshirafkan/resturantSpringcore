package resturant.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String phonenumber;
    private String name;
    @CreationTimestamp
    private Date datemodified;
    @Embedded
    private Address address;

    public Customer() {
    }

    public Customer(String phonenumber, String name, Address address) {
        this.phonenumber = phonenumber;
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(Date datemodified) {
        this.datemodified = datemodified;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "phonenumber='" + phonenumber + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
