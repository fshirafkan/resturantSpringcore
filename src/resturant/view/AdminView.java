//package resturant.view;
//
//import resturant.model.dto.CustomerReportDto;
//import resturant.model.dto.ResturantReportDto;
//import resturant.repository.doa.FoodDoa;
//import resturant.repository.doa.OrdersDoa;
//
//import java.util.List;
//
//public class AdminView {
//    OrdersDoa orderDao = new OrdersDoa();
//    static List<CustomerReportDto> customers;
//    static List<ResturantReportDto> restaurants;
//    public void getCustomersAndTheirTotalAmountOfPaymentsInRecentYear() {
//        customers = orderDao.getCustomersAndTheirTotalAmountOfPaymentsInRecentYear();
//    }
//
//    public static List<CustomerReportDto> getFilteredCustomerReport(int registrationMonth, int minTotalOrdersValue, int maxTotalOrdersValue) {
//        List<CustomerReportDto> filteredCustomers = customers.stream()
//                .filter(customer -> customer.getOrderDate().getMonthValue() == registrationMonth)
//                .filter(customer -> customer.getSumOfPayments() > minTotalOrdersValue && customer.getSumOfPayments() < maxTotalOrdersValue)
//                .collect(Collectors.toList());
//        return filteredCustomers;
//    }
//
//    //=====================================================================
//    public void getRestaurantsAndTheirTotalCourierFeeValue() {
//        restaurants = orderDao.getRestaurantsAndTheirTotalCourierFeeValue();
//    }
//
//    public Map getTheBestSellingFoodOfEachRestaurant() {
//        return orderDao.getTheBestSellingFoodOfEachRestaurant();
//    }
//
//    public List getFilteredRestaurantsReport(int serviceArea, int minTotalCourierFee, int maxTotalCourierFee) {
//        List<RestaurantOrderDto> filteredRestaurants = restaurants.stream()
//                .filter(restaurantOrderDto -> restaurantOrderDto.getServiceArea() == serviceArea)
//                .filter(restaurantOrderDto -> restaurantOrderDto.getSumOfCourierFees() > minTotalCourierFee
//                        && restaurantOrderDto.getSumOfCourierFees() < maxTotalCourierFee)
//                .collect(Collectors.toList());
//        return filteredRestaurants;
//    }
//}
