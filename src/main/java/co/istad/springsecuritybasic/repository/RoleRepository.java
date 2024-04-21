package co.istad.springsecuritybasic.repository;

import co.istad.springsecuritybasic.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
