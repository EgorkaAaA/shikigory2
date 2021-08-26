package ru.egorkaaaa.demo.Entities.Keys;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class animeCharactersKey implements Serializable {

    @Column(name = "anime_name")
    @NotNull
    private String animeName;

    @Column(name = "character_name")
    @NotNull
    private String characterName;
}
