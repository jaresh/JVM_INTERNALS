package service;

import entities.Person;
import entities.Role;
import entities.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class UserService implements UserServiceInterface {

    private List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public List<User> findUsersWithAddressesCountMoreThan(int numberOfAddresses) {
    	return users.stream()
    			.filter(users -> users.getPersonDetails().getAddresses().size() > numberOfAddresses)
    			.collect(Collectors.toList());
    }

    public Person findOldestPerson() {
    	User oldest = users.stream()
    					.max((u1, u2) -> Integer.compare(u1.getPersonDetails().getAge(), u2.getPersonDetails().getAge()))
    					.get();
    	
    	return oldest.getPersonDetails();
    }

    public User findUserWithLongestUsername() {
    	User longestUsername = users.stream()
    							.max((u1, u2) -> Integer.compare(u1.getName().length(), u2.getName().length()))
    							.get();
    	
    	return longestUsername;
    }

    public String getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18() {
    	return users.stream()
    			.filter(users -> users.getPersonDetails().getAge() > 18)
    			.map(users -> users.getPersonDetails().getName())
    			.collect(Collectors.joining(","));
    }

    public List<String> getSortedPermissionsOfUsersWithNameStartingWith(String prefix) {
    	
    	return users.stream()
    			.filter(users -> users.getPersonDetails().getName().startsWith(prefix))
    			.map(users -> users.getPersonDetails().getRole().getPermissions().toString())
    			.sorted().collect(Collectors.toList());
    }

    public double getUsersAverageAge() {
    	
    	return users.stream()
    			.mapToInt(users -> users.getPersonDetails().getAge())
    		    .average().getAsDouble();
    }

    public void printCapitalizedPermissionNamesOfUsersWithSurnameStartingWith(String suffix) {
    	System.out.println( users.stream()
    			.filter(users -> users.getPersonDetails().getSurname().startsWith(suffix))
    			.map(users -> users.getPersonDetails().getRole().getPermissions().toString().toUpperCase())
    			.sorted().collect(Collectors.toList()));
    }

    public Map<Role, List<User>> groupUsersByRole() {
    	return users.stream()
    		.collect(Collectors.groupingBy(p -> p.getPersonDetails().getRole()));
    }

    public Map<Boolean, List<User>> partitionUserByUnderAndOver18() {
    	
    	return users.stream()
        		.collect(Collectors.partitioningBy(u -> u.getPersonDetails().getAge() < 18));
    }
}
