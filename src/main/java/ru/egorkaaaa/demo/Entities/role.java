package ru.egorkaaaa.demo.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@Data
@Table(name = "roles")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, message = "name of Role must be more then 0 characters")
    private String name;

    public role(String name) {
        this.name = name;
    }
}
