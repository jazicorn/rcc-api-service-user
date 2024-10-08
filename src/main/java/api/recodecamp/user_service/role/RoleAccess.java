package api.recodecamp.user_service.role;

public enum RoleAccess {
    GUEST("Guest"),
    USER("User"),
    ADMIN("Admin");

    private final String role;

    RoleAccess(String role) {
        this.role = role;
    }

    // Override toString method to return custom string
    @Override
    public String toString() {
        return role;
    }
    
    // Method to get enum by string
    public static RoleAccess fromString(String roleName) {
        for (RoleAccess role : RoleAccess.values()) {
            if (role.toString().equalsIgnoreCase(roleName)) {
                return role;
            }
        }
        throw new IllegalArgumentException("No enum constant for role: " + roleName);
    }
}
