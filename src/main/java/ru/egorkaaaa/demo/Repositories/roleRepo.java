package ru.egorkaaaa.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.egorkaaaa.demo.Entities.role;

@Repository
public interface roleRepo extends JpaRepository<role,Integer> {
}
