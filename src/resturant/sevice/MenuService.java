package resturant.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import resturant.model.entity.Menu;
import repository.MenuType;
import resturant.repository.doa.MenuDao;

import java.util.List;
@Component
public class MenuService {
    MenuDao menuDao;
    @Autowired
    public MenuService(MenuDao menuDao){
        this.menuDao=menuDao;
    }
    public boolean addNewMenu(Menu menu) {
        if (menu != null && menu.getMenuName() != null &&
                menu.getMenuName() != "" && menu.getMenuType() != null) {
            menuDao.create(menu);
            return true;
        }
        return false;
    }

    public boolean deleteMenuByName(String menuName) {
        if (menuName != null && menuName != "" && menuName != " ") {
            menuDao.delete(findMenuByName(menuName));
            return true;
        }
        return false;
    }

    public Menu findMenuByName(String menuName) {
        if (menuName != null && menuName != "" && menuName != " ") {
            return menuDao.findByName(menuName);
        }
        return null;
    }

    public List<Menu> findMenuByType(String menuType) {
        if (menuType != null && menuType != "" && menuType != " ") {
            if (containsMenuType(menuType))
                return menuDao.findManuByType(menuType);
        }
        return null;
    }

    public boolean containsMenuType(String menuType) {
        for (MenuType type : MenuType.values()) {
            if (type.name().equals(menuType)) {
                return true;
            }
        }
        return false;
    }

    public void showMenuType() {
        for (MenuType type : MenuType.values()) {
            System.out.println(type.name());
        }
    }
}
