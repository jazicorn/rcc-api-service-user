package api.recodecamp.user_service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.recodecamp.user_service.user.User;

import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Create a new role
    @PostMapping
    public String createRole(@RequestParam String roleName) {
        try {
            RoleAccess.valueOf(roleName);
            roleService.createRole(roleName);
            return "Role created";
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    // Get users by role
    @GetMapping("/{roleName}/users")
    public Set<User> getUsersForRole(@PathVariable String roleName) {
        try {
            RoleAccess.valueOf(roleName);
            return roleService.getUsersForRole(roleName);    
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

