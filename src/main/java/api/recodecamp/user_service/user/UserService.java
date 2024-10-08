package api.recodecamp.user_service.user;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.recodecamp.user_service.role.Role;
import api.recodecamp.user_service.role.RoleRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create user
    public User createUser(User user) {
        /**
         * LocalDateTime updatedAt, String accountPasscode, Boolean accountConfirmation, String email, String password, String username, String firstName, String lastName
         */
        User valid = new User();
        return valid;
    };

    // Retrieve user by id
    public User getUserById(UUID id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Retrieve users by name
    public List<User> getUsersByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    // Retrieve all users
    public Set<Role> getRolesForUser(UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getRoles();  // Get roles for the user
    }

    // Add a role to a user
    public void addRoleToUser(UUID userId, String roleName) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            throw new RuntimeException("Role not found");
        }

        user.getRoles().add(role);  // Add role to user
        userRepository.save(user);  // Save updated user
    }

    // Other user-related methods
}

