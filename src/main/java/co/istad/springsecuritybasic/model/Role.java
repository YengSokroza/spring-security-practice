package co.istad.springsecuritybasic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String description;

    @ManyToMany
    Set<Authority> authorities;


    //ROLE_ + this.name  such as ROLE_USER , ROLE_ADMIN
    @Override
    public String getAuthority() {
        return "ROLE_" + this.name;
    }
}
