package ru.egorkaaaa.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class user {
    @Id
    @Size(min = 3,max = 40,message = "userName must be between of 3 at 40 characters!")
    @NotNull
    @JoinColumn(name = "user_name")
    private String userName;

    public user(@NotNull String userName, @NotNull String password) {
        this.userName = userName;
        this.password = password;
    }

    @NotNull
    @Size(min = 8,max = 255, message = "Password must be more then 8 characters")
     private String password;

    @NotNull
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name="user_name"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Collection<role> roles;

}
