package co.istad.springsecuritybasic.repository;

import co.istad.springsecuritybasic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, String> {
}
