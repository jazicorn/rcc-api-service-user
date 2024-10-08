package api.recodecamp.user_service.user;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.recodecamp.user_service.role.Role;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Get users by name
    @GetMapping("/name/{name}")
    public List<User> getUsersByUsername(@PathVariable String name) {
        return userService.getUsersByUsername(name);
    }

    // Get roles for a user
    @GetMapping("/{userId}/roles")
    public Set<Role> getRolesForUser(@PathVariable UUID userId) {
        return userService.getRolesForUser(userId);
    }

    // Add role to a user
    @PostMapping("/{userId}/roles")
    public ResponseEntity<String> addRoleToUser(@PathVariable UUID userId, @RequestParam String roleName) {
        userService.addRoleToUser(userId, roleName);
        return ResponseEntity.ok("Role added to user");
    }
}

