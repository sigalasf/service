package com.boot.mocks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.boot.entites.Product;
import com.boot.entites.Role;
import com.boot.entites.User;
import com.boot.repositories.ProductRepository;
import com.boot.services.RoleService;
import com.boot.services.UserService;

@Component
@Order(2)
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final static String ROLE_ADMIN="ADMIN";
	private final static String ROLE_USER="USER";

	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProducts();
		loadUsers();
		loadRoles();
		assignUsersToUserRole();
		assignUsersToAdminRole();
	}

	private void loadProducts() {
		productRepository.save(new Product("235268845711068308", "Chemise Lacouste",
				"https://www.vision-naire.com/wp-content/uploads/2016/11/T-SHIRT-V-150x150.jpg", 35));
		productRepository.save(new Product("168639393495335947", "Pantalon Hugo Boot",
				"https://www.vision-naire.com/wp-content/uploads/2020/06/jogging-visionnaire-2-100x100.jpg", 56));
	}

	private void loadUsers() {
		User user1 = new User();
		user1.setUsername("user");
		user1.setPassword("user");
		userService.saveOrUpdate(user1);

		User user2 = new User();
		user2.setUsername("admin");
		user2.setPassword("admin");
		userService.saveOrUpdate(user2);

	}

	private void loadRoles() {
		Role roleUser = new Role();
		roleUser.setRole(ROLE_USER);
		roleService.saveOrUpdate(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setRole(ROLE_ADMIN);
		roleService.saveOrUpdate(roleAdmin);
	}

	private void assignUsersToUserRole() {
		List<Role> roles = roleService.listAll();
		List<User> users = userService.listAll();

		roles.forEach(role -> {

			if (role.getRole().equalsIgnoreCase(ROLE_USER)) {

				User user = users.stream().filter(u -> u.getUsername().equals("user")).findFirst().get();
				user.addRole(role);
				userService.saveOrUpdate(user);
				
			}
		});
		
		
	}

	private void assignUsersToAdminRole() {
		List<Role> roles = roleService.listAll();
		List<User> users = userService.listAll();

		roles.forEach(role -> {
			if (role.getRole().equalsIgnoreCase(ROLE_ADMIN)) {
				
				User user = users.stream().filter(u -> u.getUsername().equals("admin")).findFirst().get();
				user.addRole(role);
				userService.saveOrUpdate(user);

			}
		});
	}
}
