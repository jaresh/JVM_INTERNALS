package application;

import java.util.Arrays;
import java.util.List;

import entities.Address;
import entities.Permission;
import entities.Person;
import entities.Role;
import entities.User;

public class Data {

	public static List<User> prepareUsers() {
		
		List<Role> newRoles = prepareRoles();
		
		User user1 = new User();
		user1.setName("admin");
		user1.setPassword("admin1");
		
		Address address1 = new Address();
		address1.setCity("Gdansk");
		address1.setCountry("Poland");
		address1.setFlatNumber(23);
		address1.setStreetName("Taka");
		address1.setPostCode("82-223");
		
		Address address2 = new Address();
		address2.setCity("Gdansk");
		address2.setCountry("Poland");
		address2.setFlatNumber(54);
		address2.setStreetName("Slowackiego");
		address2.setPostCode("82-222");
		
		Person person1 = new Person();
		person1.setName("Jacek");
		person1.setSurname("Sikora");
		person1.setAge(24);
		person1.setRole(newRoles.get(0));
		person1.setPhoneNumbers(Arrays.asList("654564545","454545454"));
		person1.setAddresses(Arrays.asList(address1, address2));
		user1.setPersonDetails(person1);
		
		User user2 = new User();
		user2.setName("blazen123");
		user2.setPassword("mamhaslo123");
		
		Address address3 = new Address();
		address2.setCity("Kartuzy");
		address2.setCountry("Poland");
		address2.setFlatNumber(24);
		address2.setStreetName("Wybickiego");
		address2.setPostCode("83-300");
		
		Person person2 = new Person();
		person2.setName("Piotr");
		person2.setSurname("Blazen");
		person2.setAge(24);
		person2.setRole(newRoles.get(1));
		person2.setPhoneNumbers(Arrays.asList("07006655665","885545454-55"));
		person2.setAddresses(Arrays.asList(address3));
		user2.setPersonDetails(person2);
		
		User user3 = new User();
		user3.setName("takisobienick");
		user3.setPassword("jazda123");
		
		Person person3 = new Person();
		person3.setName("Magda");
		person3.setSurname("Molek");
		person3.setAge(16);
		person3.setRole(newRoles.get(1));
		person3.setPhoneNumbers(Arrays.asList("07044455665"));
		person3.setAddresses(Arrays.asList(address2));
		user3.setPersonDetails(person3);
		
		User user4 = new User();
		user4.setName("dluginickwhuk12345");
		user4.setPassword("haslo123");
		
		Person person4 = new Person();
		person4.setName("Tomasz");
		person4.setSurname("Musial");
		person4.setAge(50);
		person4.setRole(newRoles.get(2));
		person4.setPhoneNumbers(Arrays.asList("07044488"));
		person4.setAddresses(Arrays.asList(address1));
		user4.setPersonDetails(person4);
		
		return Arrays.asList(user1, user2, user3, user4);
	}

	public static List<Role> prepareRoles() {
		
		Permission writePerm = new Permission();
		writePerm.setName("Write");
		Permission readPerm = new Permission();
		readPerm.setName("Read");
		Permission updatePerm = new Permission();
		updatePerm.setName("Update");
		Permission deletePerm = new Permission();
		deletePerm.setName("Delete");
				
		Role role1 = new Role();
		role1.setName("Admin");
		role1.setPermissions(Arrays.asList(writePerm, readPerm, updatePerm, deletePerm));
		
		Role role2 = new Role();
		role2.setName("User");
		role2.setPermissions(Arrays.asList(readPerm, updatePerm));
		
		Role role3 = new Role();
		role3.setName("Guest");
		role3.setPermissions(Arrays.asList(readPerm));
		
		return Arrays.asList(role1, role2, role3);
	}

}
