package book.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUser {
    String password;
    String name;
    String role;
    int id;
}
