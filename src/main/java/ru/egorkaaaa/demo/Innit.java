package ru.egorkaaaa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.egorkaaaa.demo.Entities.role;
import ru.egorkaaaa.demo.Entities.user;
import ru.egorkaaaa.demo.Repositories.userRepo;

@Configuration
public class Innit {

//    @Autowired
//    public Innit(ru.egorkaaaa.demo.Repositories.roleRepo roleRepo,
//                 userRepo userRepo,
//                 PasswordEncoder passwordEncoder) {
//        roleRepo.save(new role("USER"));
//        roleRepo.save(new role("ADMIN"));
//
//        userRepo.save(new user("egor", passwordEncoder.encode("12345678"),roleRepo.findAll()));
//        userRepo.save(new user("egor2",passwordEncoder.encode("12345678"),roleRepo.findAll()));
//    }
}
