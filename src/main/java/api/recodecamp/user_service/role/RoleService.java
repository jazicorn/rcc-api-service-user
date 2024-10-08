package api.recodecamp.user_service.role;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.recodecamp.user_service.user.User;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(String roleName) {
        Role role = new Role();
        role.setName(roleName);
        return roleRepository.save(role);
    }

    public Set<User> getUsersForRole(String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            throw new RuntimeException("Role not found");
        }
        return role.getUsers();
    }
}


