package com.codewithprojects.springsecurity;

import com.codewithprojects.springsecurity.entities.User;
import com.codewithprojects.springsecurity.entities.Role;
import com.codewithprojects.springsecurity.repository.UserRepository;
import com.codewithprojects.springsecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Fetch the role "Admin" from the Role table
		Role adminRole = roleRepository.findByName(Role.ADMIN);

		// Check if an admin user already exists
		User adminAccount = userRepository.findByRole(adminRole).stream().findFirst().orElse(null);
		if (adminAccount == null) {
			User user = new User();
			user.setEmail("admin@gmail.com");
			user.setFirstName("admin");  // Updated field names
			user.setLastName("admin");   // Updated field names
			user.setRole(adminRole);     // Set the role to Admin
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
