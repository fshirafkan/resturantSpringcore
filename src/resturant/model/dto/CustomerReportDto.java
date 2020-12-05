package resturant.model.dto;

import java.util.Date;

public class CustomerReportDto {
    private String customerName;
    private String customerPhoneNumber;
    private Date customerModificationDate;
    private double avgPerchuase;

    public CustomerReportDto(){}

    public CustomerReportDto(String customerName, String customerPhoneNumber, Date customerModificationDate, double avgPerchuase) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerModificationDate = customerModificationDate;
        this.avgPerchuase = avgPerchuase;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Date getCustomerModificationDate() {
        return customerModificationDate;
    }

    public void setCustomerModificationDate(Date customerModificationDate) {
        this.customerModificationDate = customerModificationDate;
    }

    public double getAvgPerchuase() {
        return avgPerchuase;
    }

    public void setAvgPerchuase(double avgPerchuase) {
        this.avgPerchuase = avgPerchuase;
    }
}
