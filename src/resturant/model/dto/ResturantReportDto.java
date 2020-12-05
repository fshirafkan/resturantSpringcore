package resturant.model.dto;

public class ResturantReportDto {
private String resturantName;
private double totalamount;
private String foodName;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public String getResturantName() {
        return resturantName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    @Override
    public String toString() {
        return "ResturantReportDto{" +
                "resturantName='" + resturantName + '\'' +
                ", amount=" + totalamount +
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
