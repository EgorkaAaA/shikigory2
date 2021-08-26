package ru.egorkaaaa.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.egorkaaaa.demo.Entities.role;
import ru.egorkaaaa.demo.Entities.user;
import ru.egorkaaaa.demo.Exceptions.userAllReadyExistsException;
import ru.egorkaaaa.demo.Repositories.userRepo;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class userService implements UserDetailsService {
    private final userRepo userRepo;

    @Autowired
    public userService(userRepo userRepo) {
        this.userRepo = userRepo;
    }


    //CRUD user logic
    public void createUser(user user) throws userAllReadyExistsException {
        if(userRepo.findByUserName(user.getUserName()) == null) {
            user.setPassword(encoder().encode(user.getPassword()));
            userRepo.save(user);
        }
        else {
            throw new userAllReadyExistsException(String.format("User with name %s all ready exists", user.getUserName()));
        }
    }

    //Local password encoder because i have loop error if i reference on WebSecurityConfig
    private PasswordEncoder encoder () {
        return new BCryptPasswordEncoder();
    }

    //User detail service logic
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        user user = userRepo.findByUserName(userName);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User %s not found!", userName));
        }

        return new User(user.getUserName(), user.getPassword(), mapRolesToGrantedAuthority(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToGrantedAuthority(Collection<role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}
