package ru.egorkaaaa.demo.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "character")
public class character {
    @Id
    @NotNull
    @Size(min = 3, max = 40, message = "CharacterName must be between 3 and 40 characters!")
    @JoinColumn(name = "character_name")
    private String characterName;

}
