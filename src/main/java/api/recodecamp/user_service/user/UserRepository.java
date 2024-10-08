package api.recodecamp.user_service.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {   
    // Custom query methods based on method names
    List<User> findByUsername(String name);  // Find users by their name

    // You can add more methods as needed
}
