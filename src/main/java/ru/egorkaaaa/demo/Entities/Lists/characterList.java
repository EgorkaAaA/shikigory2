package ru.egorkaaaa.demo.Entities.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.egorkaaaa.demo.Entities.Keys.animeCharactersKey;
import ru.egorkaaaa.demo.Entities.anime;
import ru.egorkaaaa.demo.Entities.character;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class characterList {
    @EmbeddedId
    private animeCharactersKey id;

    @ManyToOne
    @NotNull
    @MapsId("animeName")
    @JoinColumn(name = "anime_name")
    private anime animeName;

    @ManyToOne
    @NotNull
    @MapsId("characterName")
    @JoinColumn(name = "character_name")
    private character characterName;
}
