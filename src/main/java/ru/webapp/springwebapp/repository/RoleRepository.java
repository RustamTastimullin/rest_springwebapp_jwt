package ru.webapp.springwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webapp.springwebapp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
