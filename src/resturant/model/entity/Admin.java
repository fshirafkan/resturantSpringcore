package resturant.model.entity;


public class Admin {
    private Integer id;
    private static String adminUsername = "admin";
    private static String adminPassword = "admin";


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getAdminUsername() {
        return adminUsername;
    }

    public static void setAdminUsername(String adminUsername) {
        Admin.adminUsername = adminUsername;
    }

    public static String getAdminPassword() {
        return adminPassword;
    }

    public static void setAdminPassword(String adminPassword) {
        Admin.adminPassword = adminPassword;
    }

}
