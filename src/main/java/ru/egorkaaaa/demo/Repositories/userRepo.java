package ru.egorkaaaa.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.egorkaaaa.demo.Entities.user;

public interface userRepo extends JpaRepository<user, String> {
    user findByUserName(String s);
}
