package resturant.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import resturant.model.entity.Address;
import resturant.model.entity.Customer;
import repository.MenuType;
import resturant.sevice.CustomerService;
import resturant.sevice.MenuService;
import resturant.sevice.ResturantServise;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class CustomerView {
    private Scanner scanner = new Scanner(System.in);
    private Customer customer = new Customer();
    private CustomerService customerService ;
    private MenuService menuService ;
    private ResturantServise restaurantService ;
    @Autowired
    public CustomerView(CustomerService customerService,MenuService menuService,ResturantServise resturantServise){
        this.customerService=customerService;
        this.menuService=menuService;
        this.restaurantService=resturantServise;
    }
    public String getCustomerMobileFromUser() {
        System.out.println("Enter Mobile Number: ");
        while (!scanner.hasNextLong()) {
            System.out.printf("Your input was \"%s\"." +
                    "\nPlease enter a number:%n", scanner.next());
        }
        String num = scanner.next();
        System.out.println(num);
        return num;
    }

    public String getCustomerFamilyFromUser() {
        System.out.println("Enter Your Family: ");
        while (true) {
            String family = scanner.nextLine();
            if (family != null && family.length() > 1) {
                return family;
            } else if (family == null) {
                System.out.println("Invalid input!Try again!");
            }
        }
    }

    public int getCodeAreaFromUser() {
        System.out.println("Enter Code Area: ");
        while (!scanner.hasNextInt()) {
            System.out.printf("Your input was \"%s\"." +
                    "\nPlease enter a number:%n", scanner.next());
        }
        int num = scanner.nextInt();
        System.out.println(num);
        return num;
    }

    public long getPostalCodeFromUser() {
        System.out.println("Enter Postal Code: ");
        while (!scanner.hasNextLong()) {
            System.out.printf("Your input was \"%s\"." +
                    "\nPlease enter a number:%n", scanner.next());
        }
        long num = scanner.nextLong();
        System.out.println(num);
        return num;
    }

    public String getAddressLocationFromUser() {
        System.out.println("Enter Address Location: ");
        while (true) {
            String addressLocation = scanner.nextLine();
            if (addressLocation != null && addressLocation.length() > 1) {
                return addressLocation;
            } else if (addressLocation == null) {
                System.out.println("Invalid input!Try again!");
            }
        }
    }

//    public void addCustomerAddress(Customer customer) {
//        customer.getAddress().setCodeArea(getCodeAreaFromUser());
//        customer.getAddress().setPostalCode(getPostalCodeFromUser());
//        customer.getAddress().getCustomerAddress();
//    }

    /*public Customer setNewCustomer() {
        this.customer.setCustomerMobileNumber(getCustomerMobileFromUser());
        this.customer.setCustomerFamily(getCustomerFamilyFromUser());
        addCustomerAddress(this.customer);
        return this.customer;
    }*/

    public boolean addNewCustomerToRepository(Customer customer) {
        if (customerService.addNewCustomer(customer)) {
            return true;
        }
        return false;
    }

    public void showCustomerMainOptions() {
        System.out.println("-------------------Customer Menu");
        System.out.println("Select Options:");
        System.out.println("1-Show All Restaurant\n" +
                "2-Show All Restaurant in your Area\n" +
                "3-Show Restaurant With Limited Food Type" +
                "4-Back To Main Menu");
    }

    public int getSelectedOptionFromCustomer(int firsNumber, int lastNumber) {
        int selectedOptions = 0;
        do {
            System.out.println("Enter Your Selected Number:  ");
            while (!scanner.hasNextInt()) {
                System.out.printf("Your input was \"%s\"." +
                        "\nPlease enter a number between 1 and 4 :%n", scanner.next());
            }
            selectedOptions = scanner.nextInt();
        } while (selectedOptions < firsNumber || selectedOptions > lastNumber);
        return selectedOptions;
    }

    public void BackToMainMenu() {

    }

    public void showSelectedRestaurantMenu() {
        System.out.println("Options:");
        System.out.println("1-Select Restaurant\n" +
                "2-Back To Customer Menu");
        System.out.println("Select 1 or 2 :");
    }

    public String getRestaurantNameFromCustomer() {
        String restaurantName = null;
        boolean checkRestaurantName = false;
        do {
            System.out.println("Enter Your Selected Restaurant Name:  ");
            restaurantName = scanner.next();
            checkRestaurantName = restaurantService.restaurantIsExist(restaurantName);
        } while (!checkRestaurantName);
        return restaurantName;
    }

    public void customerPanel() {
        this.customer.setPhonenumber(getCustomerMobileFromUser());
        Address address=new Address();
        this.customer.setAddress(address);
        this.customer.getAddress().setCodeArea(getCodeAreaFromUser());

        showCustomerMainOptions();
        int firstNumber = 1;
        int lastNumber = 4;
        int selectedOption = getSelectedOptionFromCustomer(firstNumber, lastNumber);

        switch (selectedOption) {
            case 1:
                System.out.println("-------------------Show All Restaurants");
                restaurantService.showAllRestaurants();
                //Build a method
                showSelectedRestaurantMenu();
                firstNumber = 1;
                lastNumber = 2;
                int selectedOptionForRestaurant = getSelectedOptionFromCustomer(firstNumber, lastNumber);
                switch (selectedOptionForRestaurant) {
                    case 1:
                        String selectedRestaurantName = getRestaurantNameFromCustomer();
                        //TODO
                        break;
                    case 2:
                        //TODO
                }
                break;
            case 2:
                System.out.println("-------------------Show Restaurants By CodeArea");
                restaurantService.showRestaurantByCodeArea(this.customer.getAddress().getCodeArea());
                //Build a Method
                break;
            case 3:
                System.out.println("-------------------Show Restaurants By MenuType");
                List<String> menuType = Stream.of(MenuType.values())
                        .map(Enum::name)
                        .collect(Collectors.toList());
                System.out.println("Valid Menu Type:");
                for (int i = 0; i < menuType.size(); i++) {
                    System.out.println((i + 1) + "-" + menuType.get(i));
                }
                boolean checkSelectedMenuType = false;
                String selectedMenuType = null;
                do {
                    System.out.println("Select MenuType:");
                    selectedMenuType = scanner.next();
                    checkSelectedMenuType = menuService.containsMenuType(selectedMenuType);
                } while (!checkSelectedMenuType);
                restaurantService.showRestaurantByMenuType(selectedMenuType);
                ////Build a Method
                break;
            case 4:
                //TODO
        }
    }
}
