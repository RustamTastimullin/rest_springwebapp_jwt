package ru.webapp.springwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webapp.springwebapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
