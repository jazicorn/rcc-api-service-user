package api.recodecamp.user_service.user;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import api.recodecamp.user_service.role.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    private String ipAddress;
    private String accountPasscode;
    private final Boolean accountConfirmation = false;
    private String email;
    private String password;
    private String username;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)  // EAGER fetch to immediately load roles with user
    @JoinTable(
        name = "user_roles",  // Join table name
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;  // A user can have multiple roles

    @Builder
    public User(LocalDateTime updatedAt, String accountPasscode, Boolean accountConfirmation, String email, String password, String username, String firstName, String lastName) {
        this.accountPasscode = accountPasscode;
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

