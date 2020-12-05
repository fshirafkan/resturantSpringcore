package resturant.model.entity;


import javax.persistence.*;


@Embeddable
public class Address {

    private int codeArea;
    private long postalCode;
    private String customerAddress;

    public Address() {
    }

    public Address(int codeArea, long postalCode, String customerAddress) {
        this.codeArea = codeArea;
        this.postalCode = postalCode;
        this.customerAddress = customerAddress;
    }


    public int getCodeArea() {
        return codeArea;
    }

    public void setCodeArea(int codeArea) {
        this.codeArea = codeArea;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "codeArea=" + codeArea +
                ", postalCode=" + postalCode +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
