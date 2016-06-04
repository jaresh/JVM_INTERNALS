package application;

import java.util.ArrayList;
import java.util.List;

import entities.User;
import service.UserService;

public class App {
	
    public static void main(String[] args) {
    	
    	List<User> users = new ArrayList<User>();
        users = Data.prepareUsers();
        UserService userService = new UserService(users);

        userService.findUsersWithAddressesCountMoreThan(1);
       	userService.findOldestPerson();
       	userService.findUserWithLongestUsername();
       	userService.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18();
       	userService.getSortedPermissionsOfUsersWithNameStartingWith("Jacek");
       	userService.getUsersAverageAge();
       	userService.printCapitalizedPermissionNamesOfUsersWithSurnameStartingWith("Sikora");
       	userService.groupUsersByRole();
       	userService.partitionUserByUnderAndOver18();
    }
}
