package com.codewithprojects.springsecurity.repository;

import com.codewithprojects.springsecurity.entities.User;
import com.codewithprojects.springsecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

        /**
         * Find users by role.
         * @param role the role to filter users by
         * @return List of users with the given role
         */
        List<User> findByRole(Role role); // Return a list to handle multiple users for the same role

        /**
         * Find a user by email.
         * @param email the email of the user
         * @return an Optional containing the user if found, otherwise empty
         */
        Optional<User> findByEmail(String email);

}
